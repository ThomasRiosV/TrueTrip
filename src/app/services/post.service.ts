import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { travelPost } from '../models/travelPost';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  ruta_servidor = "http://localhost:8080/api";
  recurso = "travelpost"
  constructor(private http:HttpClient) { }

  getTravelPosts() {
    return this.http.get<travelPost[]>(this.ruta_servidor+"/"+this.recurso+"/all");
  }

  gettravelPost(id: number) {
    return this.http.get<travelPost>(this.ruta_servidor+"/"+this.recurso+"/"+id.toString());
  }

  addtravelPost(travelpost: travelPost) {
    return this.http.post<travelPost>(this.ruta_servidor+"/"+this.recurso, travelpost);
  }

  updatetravelPost(travelpost: travelPost) {
    return this.http.put<travelPost>(this.ruta_servidor+"/"+this.recurso+"/update/"+travelpost.id.toString(), travelpost);
  }

  deletetravelPost(id: number) {
    return this.http.delete<travelPost>(this.ruta_servidor+"/"+this.recurso+"/"+"delete/"+id.toString());
  }

}
