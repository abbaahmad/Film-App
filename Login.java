package com.accenture.itfactory.base.FilmApplication;

import java.util.*;
//import java.util.List;

public class Login {
    private List<User> userList;
    List<User> adminList;
    HashSet<User> userSet;
    Map<String,String> userData;
    //protected static int num_of_users;
    protected static boolean isInUserList;

    public Login()
    {
        userList = new ArrayList<>();
        adminList = new ArrayList<>();
        userSet = new HashSet<>();
        userData = new HashMap<>();
        isInUserList = false;
        //num_of_users = 0;
    }
    public void addUser(User newUser){
        //userList.add(newUser);
        userSet.add(newUser);
        if(userSet.contains(newUser))
            userData.put(newUser.login,newUser.password);
        //num_of_users++;
    }
    /*public void addUser(String newName,String newLogin,String newPassword) throws Exception {
        try{
            if(isUser(newLogin,newPassword)) {
                userList.add(new User());
                userList.get(userList.size() - 1).name = newName;
                userList.get(userList.size() - 1).login = newLogin;
                userList.get(userList.size() - 1).password = newPassword;
                //num_of_users++;
            }
        }
        catch (final Exception e){
            throw new Exception("User already exist",e);
        }
    }*/
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

    /*public /*String*//* boolean isUser(String userLogin,String userPassword) throws Exception {
        boolean correctLogin = false;
        boolean correctPassword = false;
        String message = "";
        try{
            if(userData.containsKey(userLogin)){
                if(userData.get(userLogin).equals(userPassword))
                    /*message = "Welcome back";/*//*correctLogin = correctPassword = true;
                else{
                    //message = "Wrong password";
                    correctLogin = true;
                    correctPassword = false;
                }
            }
        }
        catch (Exception e){
            throw new Exception("Wrong password");
        }
        return message;
        //if(correctPassword && correctLogin)
        //    return true;
        //else
        //    return false;
    }*/
    /*public boolean isUser(String userLogin,String userPassword){
        boolean isCorrectInputs = false;
        for(User u : userList){
            if(u.login.equals(userLogin)) {
                isInUserList = true;
                if(u.password.equals(userPassword))
                    isCorrectInputs = true;
                else
                    isCorrectInputs = false;
            }
        }
        return isCorrectInputs;
    }*/

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
    /* public void addAdmin(User new_admin){
        adminList.add(new_admin);
        num_of_users++;
    }*/
    /*public void addAdmin(String new_admin_name,String new_login,String new_password){
        adminList.add(new User());
        adminList.get(adminList.size()-1).name = new_admin_name;
        adminList.get(adminList.size()-1).login = new_login;
        adminList.get(adminList.size()-1).password = new_password;
    }*/
    public List<User> getUserList(){return userList;}
    //public List<User> getAdminList() {return adminList;}
}
