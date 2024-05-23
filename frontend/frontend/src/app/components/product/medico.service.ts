import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { Medico } from './medico.model';

@Injectable({
  providedIn: 'root'
})
export class MedicoService {

    baseUrl = "http://localhost:8888/api/medico/v1";

  constructor(private snackBar: MatSnackBar, private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  showMessage(msg: string): void{
    this.snackBar.open(msg,'X',{
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition: "top"
    })
  }

  create(medico: Medico): Observable<any>{
    return this.http.post<any>(this.baseUrl, medico)
  }

  read(): Observable<any> {
    return this.http.get<any>(this.baseUrl);
  }

  readByID(id: number): Observable<any>{
    const url = `${this.baseUrl}/${id}`
    return this.http.get<any>(url)
  }

  update(id: number, limite: number): Observable<Medico> {
    const url = `${this.baseUrl}/${id}`;
    const body = { limite: limite };
    return this.http.patch<Medico>(url, body, this.httpOptions);
  }

  delete(id: number): Observable<any>{
    const url = `${this.baseUrl}/${id}`
    return this.http.delete<any>(url)
  }
  
}
