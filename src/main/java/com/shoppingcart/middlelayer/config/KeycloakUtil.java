package com.shoppingcart.middlelayer.config;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
public class KeycloakUtil {

    @Value("${keycloak.auth-server-url}")
    private String BASE_URL;

//    @Value("${keycloak.adminUname}")
//    private String USERNAME;
//    @Value("${keycloak.adminPwd}")
//    private String PASSWORD;

    public static final String USERS = "/users/";
    public List<RoleRepresentation> getRoleMappingsByUser(String userId) {
        List<RoleRepresentation> roleRepresentations = null;
        try {
            String realm = getKeycloakSecurityContext().getRealm();
            String url = BASE_URL + "admin/realms/" + realm +
                    USERS + userId + "/role-mappings/realm/composite";
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + getToken().get("access_token"));

            HttpEntity<String> request = new HttpEntity<>(headers);
            ResponseEntity<RoleRepresentation[]> response = restTemplate.exchange(url, HttpMethod.GET, request, RoleRepresentation[].class);
            roleRepresentations = Arrays.asList(Objects.requireNonNull(response.getBody()));
        } catch (Exception e) {
//            LOGGER.error("Error while retreiving role mappings for user:" + userId, e);
        }
        return roleRepresentations;
    }

    private KeycloakSecurityContext getKeycloakSecurityContext() {
        KeycloakPrincipal principal = (KeycloakPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getKeycloakSecurityContext();
    }

    public Map<String, String> getToken() {
        HttpHeaders headers = new HttpHeaders();
        String auth = "admin-cli" + ":" + "";
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
        String authHeader = "Basic " + encodedAuth;

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("username", "krishnapraneethpn");
        map.add("password", "praneeth123");
        map.add("grant_type", "password");
        map.add("client_id", "admin-cli");
        map.add("scope", "openid");
        map.add("Authorization", authHeader);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        //Get Acess token from endpoint
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> tokenMap = new LinkedHashMap<>();
        try {
            Object tokenObj = restTemplate.postForObject(BASE_URL + "/realms/master/protocol/openid-connect/token", request, Object.class);
            tokenMap = (LinkedHashMap<String, String>) tokenObj;;
        } catch (Exception ex) {
            System.out.println(ex.getCause());
        }


//        System.out.println("------" + tokenMap.get("access_token"));
        return tokenMap;
    }
}
