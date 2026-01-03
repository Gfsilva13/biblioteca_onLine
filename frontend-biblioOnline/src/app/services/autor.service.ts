import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AutorRequest, AutorResponse } from '../models/autor.model';

@Injectable({
  providedIn: 'root'
})
export class AutorService {

  private readonly apiUrl = 'http://localhost:8081/autores';

  constructor(private http: HttpClient) {}

  cadastrar(request: AutorRequest): Observable<AutorResponse> {
    return this.http.post<AutorResponse>(this.apiUrl, request);
  }

  buscarPorId(id: number): Observable<AutorResponse> {
    return this.http.get<AutorResponse>(`${this.apiUrl}/${id}`);
  }

  listar(page: number, size: number): Observable<AutorResponse[]> {
    const params = new HttpParams()
      .set('page', page)
      .set('size', size);

    return this.http.get<AutorResponse[]>(this.apiUrl, { params });
  }

  atualizar(id: number, request: AutorRequest): Observable<AutorResponse> {
    return this.http.put<AutorResponse>(`${this.apiUrl}/${id}`, request);
  }

  excluir(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
