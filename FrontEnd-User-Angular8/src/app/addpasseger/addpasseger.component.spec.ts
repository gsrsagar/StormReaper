import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddpassegerComponent } from './addpasseger.component';

describe('AddpassegerComponent', () => {
  let component: AddpassegerComponent;
  let fixture: ComponentFixture<AddpassegerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddpassegerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddpassegerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
