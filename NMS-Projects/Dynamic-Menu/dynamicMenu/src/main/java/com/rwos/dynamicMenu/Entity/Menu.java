package com.rwos.dynamicMenu.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Menu {
    @Id
    @GenericGenerator(
        name = "id_generator",
        strategy = "uuid2"
    )
    @GeneratedValue(
        generator = "id_generator"
    )
    private String mId;
    private String name;
    private String projId;
    private String description;
    private String route;
    private String permission;

    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
        name = "parent_id",
        referencedColumnName = "mId"
    )
    private List<Menu> childs = new ArrayList<>();
    
    public Menu() {
    }
    
    public Menu(String name, String projId, String description, String route, String permission) {
        this.name = name;
        this.projId = projId;
        this.description = description;
        this.route = route;
        this.permission = permission;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjId() {
        return projId;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public List<Menu> getChilds() {
        return childs;
    }

    public void setChilds(List<Menu> childs) {
        this.childs = childs;
    }
    

}
