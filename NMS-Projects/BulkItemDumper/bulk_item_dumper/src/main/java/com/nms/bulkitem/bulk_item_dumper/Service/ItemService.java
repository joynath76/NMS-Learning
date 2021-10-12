package com.nms.bulkitem.bulk_item_dumper.Service;

import java.util.ArrayList;
import java.util.List;

import com.nms.bulkitem.bulk_item_dumper.Entity.Item;
import com.nms.bulkitem.bulk_item_dumper.Repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public List<Item> addItem(List<Item> items) {
        List<Item> datas = new ArrayList<>();
        items.forEach(item ->{
            datas.add(itemRepository.save(item));
        });
        return datas;
    }
}