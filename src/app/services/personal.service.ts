import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { Personal } from 'src/app/models/personal'; // Asegúrate de importar la clase Personal

/*@Injectable({
  providedIn: 'root'
})
export class PersonalService {
  private baseUrl = 'http://localhost:8080/api/personal'; // Reemplaza 'tu-backend-url' con la URL real de tu backend

  constructor(private http: HttpClient) { }

  createPersonal(personal: Personal): Observable<Personal> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    return this.http.post<Personal>(this.baseUrl, personal, { headers })
      .pipe(
        catchError(this.handleError)
      );
  }

  private handleError(error: any): Observable<never> {
    console.error('Error:', error);

    // Use a factory function to create the error at the moment it should be created
    return throwError(() => new Error(error.message || 'Server error'));
  }
}*/
@Injectable({
  providedIn: 'root'
})
export class PersonalService {

  private baseUrl = "http://localhost:8080/api";
  private resource = "personal";

  constructor(private http: HttpClient) { }

  getPersonalList() {
    return this.http.get<Personal[]>(`${this.baseUrl}/${this.resource}`);
  }

  getPersonalById(id: number) {
    return this.http.get<Personal>(`${this.baseUrl}/${this.resource}/${id.toString()}`);
  }

  createPersonal(personal: Personal) {
    return this.http.post<Personal>(`${this.baseUrl}/${this.resource}`, personal);
  }
  
  updatePersonal(personal: Personal) {
    return this.http.put<Personal>(`${this.baseUrl}/${this.resource}/${personal.id}`, personal);
  }
  

}
