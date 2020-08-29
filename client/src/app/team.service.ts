import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  private baseUrl = 'api/jdbc/team'
  constructor(private http : HttpClient) { }

  getTeamList() : Observable<any> {
    return this.http.get(`${this.baseUrl}`)
  }

  getTeam(id : number) : Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`)
  }

  getTeamBySeriesName(name : String) : Observable<any> {
    return this.http.get(`${this.baseUrl}/name/${name}`)
  }

  createTeam(team : Object) : Observable<Object> {
    return this.http.post(`${this.baseUrl}`,team)
  }

  updateTeam(id : number, value : any) : Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`,value)
  }

  deleteTeam(id : number) : Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`)
  }
  
  deleteBySeriesName(name : String) : Observable<any> {
    return this.http.delete(`${this.baseUrl}/name/${name}`)
  }
}
