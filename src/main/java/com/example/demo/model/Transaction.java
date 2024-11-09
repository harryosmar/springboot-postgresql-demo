package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "qty", nullable = false)
    private Integer Qty;

    @Column(name = "is_void", nullable = false)
    private boolean isVoid;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    // Many-to-one relationship with Product
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
    private Product product;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQty() {
        return Qty;
    }

    public void setQty(Integer qty) {
        Qty = qty;
    }

    public String getId() {
        return id;
    }

    public boolean isVoid() {
        return isVoid;
    }

    public void setVoid(boolean aVoid) {
        isVoid = aVoid;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
