package com.rwos.dynamicMenu.Controller;

import java.util.List;

import com.rwos.dynamicMenu.Entity.Menu;
import com.rwos.dynamicMenu.Service.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
public class MenuController {

    @Autowired
    private MenuService menuService;
    
    @RequestMapping("/{projId}/mainmenu")
    public List<Menu> getMainMenuData(@PathVariable String projId){
        return menuService.getAlldataByProjId(projId);
    }

    @RequestMapping("/{projId}/menu")
    public List<Menu> getAllMenu(@PathVariable String projId){
        return menuService.getAllMenuByProjId(projId);
    }
    @RequestMapping(value="/menu/", method=RequestMethod.POST)
    public Menu saveMainMenu(@RequestBody Menu menu) {   
        return menuService.saveMainMenu(menu);  
    }

    @RequestMapping(value="/menu/{parentId}", method=RequestMethod.POST)
    public Menu saveChildMenu(@PathVariable String parentId, @RequestBody Menu menu) {
        return menuService.saveChildMenu(parentId, menu);
    }
     
    @RequestMapping(value="/menu/{menuId}", method=RequestMethod.DELETE)
    public void deleteMenu(@PathVariable String menuId) {
        menuService.deleteMenu(menuId);
    }
    
    @RequestMapping(value="/menu/{menuId}/{parentId}", method=RequestMethod.PUT)
    public Menu updateMenu(@PathVariable String menuId, @PathVariable String parentId, @RequestBody Menu menu) {
        return menuService.updateMenu(menuId, parentId, menu);
    }
}
