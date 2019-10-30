package com.accenture.itfactory.base.FilmApplication;

import java.util.Date;
import java.util.List;

public class UserPage {
    FilmDatabase filmDatabase;


    public Film searchFilm(String fName, String fId, String fType, String fGenre, Date fDate,
                           double fRating, String fDescription){
        if(fName != null)
            return filmDatabase.searchByName(fName);
        if(fId != null)
            return filmDatabase.searchById(fId);
        if(fType != null)
            return filmDatabase.searchByType(fType);
        if(fGenre!= null)
            return filmDatabase.searchByGenre(fGenre);
        if(fDate != null)
            return filmDatabase.searchByReleaseDate(fDate);
        if(fRating != 0)
            return filmDatabase.searchByRating(fRating);
        if(fDescription != null)
            return filmDatabase.searchByDescription(fDescription);
        else
            return null;
    }
    public Film search(String stringParam){
        return filmDatabase.search(stringParam);
    }
    /*public Film searchFilm(String fId){
       return filmDatabase.searchById(fId);
    }
    public Film searchFilm(String fType){
       return filmDatabase.searchByType(fType);
    }
    public Film searchFilmByGenre(String fGenre){
        return filmDatabase.searchByGenre(fGenre);
    }
    public Film searchFilmByReleaseDate(Date fDate){
        return filmDatabase.searchByReleaseDate(fDate);
    }
    public Film searchFilmByRating(float fRating){
        return filmDatabase.searchByRating(fRating);
    }
    public Film searchFilmByDescription(String fDescription){
        return filmDatabase.searchByDescription(fDescription);
    }*/
    /*public Film searchFilmByReview(String fReveiw){     //a little tricky to pull off though
        return filmDatabase.searchByGenre(fReveiw);
    }
    private Review searchFilmReview(String fId){
        return filmDatabase.searchForReview(fId);
    }*/
    public List<Film> viewFilms(){
        return filmDatabase.viewFilms();
    }
    public List<Film> viewFilms(int count){
        return filmDatabase.viewFilms(count);
    }
    public List<Film> viewFilms(int lowerBound,int higherBound){
        return filmDatabase.viewFilms(lowerBound,higherBound);
    }
    public Review searchFilmReview(String fName){
        Film f = filmDatabase.searchByName(fName);
        return filmDatabase.searchForReview(f.imdbId);
    }
    public List<Film> searchDateRange(Date lowerDate,Date higherDate){
        return filmDatabase.searchDateRange(lowerDate,higherDate);
    }
    public void AddReview(String fName,String review,String reviewer){
        //add review
        filmDatabase.addReview(fName,review,reviewer);
    }
}
