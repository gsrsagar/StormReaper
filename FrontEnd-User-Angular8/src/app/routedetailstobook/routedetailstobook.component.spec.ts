import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RoutedetailstobookComponent } from './routedetailstobook.component';

describe('RoutedetailstobookComponent', () => {
  let component: RoutedetailstobookComponent;
  let fixture: ComponentFixture<RoutedetailstobookComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RoutedetailstobookComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RoutedetailstobookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
