package com.rwos.dynamicMenu.Service;

import java.util.List;

import com.rwos.dynamicMenu.Entity.Menu;
import com.rwos.dynamicMenu.Repository.MenuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MenuService {
	
	@Autowired
	private MenuRepository menuRepository;

	public List<Menu> getAlldataByProjId(String projId) {
		return menuRepository.getDataByPId(projId);
	}

	public Menu saveMainMenu(Menu menu) {
		return menuRepository.save(menu);
    }
	
	public Menu saveChildMenu(String parentId, Menu menu) {
		Menu savedMenu = menuRepository.save(menu);
		String Id = savedMenu.getmId();
		menuRepository.updateMenu(parentId, Id);
		return savedMenu;
    }
	 
    public void deleteMenu(String menuID) {
		menuRepository.deleteById(menuID);
    }
    public Menu updateMenu(String menuID, String parentId, Menu menu) {
		Menu preMenu = menuRepository.findById(menuID).get();
		if(menu.getName() != null || menu.getName() != "") preMenu.setName(menu.getName());
		if(menu.getDescription() != null || menu.getDescription() != "") preMenu.setDescription(menu.getDescription());
		if(menu.getProjId() != null || menu.getProjId() != "") preMenu.setProjId(menu.getProjId());
		if(menu.getRoute() != null || menu.getRoute() != "") preMenu.setRoute(menu.getRoute());
		if(menu.getPermission() != null || menu.getPermission() != "") preMenu.setPermission(menu.getPermission());
		menuRepository.updateMenu(parentId, menuID);
		return menuRepository.save(preMenu);
    }

    public List<Menu> getAllMenuByProjId(String projId) {
        return menuRepository.findByProjId(projId);
    }

}
