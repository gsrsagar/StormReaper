import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserprofilehomeComponent } from './userprofilehome.component';

describe('UserprofilehomeComponent', () => {
  let component: UserprofilehomeComponent;
  let fixture: ComponentFixture<UserprofilehomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserprofilehomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserprofilehomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
