import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs'; // Importa Observable
import { Personal } from '../models/personal';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class RegisterControlerService {

  ruta_servidor = "http://localhost:8080/api";
  recurso = "/users/registerpersonal";

  constructor(private http: HttpClient) { }

  onSubmit(userAndPersonal: { user: User, personal: Personal }): Observable<any> {
    const requestBody = {
      user: userAndPersonal.user,
      personal: userAndPersonal.personal
    };

    return this.http.post<any>(this.ruta_servidor + this.recurso, requestBody);
  }
}
