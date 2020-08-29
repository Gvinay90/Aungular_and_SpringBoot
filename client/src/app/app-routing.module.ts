import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SeriesDetailComponent } from './series-detail/series-detail.component';
import { SeriesListComponent } from './series-list/series-list.component';
import { CreateSeriesComponent } from './create-series/create-series.component';
import { SeriesUpdateComponent } from './series-update/series-update.component';
import { TeamListComponent } from './team-list/team-list.component';
import { CreateTeamComponent } from './create-team/create-team.component';
import { TeamUpdateComponent } from './team-update/team-update.component';
import { TeamDetailComponent } from './team-detail/team-detail.component';
import { SeriesTeamListComponent } from './series-team-list/series-team-list.component';

const routes: Routes = [
  { path: '', redirectTo: '/series', pathMatch: 'full' },
  { path: 'series', component: SeriesListComponent },
  { path: 'addSeries', component: CreateSeriesComponent },
  { path: 'updateSeries/:id', component: SeriesUpdateComponent },
  { path: 'seriesDetail/:id', component: SeriesDetailComponent },
  { path: 'team', component: TeamListComponent },
  { path: 'addTeam', component: CreateTeamComponent },
  { path: 'updateTeam/:id', component: TeamUpdateComponent},
  { path: 'teamDetail/:id', component: TeamDetailComponent },
  { path: 'seriesTeam/:seriesName', component: SeriesTeamListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
