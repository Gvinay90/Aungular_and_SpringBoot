import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateSeriesComponent } from './create-series/create-series.component';
import { CreateTeamComponent } from './create-team/create-team.component';
import { SeriesDetailComponent } from './series-detail/series-detail.component';
import { TeamDetailComponent } from './team-detail/team-detail.component';
import { SeriesUpdateComponent } from './series-update/series-update.component';
import { TeamUpdateComponent } from './team-update/team-update.component';
import { HttpClientModule } from '@angular/common/http';
import { SeriesListComponent } from './series-list/series-list.component';
import { TeamListComponent } from './team-list/team-list.component';
import { SeriesTeamListComponent } from './series-team-list/series-team-list.component';
@NgModule({
  declarations: [
    AppComponent,
    CreateSeriesComponent,
    CreateTeamComponent,
    SeriesDetailComponent,
    TeamDetailComponent,
    SeriesUpdateComponent,
    TeamUpdateComponent,
    SeriesListComponent,
    TeamListComponent,
    SeriesTeamListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
