import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SeriesService {

  private baseURl = 'api/jdbc/series';
  
  constructor(private http: HttpClient) { 
    
  }

  getSeriesList() : Observable<any> {
    return this.http.get(`${this.baseURl}`);
  }

  createSeries(series : Object) : Observable<Object> {
    return this.http.post(`${this.baseURl}`,series);
  }

  updateSeries(id : number, value : any) : Observable<Object> {
    return this.http.put(`${this.baseURl}/${id}`,value);
  }

  deleteSeries(id : number) : Observable<any> {
    return this.http.delete(`${this.baseURl}/${id}`,{ responseType : 'text' });
  }

  getSeries(id : number) : Observable<any> {
    return this.http.get(`${this.baseURl}/${id}`)
  }
}