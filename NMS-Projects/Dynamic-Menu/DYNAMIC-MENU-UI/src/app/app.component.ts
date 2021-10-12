import { Component } from '@angular/core';
import { MenuService } from './menu.service';
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';


interface MenuNode {
  name: string;
  mId: string;
  childs?: MenuNode[];
}


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'DYNAMIC-MENU-UI';

  treeControl = new NestedTreeControl<MenuNode>(node => node.childs);
  dataSource = new MatTreeNestedDataSource<MenuNode>();
  mainMenuData:any = []  
  allMenuData:any = [] 
  uiToogler = {
    menuSelected: "",
    button : "Create"
  }
  
  menuData = {
    mid: "",
    name: "",
    description: "",
    route: "",
    permission: "",
    parent_id: "",
    projId : "P_001"
  }
  constructor(private menuService : MenuService) { 
      this.refreshMenu();
   }

   hasChild = (_: number, node: MenuNode) => !!node.childs && node.childs.length > 0;
   onClick(menuId: any){
     this.uiToogler.button = "Update"
    for (const menu of this.allMenuData) {
      if(menu.mId === menuId){
        this.menuData = menu
        this.uiToogler.menuSelected = menuId
      }
    }
    event?.stopPropagation()
  }

  handleSubmit(){
    if(this.uiToogler.button === "Create"){
      this.menuService.addMenu(this.menuData).subscribe(data=>{
        console.log(data)
        this.refreshMenu()
      })  
    }else{
      this.menuService.updateMenu(this.menuData).subscribe(data=>{
        console.log(data)
        this.refreshMenu()
      })  
    }
     
  }

  handleDelete(){
    this.menuService.deleteMenu(this.menuData).subscribe((data) =>{
      this.refreshMenu();
    });

  }

  refreshMenu(){
    this.menuService.getMainMenuData(this.menuData.projId).subscribe(data =>{
      this.mainMenuData = data
      this.dataSource.data = this.mainMenuData;
    })
    this.menuService.getAllMenuData(this.menuData.projId).subscribe(data =>{
      this.allMenuData = data
    })
  }
}
