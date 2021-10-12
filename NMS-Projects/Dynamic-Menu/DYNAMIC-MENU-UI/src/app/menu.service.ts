import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor(private http: HttpClient) { }

  getMainMenuData(projectId: any){
    let api_url = "http://www.localhost:8080/"+projectId+"/mainmenu";
    return this.http.get(api_url);
  }
  getAllMenuData(projectId: any){
    let api_url = "http://www.localhost:8080/"+projectId+"/menu";
    return this.http.get(api_url);
  }

  addMenu(menuData:any){
    const menu = {
      name: menuData.name,
      description: menuData.description,
      projId: menuData.projId,
      route: menuData.route,
      permission: menuData.permission
    }
    let baseURL = "http://www.localhost:8080/menu/"
    if(menuData.parent_id != "" || menuData.parent_id != undefined)
        baseURL += menuData.parent_id        
    const headers = { 'content-type': 'application/json'}
    const body=JSON.stringify(menu);
    return this.http.post(baseURL, body,{'headers':headers})
  }

  updateMenu(menuData:any){
    const menu = {
      name: menuData.name,
      description: menuData.description,
      projId: menuData.projId,
      route: menuData.route,
      permission: menuData.permission
    }
    let baseURL = "http://www.localhost:8080/menu/" + menuData.mId + "/" + menuData.parent_id       
    const headers = { 'content-type': 'application/json'}
    const body=JSON.stringify(menu);
    return this.http.put(baseURL, body,{'headers':headers})
  }

  deleteMenu(menuData:any){
    const url = "http://www.localhost:8080/menu/"+ menuData.mId;
    return this.http.delete(url);

  }
}
