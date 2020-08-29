import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Team } from './../team';
import { TeamService } from "./../team.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-team-list',
  templateUrl: './team-list.component.html',
  styleUrls: ['./team-list.component.css']
})
export class TeamListComponent implements OnInit {

  team : Observable<Team[]>
  constructor(private teamService : TeamService,
    private router : Router) { }

  ngOnInit() {
    this.reloadData()
  }

  reloadData() {
    this.team = this.teamService.getTeamList()
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
