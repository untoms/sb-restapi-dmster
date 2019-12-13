package com.example.springbootrest.dtos;

public class UserMsDto {

    private Long userId;
    private String userName;
    private String emailAddress;
    private String roleName;

    public UserMsDto() {
    }

    public UserMsDto(Long userId, String userName, String emailAddress, String roleName) {
        this.userId = userId;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.roleName = roleName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
