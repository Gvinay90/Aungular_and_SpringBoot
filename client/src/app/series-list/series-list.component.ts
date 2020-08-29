import { Component, OnInit } from '@angular/core';
import { SeriesService } from '../series.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Series } from './../series';

@Component({
  selector: 'app-series-list',
  templateUrl: './series-list.component.html',
  styleUrls: ['./series-list.component.css']
})
export class SeriesListComponent implements OnInit {

  series : Observable<Series[]>
  constructor(private router : Router,
    private serviceService : SeriesService) { }
  ngOnInit() {
    this.reloadData();
  }
  reloadData() {
    this.series = this.serviceService.getSeriesList();
  }

  deleteSeries(id : number) {
    this.serviceService.deleteSeries(id)
    .subscribe( data => {
      this.reloadData()
    },
    error => console.log(error))
  }

  updateSeries(id : number) {
    this.router.navigate(['updateSeries', id])
  }

  seriesDetail(id : number) {
    this.router.navigate(['seriesDetail', id])
  }

  seriesTeam(seriesName : String) {
    this.router.navigate(['seriesTeam', seriesName])
  }
}
