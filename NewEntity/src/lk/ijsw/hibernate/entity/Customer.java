package lk.ijsw.hibernate.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Blob;

@NamedQueries({
        @NamedQuery(name="query1",query ="FROM Customer"),//this is name query this query use in main->Demo4
        @NamedQuery(name = "query2",query = "FROM Customer c WHERE c.id=:id")
})

@NamedNativeQueries({
        @NamedNativeQuery(name="query6",query="INSERT INTO customer VALUES(?1,?2,?3)")
})


@Entity
@Table(name = "Customer")
public class Customer {
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="test1")
//    @SequenceGenerator(name ="test1",
//            sequenceName = "customer_seq",
//            initialValue = 1,//arambka Value eka
//            allocationSize = 1)//incriment wenna ona kiyen kiyatada yanawaga

    @GeneratedValue(strategy = GenerationType.TABLE,generator="test1")
    @TableGenerator(name="test1",
    table = "seq",
    pkColumnName = "able_name",
    pkColumnValue = "Customer",
    valueColumnName = "current_id",
    initialValue = 0,
    allocationSize = 1)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "salary")
    private BigDecimal salary;
    @Column(name = "profilePic")
    private Blob profilePic;


    public Customer(String name, String address, BigDecimal salary, Blob profilePic) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.profilePic = profilePic;
    }

    public Customer(int id) {
        this.id = id;
    }

    public Customer(String name, String address, BigDecimal salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }



    public Customer() {
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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Blob getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(Blob profilePic) {
        this.profilePic = profilePic;
    }
}
