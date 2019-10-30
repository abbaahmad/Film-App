package com.accenture.itfactory.base.FilmApplication;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Film {
    protected String imdbId;
    protected String filmType;
    protected String name;
    protected String genre;
    protected String description;
    protected double rating;
    protected Date releaseDate;

    public String getImdbId() { return this.imdbId; }

    public void setImdbId(String value)
    {
        /*if (value != null)*/ this.imdbId = value;
        //else this.imdb_id = "";
    }

    public String getFilmType() { return this.filmType; }

    public void setFilmType(String value)
    {
        /*if (value != null) */this.filmType = value;
        //else this.imdb_id = "";
    }

    public String getName() { return this.name; }

    public void setName(String value)
    {
        /*if (value != null) */this.name = value;
        //else this.name = "";
    }

    public String getGenre() { return this.genre; }

    public void setGenre(String value)
    {
        /*if (value != null) */this.genre = value;
        //else this.genre = "";
    }

    public String getDescription() { return this.description; }

    public void setDescription(String value)
    {
        /*if (value != null) */this.description = value;
        //else this.description = "";
    }
    public double getRating() { return this.rating; }

    public void setRating(double value)
    {
        /*if (value != 0.0) */this.rating = value;
        //else this.rating = "";
    }

    public Date getReleaseDate() { return this.releaseDate; }

    public void setReleaseDate(Date value)
    {
        /*if (value != 0.0) */this.releaseDate = value;
        //else this.rating = "";
    }
    public void addNewFilm(String fName, String fId, String fType, String fGenre, Date fDate,
                           double fRating, String fDescription){
        name = fName;
        imdbId = fId;
        filmType =fType;
        genre = fGenre;
        releaseDate = fDate;
        rating = fRating;
        description = fDescription;
    }
    public boolean search(String stringParam){
        Pattern pattern = Pattern.compile(stringParam);
        Matcher matcher;
        String [] fieldArray = { this.imdbId,this.name,this.genre,this.releaseDate.toString(),this.description,String.valueOf(this.rating),this.filmType};
        boolean found = false;
        for(String s : fieldArray){
            if (s != null){
                matcher = pattern.matcher(s);
                if (matcher.find()){
                    found = true;
                    break;
                }
            }
        }
        return found;
    }
}
