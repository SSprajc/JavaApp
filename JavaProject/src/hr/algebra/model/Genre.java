/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sandr
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Genre {
    @XmlTransient
    private int id;
    
    private String name;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }    

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public static List<Genre> parseGenresFromLine(String line, String delimiter){
        
        List<Genre> genres = new ArrayList<>();
        
        String[] data = line.split(delimiter);
        
        for (String genre : data) {
            genres.add(new Genre(genre));
        }
        
        return genres;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
