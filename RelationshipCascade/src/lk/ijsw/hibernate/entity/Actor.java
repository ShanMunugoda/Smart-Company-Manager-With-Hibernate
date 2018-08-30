package lk.ijsw.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Actor {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private GenderType sex;

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "actors")
    private List<Movie> movies = new ArrayList<>();

    public Actor(String name, GenderType sex) {
        this.setName(name);
        this.setSex(sex);
    }

    public Actor(int id, String name, GenderType sex) {
        this.setId(id);
        this.setName(name);
        this.setSex(sex);
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

    public GenderType getSex() {
        return sex;
    }

    public void setSex(GenderType sex) {
        this.sex = sex;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void addMovie(Movie movie){
        movie.getActors().add(this);
        getMovies().add(movie);
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
