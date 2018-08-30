package lk.ijsw.hibernate.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="`order`")
public class Order {

    @Id
    @GeneratedValue
    private int id;
    @Temporal(value = TemporalType.DATE)
    private Date date;

    @ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    public Order() {
    }

    public Order(Date date, Customer customer) {
        this.date = date;
        this.customer = customer;
    }

    public Order(int id, Date date, Customer customer) {
        this.setId(id);
        this.setDate(date);
        this.setCustomer(customer);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", customer=" + customer +
                '}';
    }
}
