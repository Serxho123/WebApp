package com.springmvc.app.services;

import com.springmvc.app.domain.Item;
import com.springmvc.app.domain.Orders;
import com.springmvc.app.repos.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServce {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> getAllItemsRecords() {
        List<Item> itemList = itemRepository.findAll();
        return itemList;
    }


    public void deleteItem(Long itemId) {
        boolean exists = itemRepository.existsById(itemId);
        if (!exists) {
            throw new IllegalStateException("order with id" + itemId + "does not exist");
        }
        itemRepository.deleteById(itemId);
    }

    public void saveItemIntoDB(Item item) {
        this.itemRepository.save(item);
    }

    public Item getItemById(Long id) {
        Optional<Item> itemDetail = itemRepository.findById(id);
        Item items = null;
        if (itemDetail.isPresent()) {
            items = itemDetail.get();
        } else {
            throw new RuntimeException("Order not found for id::" + id);
        }
        return items;
    }


}
