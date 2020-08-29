import { Component, OnInit } from '@angular/core';
import { SeriesService } from '../series.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Series } from '../series'

@Component({
  selector: 'app-series-update',
  templateUrl: './series-update.component.html',
  styleUrls: ['./series-update.component.css']
})
export class SeriesUpdateComponent implements OnInit {

  id : number;
  series : Series;

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

  updateSeries() {
    this.seriesService.updateSeries(this.id, this.series)
    .subscribe(data => {
      console.log(data)
      this.series = new Series();
      this.gotoList()
    },
    error => console.log(error))
  }

  onSubmit() {
    this.updateSeries();
  }

  gotoList() {
    this.router.navigate(['series'])
  }
}
