package com.accenture.itfactory.base.FilmApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FilmDatabase {
    List<Film> filmList;
    Film selectedFilm;
    List<Review> reviewList;
    XmlDocClass xmlDoc;

    //public List<Film> getFilm_list(){return film_list;}
    public FilmDatabase(){
        filmList = new ArrayList<Film>();
        selectedFilm = new Film();
        reviewList = new ArrayList<Review>();
        xmlDoc = new XmlDocClass();
    }
    public void addFilm(String fName, String fId, String fType, String fGenre, Date fDate,
                        double fRating, String fDescription){
        filmList.add(new Film());
        filmList.get(filmList.size()-1).addNewFilm(fName,fId,fType,fGenre,fDate,fRating,fDescription);
    }
    public void addReview(String fName,String newReview,String reviewer) {
        selectedFilm = searchByName(fName);
        String selectedId = selectedFilm.imdbId;
        for (Review r : reviewList) {
            if (r.filmId.equals(selectedId)) {
                if (r.review.isEmpty()) {
                    r.review = newReview;
                    r.createdBy = reviewer;
                    r.createdOn = Calendar.getInstance();
                }
                else {
                    editReview(fName, newReview, reviewer);
                }
            }
        }
    }
    public void editReview(String fName,String newReview,String reviewer){
        selectedFilm = searchByName(fName);
        String selectedId = selectedFilm.imdbId;
        for(Review r : reviewList){
            if(r.filmId.equals(selectedId)){
                if(r.review.isEmpty())
                    addReview(fName,newReview,reviewer);
                else{
                    if(r.review.equals(newReview)) return;
                    else
                        r.review = newReview;
                }
            }
        }
    }
    public void deleteReview(String fName){
        selectedFilm = searchByName(fName);
        String selectedId = selectedFilm.imdbId;
        int selectedIndex = 0;
        for(int i = 0; i< reviewList.size(); i++){
            if(reviewList.get(i).filmId.equals(selectedId)) {
                selectedIndex = i;
                break;
            }
        }
        reviewList.remove(selectedIndex);
    }
    public void loadData(String path){
        File film_file = new File(path);
        if(!film_file.isFile()) return;
        filmList.clear();
        filmList = xmlDoc.startSession(/*film_file); /*/path);
        /*try(FileWriter filewriter = new FileWriter(path))*/
    }
    public void saveData(String path){
        /*File film_file = new File(path);
        if(!film_file.isFile()){
            try {
                film_file.createNewFile();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            //xmlDoc.saveSession(film_file.getAbsolutePath(),film_list);
        }
        //else*/
            xmlDoc.saveSession(path, filmList);
    }
    public void removeByName(String fName){
        selectedFilm = searchByName(fName);
        int index = filmList.indexOf(selectedFilm);
        filmList.remove(index);
    }
    public void removeById(String fId){
        selectedFilm = searchById(fId);
        int index = filmList.indexOf(selectedFilm);
        filmList.remove(index);
    }
    public void removeByType(String fType){
        selectedFilm = searchByType(fType);
        int index = filmList.indexOf(selectedFilm);
        filmList.remove(index);
    }
    public void removeByGenre(String fGenre){
        selectedFilm = searchByGenre(fGenre);
        int index = filmList.indexOf(selectedFilm);
        filmList.remove(index);
    }
    public void removeByReleaseDate(Date fDate){
        selectedFilm = searchByReleaseDate(fDate);
        int index = filmList.indexOf(selectedFilm);
        filmList.remove(index);
    }
    public void removeByRating(double fRating){
        selectedFilm = searchByRating(fRating);
        int index = filmList.indexOf(selectedFilm);
        filmList.remove(index);
    }
    public void removeByDescription(String fDescription){
        selectedFilm = searchByDescription(fDescription);
        int index = filmList.indexOf(selectedFilm);
        filmList.remove(index);
    }
    public Film search(String stringParam){
        boolean findFilm = false;
        for(int i =0;i<filmList.size();i++){
            findFilm = filmList.get(i).search(stringParam);
            if(findFilm)
                return filmList.get(i);
        }
        return null;
    }
    public Film searchByName(String fName){
        for(Film f: filmList)
            if (f.name.equals(fName))
                return f;
        return null;
    }
    public Film searchById(String fId){
        for(Film f: filmList)
            if (f.imdbId.equals(fId))
                return f;
        return null;
    }
    public Film searchByType(String fType){
        for(Film f: filmList)
            if (f.filmType.equals(fType))
                return f;
        return null;
    }
    public Film searchByGenre(String fGenre){
        for(Film f: filmList)
            if (f.genre.equals(fGenre))
                return f;
        return null;
    }
    public Film searchByReleaseDate(Date fDate){
        for(Film f: filmList)
            if (f.releaseDate.equals(fDate))
                return f;
        return null;
    }
    public Film searchByRating(double fRating){
        for(Film f: filmList)
            if (f.rating == fRating)
                return f;
        return null;
    }
    public Film searchByDescription(String fDescription){
        for(Film f: filmList)
            if (f.description.equals(fDescription))
                return f;
        return null;
    }
    public Review searchForReview(String fId){
        for(Review r : reviewList)
            if (r.filmId.equals(fId))
                return r;
        return null;
    }
    public List<Film> viewFilms(){
        int counter = 0;
        List<Film> viewList = new ArrayList<Film>();
        for(int i = 0; i< filmList.size(); i++){
            while(counter < 30){
                viewList.add(filmList.get(i));
            }
            counter++;
        }
        return viewList;
    }
    public List<Film> viewFilms(int count){
        List<Film> viewList = new ArrayList<Film>(count);
        for(int i = 0; i< count;i++){
            viewList.add(filmList.get(i));
        }
        return viewList;
    }
    public List<Film> viewFilms(int lowerBound,int higherBound){
        if(higherBound > filmList.size()) return null;
        List<Film> viewList = new ArrayList<Film>();
        for(int i = lowerBound; i< higherBound;i++){
            viewList.add(filmList.get(i));
        }
        return viewList;
    }
    public List<Film> searchDateRange(Date lowerDate,Date higherDate){
        List<Film> dateList = new ArrayList<Film>();
        for(Film f: filmList){
            if(f.releaseDate.after(lowerDate) && f.releaseDate.before(higherDate)){
                dateList.add(f);
            }
        }
        return dateList;
    }
}
