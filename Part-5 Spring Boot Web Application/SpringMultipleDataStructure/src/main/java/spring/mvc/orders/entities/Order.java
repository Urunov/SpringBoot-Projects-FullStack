package spring.mvc.orders.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * @Created 08 / 04 / 2020 - 5:46 PM
 * @project SpringMultipleDataStructure
 * @Author Hamdamboy
 */
@Entity
@Table(name = "ORDERS")
public class Order {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, name = "cust_name")
    private String customerName;
    @Column(nullable = false, name = "cust_email")
    private String customerEmail;

    @OneToMany(mappedBy = "order")
    private Set<OrderItem> orderItems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
