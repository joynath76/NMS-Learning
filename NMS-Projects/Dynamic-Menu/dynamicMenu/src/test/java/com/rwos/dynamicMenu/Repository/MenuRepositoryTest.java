package com.rwos.dynamicMenu.Repository;

import java.util.List;

import com.rwos.dynamicMenu.Entity.Menu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MenuRepositoryTest {

    
    @Autowired
   private MenuRepository menuRepository;

    @Test
   public void saveMainMenu(){
       //Menu menu = new Menu("Dashboard","P_001","Main Dashboard","/dashboard","DASHBOARD");
       Menu menu = new Menu("Sale transection","P_001","Sale transection","/sale/transection","SALE_TRANSECTION");
       menuRepository.save(menu);
   }
    
   @Test
   public void saveChildMenu(){
       Menu child = new Menu("EWay Bill","P_001","EWay Bill","/ewaybill/new","EWAYBILL");
       menuRepository.save(child);
   }

    
   @Test
   public void getAllData(){
       List<Menu> res = menuRepository.findAll();
       System.out.println(res);
   }

   @Test
   public void getAllDataByPId(){
       List<Menu> res = menuRepository.findByProjId("P_001");
       System.out.println(res);
   }
   
   @Test
   public void updateData() {
   	String ID = "M_0002";
   	Menu updateData = new Menu("Sale transection","P_001","Sale transection desc","/sale/transection","SALE_TRANSECTION");
   	Menu data = menuRepository.findById(ID).get();
   	data.setDescription(updateData.getDescription());
   	menuRepository.save(data);
   	System.out.println("Data Updated");
   	
   }
   
   @Test
   public void deleteMenu() {
   	menuRepository.deleteById("M_0007");
   	System.out.println("Data Deleted");
   }
}
