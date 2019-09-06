package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "Movie.deleteAllRows", query = "DELETE from Movie"),
    @NamedQuery(name = "Movie.getAll", query = "SELECT m from Movie m"),
    @NamedQuery(name = "Movie.getByName", query = "SELECT m FROM Movie m WHERE m.movieName LIKE :name"),})
    

public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    public static Movie getFacadeExample(EntityManagerFactory emf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int year;
    private String movieName;
    public long getMovieCount;

    public Movie(int year, String movieName) {
        this.year = year;
        this.movieName = movieName;
    }

    public Movie() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return movieName;
    }


    public long getGetMovieCount() {
        return getMovieCount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setName(String name) {
        this.movieName = name;
    }

    public void setGetMovieCount(long getMovieCount) {
        this.getMovieCount = getMovieCount;
    }    
    
}
