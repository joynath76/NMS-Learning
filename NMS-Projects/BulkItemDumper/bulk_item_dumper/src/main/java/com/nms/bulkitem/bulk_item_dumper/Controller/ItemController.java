package com.nms.bulkitem.bulk_item_dumper.Controller;

import java.util.List;

import javax.validation.Valid;

import com.nms.bulkitem.bulk_item_dumper.Entity.Item;
import com.nms.bulkitem.bulk_item_dumper.Entity.RWInventoryDto;
import com.nms.bulkitem.bulk_item_dumper.Service.ItemService;
import com.nms.bulkitem.bulk_item_dumper.Service.RWInvetoryDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@CrossOrigin(origins = "*")
public class ItemController {

    @Autowired
    private ItemService itemService;
    
    @Autowired
    private RWInvetoryDao rwInventoryDao;
    

    @RequestMapping(method = RequestMethod.GET, path = "/item")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/item")
    public List<Item> addItem(@RequestBody List<Item> items){
        return itemService.addItem(items);
    }
    
    @RequestMapping(method = RequestMethod.PUT, path = "/inventory/binmapping")
    public List<RWInventoryDto> saveInventory(@Valid @RequestBody List<RWInventoryDto> items){
        return rwInventoryDao.saveAllData(items);
    }
    
}
