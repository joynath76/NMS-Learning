package com.rwos.dynamicMenu.Repository;

import java.util.List;

import com.rwos.dynamicMenu.Entity.Menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MenuRepository extends JpaRepository<Menu, String>{
    
    @Query(
        value = "select * from menu where proj_id = ?1 and parent_id is null",
        nativeQuery = true
    )
    public List<Menu> getDataByPId(String pId);
    public List<Menu> findByProjId(String projId);

    @Modifying
    @Transactional
    @Query(
        value = "update menu set parent_id = ?1 where m_id = ?2",
        nativeQuery = true
    )
    public int updateMenu(String parentId, String Id);
}
