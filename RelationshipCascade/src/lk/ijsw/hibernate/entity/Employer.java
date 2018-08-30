package lk.ijsw.hibernate.entity;

import javax.persistence.*;

@Entity
public class Employer {

    @GeneratedValue
    @Id
    private int id;
    private String name;
    private String address;

    @OneToOne(mappedBy = "employer", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Spouse spouse;

    public Employer() {
    }

    public Employer(String name, String address) {
        this.setName(name);
        this.setAddress(address);
    }

    public Employer(int id, String name, String address) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }
}
