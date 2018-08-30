package lk.ijsw.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Movie {


    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date releasedDate;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "Movie_Actor",
            joinColumns = {@JoinColumn(name = "movie_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id", referencedColumnName = "id")}
    )
    private List<Actor> actors = new ArrayList<>();

    public Movie() {
    }

    public Movie(String name, String description, Date releasedDate) {
        this.name = name;
        this.description = description;
        this.releasedDate = releasedDate;
    }

    public Movie(int id, String name, String description, Date releasedDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.releasedDate = releasedDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
