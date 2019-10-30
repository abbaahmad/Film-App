package com.accenture.itfactory.base.FilmApplication;

import java.util.*;

public class Review {
    protected String filmId;
    protected Calendar createdOn;
    protected String createdBy;
    protected float userRating;
    protected String review;

    public String getFilmId() {return  this.filmId;}
    public void setFilmId(String value){
        this.filmId = value;
    }
    public Calendar getCreatedOn() { return this.createdOn; }

    public void setCreatedOn(Calendar value)
    {
        /*if (value != 0.0) */this.createdOn = value;
        //else this.rating = "";
    }

    public /*Users*/ String getCreatedBy() { return this.createdBy; }

    public void setCreatedBy(String value)
    {
        /*if (value != 0.0) */this.createdBy = value;
        //else this.rating = "";
    }
    public float getUserRating() { return this.userRating; }

    public void setUserRating(float value)
    {
        /*if (value != 0.0) */this.userRating = value;
        //else this.rating = "";
    }
    public String getReview() { return this.review; }

    public void setReview(String value)
    {
        /*if (value != 0.0) */this.review = value;
        //else this.rating = "";
    }

}
