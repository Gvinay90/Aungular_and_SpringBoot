import { Component, OnInit } from '@angular/core';
import { TeamService } from '../team.service';
import { Team } from './../team';
import { ActivatedRoute, Router } from '@angular/router';
 
@Component({
  selector: 'app-team-update',
  templateUrl: './team-update.component.html',
  styleUrls: ['./team-update.component.css']
})
export class TeamUpdateComponent implements OnInit {

  id : number
  team : Team
  constructor(private route: ActivatedRoute,
    private router : Router,
    private teamService : TeamService) { }

  ngOnInit() {
    this.team = new Team()
    this.id = this.route.snapshot.params['id']
    this.teamService.getTeam(this.id)
    .subscribe(data => {
      this.team = data
    },
    error => console.log(error))
  }
  
  updateTeam() {
    this.teamService.updateTeam(this.id,this.team)
    .subscribe(data => {
      this.team = new Team()
      this.gotoList()
    },
    error => console.log(error))
  }

  onSubmit() {
    this.updateTeam()
  }

  gotoList() {
    this.router.navigate(['/team'])
  }
}
