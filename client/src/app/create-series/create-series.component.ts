import { Component, OnInit } from '@angular/core';
import { SeriesService } from '../series.service';
import { Router } from '@angular/router';
import { Series } from '../series'

@Component({
  selector: 'app-create-series',
  templateUrl: './create-series.component.html',
  styleUrls: ['./create-series.component.css']
})
export class CreateSeriesComponent implements OnInit {

  series : Series = new Series();
  submitted = false

  constructor(private seriesService : SeriesService,
    private router : Router) { }

  ngOnInit() {
  }

  newSeries() : void {
    this.submitted = false;
    this.series = new Series();
  }

  save() {
    this.seriesService
    .createSeries(this.series)
    .subscribe(data => {
      this.series = new Series()
    },
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true
    this.save()
  }

  gotoList() {
    this.router.navigate(['/series']);
  }
}
