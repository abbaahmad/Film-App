package com.accenture.itfactory.base.FilmApplication;

import java.util.Date;

public class Admin extends User {

    FilmDatabase filmDatabase;

    public Admin(){
        filmDatabase = new FilmDatabase();
    }

    public void addFilm(String fName, String fId, String fType, String fGenre, Date fDate,
                        double fRating, String fDescription){
        //add films
        filmDatabase.addFilm(fName,fId,fType,fGenre,fDate,fRating, fDescription);
    }

    public void deleteFilm(String fName, String fId, String fType, String fGenre, Date fDate,
                           double fRating, String fDescription){
        //delete film
        if(fName != null)
             filmDatabase.removeByName(fName);
        if(fId != null)
            filmDatabase.removeById(fId);
        if(fType != null)
            filmDatabase.removeByType(fType);
        if(fGenre!= null)
            filmDatabase.removeByGenre(fGenre);
        if(fDate != null)
            filmDatabase.removeByReleaseDate(fDate);
        if(fRating != 0)
            filmDatabase.removeByRating(fRating);
        if(fDescription != null)
            filmDatabase.removeByDescription(fDescription);
    }
    //public void addUser(String name,String login, String password){
        //add user
      //  this.login.addUser(name,login,password);
    //}
    public void addReview(String fName,String newReview){
        //add review
        filmDatabase.addReview(fName,newReview,"Admin");
    }
    public void editReview(String fName,String newReview){
        //edit review
        filmDatabase.editReview(fName,newReview,"Admin");
    }
    public void deleteReview(String fName){
        //delete review
        filmDatabase.deleteReview(fName);
    }

}
