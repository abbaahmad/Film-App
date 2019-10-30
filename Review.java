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
        this.createdOn = value;
    }

    public String getCreatedBy() { return this.createdBy; }

    public void setCreatedBy(String value)
    {
        this.createdBy = value;
    }
    public float getUserRating() { return this.userRating; }

    public void setUserRating(float value)
    {
        this.userRating = value;
    }
    public String getReview() { return this.review; }

    public void setReview(String value)
    {
        this.review = value;
    }

}
