package lk.ijsw.hibernate.entity;

import javax.persistence.*;

@Entity
public class Spouse {
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "t1")
    @TableGenerator(name = "t1",
            initialValue = 0,
            allocationSize = 1,
            valueColumnName = "curval",
            pkColumnName ="tbl_names",
            pkColumnValue ="Spouse" )
    @Id
    private int id;
    private String name;
    @OneToOne
    @JoinColumn(name = "employer_id",referencedColumnName = "id")//map karanawa employerge id eka map karanawa mekata
    private Employer employer;

    public Spouse(String shashi_galKanda) {
    }

    public Spouse(String name, Employer employer) {
        this.name = name;
        this.employer = employer;
    }

    @Override
    public String toString() {
        return "Spouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employer=" + employer +
                '}';
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

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
}
