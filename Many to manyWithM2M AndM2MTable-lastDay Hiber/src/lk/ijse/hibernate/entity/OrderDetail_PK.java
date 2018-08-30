package lk.ijse.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderDetail_PK implements Serializable {
    @Column(name = "order_id")
    private int id;
    @Column(name = "item_code")
    private int code;

    public OrderDetail_PK() {
    }

    public OrderDetail_PK(int id, int code) {
        this.id = id;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "OrderDetail_PK{" +
                "id=" + id +
                ", code=" + code +
                '}';
    }
}
