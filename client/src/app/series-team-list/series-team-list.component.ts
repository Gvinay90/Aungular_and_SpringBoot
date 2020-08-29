import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Team } from './../team';
import { TeamService } from "./../team.service";
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-series-team-list',
  templateUrl: './series-team-list.component.html',
  styleUrls: ['./series-team-list.component.css']
})
export class SeriesTeamListComponent implements OnInit {

  seriesName : String
  team : Observable<Team[]>
  constructor(private teamService : TeamService,
    private router : Router,
    private route : ActivatedRoute) { }

  ngOnInit() {
    this.seriesName = this.route.snapshot.params['seriesName']
    this.reloadData()
  }

  reloadData() {
    this.team = this.teamService.getTeamBySeriesName(this.seriesName)
  }

  updateTeam(id : number) {
    this.router.navigate(['updateTeam',id])
  }

  teamDetail(id : number) {
    this.router.navigate(['teamDetail',id])
  }

  deleteTeam(id : number) {
    this.teamService.deleteTeam(id)
    .subscribe(data => {
      this.reloadData()
    },
    error => console.log(error))
  }

}
