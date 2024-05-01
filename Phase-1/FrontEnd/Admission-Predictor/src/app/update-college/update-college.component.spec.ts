import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateCollegeComponent } from './update-college.component';

describe('UpdateCollegeComponent', () => {
  let component: UpdateCollegeComponent;
  let fixture: ComponentFixture<UpdateCollegeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateCollegeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateCollegeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
