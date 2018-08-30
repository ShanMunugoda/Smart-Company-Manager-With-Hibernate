package lk.ijse.hibernate.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class  OrderDetails {
    @EmbeddedId
  private OrderDetail_PK orderDetail_pk;
  private int qty;

  @ManyToOne
  @JoinColumn(name = "item_code",referencedColumnName = "code",updatable = false,insertable = false)
  private
  Item item;

  @ManyToOne
  @JoinColumn(name = "order_id",referencedColumnName = "id",updatable = false,insertable = false)
  private
  Order order;


    public OrderDetails() {
    }

    public OrderDetails(OrderDetail_PK orderDetail_pk, int qty) {
        this.orderDetail_pk = orderDetail_pk;
        this.qty = qty;
    }

    public OrderDetails(int id,int code, int qty) {
        this.orderDetail_pk = new OrderDetail_PK(id,code);
        this.qty = qty;
    }

    public OrderDetail_PK getOrderDetail_pk() {
        return orderDetail_pk;
    }

    public void setOrderDetail_pk(OrderDetail_PK orderDetail_pk) {
        this.orderDetail_pk = orderDetail_pk;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderDetail_pk=" + orderDetail_pk +
                ", qty=" + qty +
                ", item=" + item +
                ", order=" + order +
                '}';
    }
}
