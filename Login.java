package com.accenture.itfactory.base.FilmApplication;

import java.util.*;

public class Login {
    private List<User> userList;
    List<User> adminList;
    HashSet<User> userSet;
    Map<String,String> userData;
    protected static boolean isInUserList;

    public Login()
    {
        userList = new ArrayList<>();
        adminList = new ArrayList<>();
        userSet = new HashSet<>();
        userData = new HashMap<>();
        isInUserList = false;
    }
    public void addUser(User newUser){
        userSet.add(newUser);
        if(userSet.contains(newUser))
            userData.put(newUser.login,newUser.password);
    }
    public void addUser(String newName,String newLogin,String newPassword){
        User newUser = new User(newName,newLogin,newPassword);
        userSet.add(newUser);
        if(userSet.contains(newUser))
            userData.put(newLogin,newPassword);
    }
    public boolean checkLogin(String userLogin, String userPassword) throws Exception {
        boolean correctLogin = false;
        boolean correctPassword = false;

        if(userData.containsKey(userLogin)) {
            correctLogin = true;
            if (userData.get(userLogin).equals(userPassword))
                correctPassword = true;
            else
                correctPassword = false;
        }
        else
            correctLogin = false;

        if(correctLogin && !correctPassword)
            throw new Exception("Wrong password");
        if(!correctLogin)
            throw new Exception("Wrong login");
        if(!correctLogin && !correctPassword)
            throw new Exception("Wrong login and password");
        boolean result = correctPassword && correctLogin;
        return result;
    }

    public boolean isAdmin(String adminLogin,String adminPassword){
        boolean isCorrectInputs = false;
        for(User u : adminList){
            if(u.login.equals(adminLogin)) {
                if(u.password.equals(adminPassword))
                    isCorrectInputs = true;
                else
                    isCorrectInputs = false;
            }
        }
        return isCorrectInputs;
    }
    public List<User> getUserList(){return userList;}
}
