package com.springmvc.app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "orders", schema = "ordershop")
public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long orderId;
    @Column(name = "userid")
    private long userId;
    @Column(name = "status")
    private String orderStatus;
    @Column(name = "created")
    private Date createdOn;
    @Column(name = "modified")
    private Date modifiedOn;
    @Column(name = "completed", nullable = true)
    private Date completedOn;
    @Column(name = "itemid")
    private long itemId;
    @Column(name = "detail")
    private String orderDetail;

    public Orders() {

    }

    public Orders(Long orderId, Long userId, String orderStatus, Date createdOn, Date modifiedOn, Date completedOn, Long itemId, String orderDetail) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderStatus = orderStatus;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.completedOn = completedOn;
        this.itemId = itemId;
        this.orderDetail = orderDetail;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Date getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(Date completedOn) {
        this.completedOn = completedOn;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedOn=" + modifiedOn +
                ", completedOn=" + completedOn +
                ", itemId='" + itemId + '\'' +
                ", orderDetail='" + orderDetail + '\'' +
                '}';
    }
}
