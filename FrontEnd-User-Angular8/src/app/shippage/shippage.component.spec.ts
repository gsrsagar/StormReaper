import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShippageComponent } from './shippage.component';

describe('ShippageComponent', () => {
  let component: ShippageComponent;
  let fixture: ComponentFixture<ShippageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShippageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShippageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
