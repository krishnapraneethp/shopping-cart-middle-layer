package com.shoppingcart.middlelayer.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.keycloak.adapters.springsecurity.account.KeycloakRole;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class KeycloakAuthProvider extends KeycloakAuthenticationProvider {

    private static final Logger LOGGER = LogManager.getLogger(KeycloakAuthProvider.class);

    @Autowired
    private KeycloakUtil keycloakUtil;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) authentication;
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        String userId = token.getAccount().getKeycloakSecurityContext().getToken().getSubject();
        List<String> permissions = getUserPermissions(userId); // Load Permissions from Keycloak
        permissions.remove("uma_authorization");
        permissions.remove("offline_access");
        permissions.remove("user");

        for (String permission : permissions) {
            grantedAuthorities.add(new KeycloakRole(permission));
        }
        return new KeycloakAuthenticationToken(token.getAccount(), token.isInteractive(), grantedAuthorities);
    }

    private List<String> getUserPermissions(String userId) {
        List<String> permissions = new ArrayList<>();
        try {

            List<RoleRepresentation> roleRepresentations = keycloakUtil.getRoleMappingsByUser(userId);
            roleRepresentations.forEach(role -> permissions.add(role.getName()));
        } catch (Exception e) {
            LOGGER.error("Error while retrieving permissions for user: " + userId + " Error:" + e.getMessage());
        }
        return permissions;
    }

}
