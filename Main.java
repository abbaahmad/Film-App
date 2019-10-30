package com.accenture.itfactory.base.FilmApplication;

import java.nio.file.FileSystems;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //FilmDatabase filmDatabase = new FilmDatabase();
    	// write your code here
        //filmDatabase.addFilm("RED","red2012","Action","Action,thriller",new Date(2019,10,30), 7.0,"Has bruce willis and MJP");
        //String path = "C:\\Users\\Abba Ahmad\\Desktop\\JavaProjects\\FilmDir\\FilmDatabase.xml";
        Login loginPage = new Login();
        UserPage userPage = new UserPage();
        boolean correctLogin = false;
        String abspath = FileSystems.getDefault().getPath(".").toAbsolutePath().toString();
        String path = abspath + "\\FilmDatabase.xml";
        //filmDatabase.saveData(path);
        //filmDatabase.loadData(path);
        System.out.println("Choose an option please: ");
        System.out.println("1 - Login as User\n 2 - Login as Admin\n 3 - Sign Up\n");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        if(choice == 1){        //Login as User
            System.out.println("Enter login:");
            String enteredLogin = in.nextLine();
            System.out.println("Enter password");
            String enteredPassword = in.nextLine();
            try {
                correctLogin = loginPage.checkLogin(enteredLogin, enteredPassword);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        if(choice == 2){            //Login as Admin
            System.out.println("Enter login:");
            String enteredLogin = in.nextLine();
            System.out.println("Enter password");
            String enteredPassword = in.nextLine();
            correctLogin = loginPage.isAdmin(enteredLogin,enteredPassword);
        }
        if(choice == 3){            //Sign Up
            System.out.println("Enter name:");
            String enteredName = in.nextLine();
            System.out.println("Enter login:");
            String enteredLogin = in.nextLine();
            System.out.println("Enter password");
            String enteredPassword = in.nextLine();
            loginPage.addUser(enteredName,enteredLogin,enteredPassword);
            try {
                correctLogin = loginPage.checkLogin(enteredLogin, enteredPassword);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        if(correctLogin){
            System.out.println("1- View films\n 2- Search films\n 3- Add review");
            choice = in.nextInt();
            if(choice == 1){    //view films
                userPage.viewFilms();
            }
            if(choice == 2){    //Search films
                System.out.println("Enter any film parameter: \n");
                String input = in.nextLine();
                userPage.search(input);
            }
            if(choice == 3){    //Add review
                System.out.println("Enter film name and then review: \n");
                String input = in.nextLine();
                //parsing logic
                //pass parameters
            }
        }
        else
            System.out.println("Sorry, you're not allowed");
        System.out.println("Done");
    }
}
