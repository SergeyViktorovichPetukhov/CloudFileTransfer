package com.GeekCloud.common;

public class AuthorizationMessage extends AbstractMessage {
    private String login;
    private String password;
    public String getLogin(){return login;}
    public String getPassword(){return password;}

    public AuthorizationMessage(String log, String pass){
        this.login = log;
        this.password = pass;
    }
}
