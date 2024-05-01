import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CorouselbarComponent } from './corouselbar.component';

describe('CorouselbarComponent', () => {
  let component: CorouselbarComponent;
  let fixture: ComponentFixture<CorouselbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CorouselbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CorouselbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
