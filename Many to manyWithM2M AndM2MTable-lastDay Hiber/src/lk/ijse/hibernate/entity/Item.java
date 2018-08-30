package lk.ijse.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {
    @Id
    private int code;
    private int qty;
    private int uniteprice;
    private String description;

    @OneToMany(mappedBy = "item")
    private
    List<OrderDetails> orderDetails=new ArrayList<>();

    public Item() {
    }

    public Item(int code, int qty, int uniteprice, String description) {
        this.code = code;
        this.qty = qty;
        this.uniteprice = uniteprice;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getUniteprice() {
        return uniteprice;
    }

    public void setUniteprice(int uniteprice) {
        this.uniteprice = uniteprice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Item{" +
                "code=" + code +
                ", qty=" + qty +
                ", uniteprice=" + uniteprice +
                ", description='" + description + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
