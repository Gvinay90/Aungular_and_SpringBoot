import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TeamService } from '../team.service';
import { Team } from '../team';

@Component({
  selector: 'app-create-team',
  templateUrl: './create-team.component.html',
  styleUrls: ['./create-team.component.css']
})
export class CreateTeamComponent implements OnInit {

  team : Team = new Team()
  submitted = false
  constructor(private router : Router,
    private teamService : TeamService) { }

  ngOnInit() {
  }

  newTeam() : void {
    this.submitted = false
    this.team = new Team()
  }

  save() {
    this.teamService
    .createTeam(this.team)
    .subscribe(data => {
      this.team = new Team()
    },
    error => console.log(error))
  }

  onSubmit() {
    this.submitted = true
    this.save()
  }

  gotoList() {
    this.router.navigate(['/team'])
  }
}
