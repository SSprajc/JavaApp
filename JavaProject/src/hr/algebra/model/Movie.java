/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author sandr
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie {
    public static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    
    @XmlTransient
    private int id;
    
    private String title;
    
    @XmlElement(name = "publisheddate")
    @XmlJavaTypeAdapter(PublishedDateAdapter.class)
    private LocalDateTime publishedDate;
    
    private String description;
    private String origName;
    private int length;
    
    @XmlElementWrapper
    @XmlElement(name = "genre")
    private List<Genre> genres;
    
    @XmlElement(name = "poster")
    private String posterPath;
    
    @XmlElementWrapper
    @XmlElement(name = "person")
    private List<Person> actors;
    @XmlElementWrapper
    @XmlElement(name = "person")
    private List<Person> directors;

    public Movie() {
    }

    public Movie(String title, LocalDateTime pubDate, String description, String origName, int length, String posterPath) {
        this.title = title;
        this.publishedDate = pubDate;
        this.description = description;
        this.origName = origName;
        this.length = length;
        this.posterPath = posterPath;
    }

    public Movie(int idMovie, String title, LocalDateTime pubDate, String description, String origName, List<Person> directors, List<Person> actors, int length, List<Genre> genres, String posterPath) {
        this(title, pubDate, description, origName, length, posterPath);
        this.id = idMovie;
        this.genres = genres;
        this.actors = actors;
        this.directors = directors;
    }

    

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrigName() {
        return origName;
    }

    public void setOrigName(String origName) {
        this.origName = origName;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<Person> getActors() {
        return actors;
    }

    public void setActors(List<Person> actors) {
        this.actors = actors;
    }

    public List<Person> getDirectors() {
        return directors;
    }
    
    public void setDirectors(List<Person> directors) {
        this.directors = directors;
    }

    @Override
    public String toString() {
        return id + " - " + title + publishedDate;
    }

}
