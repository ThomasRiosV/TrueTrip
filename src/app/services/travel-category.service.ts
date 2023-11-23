import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { travelCategory } from '../models/travelCategory';

@Injectable({
  providedIn: 'root'
})
export class TravelCategoryService {

  ruta_servidor = "http://localhost:8080/api";
  recurso = "travel-categories"
  constructor(private http:HttpClient) { }

  gettravelCategorys() {
    return this.http.get<travelCategory[]>(this.ruta_servidor+"/"+this.recurso+"/list");
  }

  gettravelCategory(id: number) {
    return this.http.get<travelCategory>(this.ruta_servidor+"/"+this.recurso+"/"+id.toString());
  }

  addtravelCategory(travelCategory: travelCategory) {
    return this.http.post<travelCategory>(this.ruta_servidor+"/"+this.recurso+"/create", travelCategory);
  }

  updatetravelCategory(travelCategory: travelCategory) {
    return this.http.put<travelCategory>(this.ruta_servidor+"/"+this.recurso+"/update/"+travelCategory.id.toString(), travelCategory);
  }

  deletetravelCategory(id: number) {
    return this.http.delete<travelCategory>(this.ruta_servidor+"/"+this.recurso+"/"+"delete/"+id.toString());
  }

}
