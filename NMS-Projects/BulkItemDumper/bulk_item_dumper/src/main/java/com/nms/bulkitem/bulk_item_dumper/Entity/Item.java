package com.nms.bulkitem.bulk_item_dumper.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Item {

    @Id
    @GenericGenerator(
        name = "id_generator",
        strategy = "uuid2"
    )
    @GeneratedValue(
        generator = "id_generator"
    )
    private String id;
    private String name;
    private String description;
    
    public Item() {
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
}
