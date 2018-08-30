package lk.ijsw.hibernate.entity;

import javax.persistence.*;

@Entity
public class Spouse {

    @GeneratedValue
    @Id
    private int id;
    private String name;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    , fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id", referencedColumnName = "id")
    private Employer employer;

    public Spouse() {
    }

    public Spouse(String name, Employer employer) {
        this.name = name;
        this.employer = employer;
    }

    public Spouse(int id,String name, Employer employer) {
        this.id = id;
        this.name = name;
        this.employer = employer;
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

    @Override
    public String toString() {
        return "Spouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
}
