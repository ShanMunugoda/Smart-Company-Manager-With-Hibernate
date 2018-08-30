package lk.ijsw.hibernate.entity;

import javax.annotation.Generated;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "Customer")
public class Customer {
    @GeneratedValue
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    @Temporal(TemporalType.DATE)
    private Date registerDate;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", registerDate=" + registerDate +
                '}';
    }

    public Customer(String name, String address, Date registerDate) {
        this.name = name;
        this.address = address;
        this.registerDate = registerDate;
    }



    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Customer(int id) {
        this.id = id;
    }


    public Customer() {
    }

    public Customer(int id, String name, String address) {

        this.id = id;
        this.name = name;
        this.address = address;
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


    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
