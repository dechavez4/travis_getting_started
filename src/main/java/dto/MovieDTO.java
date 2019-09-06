/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Movie;

/**
 *
 * @author Renz
 */
public class MovieDTO {
    private Long id;
    private int year;
    private String name;
    
    public MovieDTO(Movie e){
        this.id = e.getId();
        this.year = e.getYear();
        this.name = e.getName();
    }
}
