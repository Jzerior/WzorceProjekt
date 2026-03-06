package lab.wzorce.projekt.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    @Column(nullable = false)
    private LocalDateTime orderDate;

    @Column(nullable = false)
    private String status = "NEW";

    private String shippingAddress;

    @Column(nullable = false)
    private BigDecimal totalPrice = BigDecimal.ZERO;

    public Order() {
        this.orderDate = LocalDateTime.now();
    }

    private Order(Builder builder) {
        this.user = builder.user;
        this.status = builder.status;
        this.shippingAddress = builder.shippingAddress;
        this.orderDate = builder.orderDate != null ? builder.orderDate : LocalDateTime.now();
        this.items = builder.items;
        this.totalPrice = builder.totalPrice;

        for (OrderItem item : this.items) {
            item.setOrder(this);
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }

    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }

    public BigDecimal getTotalPrice() { return totalPrice; }
    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }

    public static class Builder {
        private User user;
        private String status = "NEW";
        private String shippingAddress;
        private LocalDateTime orderDate;
        private List<OrderItem> items = new ArrayList<>();
        private BigDecimal totalPrice = BigDecimal.ZERO;

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder shippingAddress(String shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        public Builder orderDate(LocalDateTime orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder addItem(OrderItem item) {
            this.items.add(item);
            this.totalPrice = this.totalPrice.add(
                    item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity()))
            );
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
