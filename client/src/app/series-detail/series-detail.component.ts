import { Component, OnInit } from '@angular/core';
import { SeriesService } from '../series.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Series } from './../series';
@Component({
  selector: 'app-series-detail',
  templateUrl: './series-detail.component.html',
  styleUrls: ['./series-detail.component.css']
})
export class SeriesDetailComponent implements OnInit {
  
  id : number
  series : Series

  constructor(private route : ActivatedRoute,
    private router : Router,
    private seriesService : SeriesService) { }

  ngOnInit() {
    this.series = new Series();
    this.id = this.route.snapshot.params['id']
    this.seriesService.getSeries(this.id)
    .subscribe(data => {
      this.series = data
    },
    error => console.log(error))
  }
  list() {
    this.router.navigate(['series'])
  }
}
