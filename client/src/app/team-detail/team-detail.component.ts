import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TeamService } from '../team.service';
import { Team } from '../team';
import { WeatherService } from '../weather.service'

@Component({
  selector: 'app-team-detail',
  templateUrl: './team-detail.component.html',
  styleUrls: ['./team-detail.component.css']
})
export class TeamDetailComponent implements OnInit {

  id : number
  team : Team
  temp = "NA";
  description = "NA";
  constructor(private route : ActivatedRoute,
    private teamService : TeamService,
    private router : Router,
    private weatherService : WeatherService) { }

  ngOnInit() {
    this.team = new Team()
    this.id = this.route.snapshot.params['id']
    this.teamService.getTeam(this.id)
    .subscribe(data => {
      this.team = data
      this.weatherData()
    },
    error => console.log(error))
  }
  
  list() {
    this.router.navigate(['team'])
  }

  weatherData() {
    this.weatherService.getWeatherData()
    .subscribe(data => {
      let n = data['cnt'] 
      for(let i = 0; i < n; i = i + 4) {
        if(data['list'][`${i}`]['dt_txt'].slice(0,10) == this.team.dateOfMatch) {
          this.temp = data['list'][`${i}`]['main']['temp'].toString()
          this.description = data['list'][`${i}`]['weather']['0']['description']
          break
        }
      }
    },
    error => console.log(error))
  }
}
