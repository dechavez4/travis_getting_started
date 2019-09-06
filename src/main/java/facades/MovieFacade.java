package facades;

import entities.Movie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MovieFacade {


    private static MovieFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private MovieFacade() {
    }
    
    public Movie getMovieById(long id){
        EntityManager em = emf.createEntityManager();
        try{
            Movie movie = em.find(Movie.class, id);
            return movie;
        }finally{
            em.close();
        }
    }

    //denne metoder giver henter en bestemt film.
    public static Movie getMovieByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            Movie movie = em.find(Movie.class, name);
            return movie;
        } finally {
            em.close();
        }
    }

    //denne metoder henter alle movies. 
    public List<Movie> getAllMovies() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Movie> query = em.createQuery("SELECT movie from Movie movie", Movie.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    //henter alle film baseret på hvilket year man søger efter. 
    public Movie getMovieByYear(int year) {
        EntityManager em = emf.createEntityManager();

        try {
            return (Movie)em.createQuery("SELECT m FROM Movie m WHERE m.movie LIKE :name", Movie.class).getSingleResult();
        } finally {
            em.close();
        }
    }

    //denne tilføjer film. 
    public Movie addMovie(String name) {
        Movie movie = new Movie(2018, "titans");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(movie);
            em.getTransaction().commit();
            return movie;
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MovieFacade getMovieFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //TODO Remove/Change this before use
    public long getMovieCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long movie = (long) em.createQuery("SELECT COUNT(r) FROM movie r").getSingleResult();
            return movie;
        } finally {
            em.close();
        }

    }

}
