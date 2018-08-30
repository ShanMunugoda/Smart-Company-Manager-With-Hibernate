package lk.ijsw.hibernate.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@NamedQueries({
        @NamedQuery(name="query1",query ="FROM Customer"),//this is name query this query use in main->Demo4
        @NamedQuery(name = "query2",query = "FROM Customer c WHERE c.id=:id")
})

@NamedNativeQueries({
        @NamedNativeQuery(name="query6",query="INSERT INTO Customer VALUES(?1,?2,?3,?4)")
})


@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "salary")
    private BigDecimal salary;

    public Customer(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Customer(String id, String name, String address, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }


    public Customer() {
    }

    public Customer(String id, String name, String address) {

        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
