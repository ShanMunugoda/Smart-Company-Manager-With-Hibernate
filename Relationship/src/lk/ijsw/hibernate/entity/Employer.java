package lk.ijsw.hibernate.entity;

import javax.persistence.*;

@Entity
public class Employer {
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "t1")
    @TableGenerator(name = "t1",
            initialValue = 0,
            allocationSize = 1,
            valueColumnName = "curval",
            pkColumnName ="tbl_names",
            pkColumnValue ="Employee"
    )
    @Id
    private int id;
    private String name;
    private String address;

    public Employer() {
    }

    public Employer(String name, String address) {
        this.id = id;
        this.name = name;
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
}
