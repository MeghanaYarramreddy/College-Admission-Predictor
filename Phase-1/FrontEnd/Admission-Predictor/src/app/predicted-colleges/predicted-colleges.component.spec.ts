import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PredictedCollegesComponent } from './predicted-colleges.component';

describe('PredictedCollegesComponent', () => {
  let component: PredictedCollegesComponent;
  let fixture: ComponentFixture<PredictedCollegesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PredictedCollegesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PredictedCollegesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
