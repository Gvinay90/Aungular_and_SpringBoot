import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeriesTeamListComponent } from './series-team-list.component';

describe('SeriesTeamListComponent', () => {
  let component: SeriesTeamListComponent;
  let fixture: ComponentFixture<SeriesTeamListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeriesTeamListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeriesTeamListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
