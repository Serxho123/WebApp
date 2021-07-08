package com.springmvc.app.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "item", schema = "ordershop")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long itemId;
    @Column(name = "name")
    private String itemName;
    @Column(name = "detail")
    private String itemDetail;
    @Column(name = "price")
    private int itemPrice;

    public Item() {

    }

    public Item(Long itemId, String itemName, String itemDetail, int itemPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDetail = itemDetail;
        this.itemPrice = itemPrice;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemDetail='" + itemDetail + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
