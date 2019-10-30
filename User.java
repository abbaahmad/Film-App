package com.accenture.itfactory.base.FilmApplication;

public class User
{
    protected String name;
    protected String login;
    protected String password;

    public User(){
        name = "";
        login ="";
        password = "";
    }
    public User(String newName, String newLogin, String newPassword){
        name = newName;
        login = newLogin;
        password = newPassword;
    }
}
