package com.shoppingcart.middlelayer.dto;

//@Setter
//@Getter
//@NoArgsConstructor
//@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class User {
    private Integer id;
    private String userName;
    private String emailId;
    private String gender;
    private String firstName;
    private String lastName;
    private String password;

    // {"id":0,"userName":"test","emailId":"","gender":"","firstName":"","lastName":"","password":"test"}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}