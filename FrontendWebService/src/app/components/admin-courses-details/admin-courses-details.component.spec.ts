import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCoursesDetailsComponent } from './admin-courses-details.component';

describe('AdminCoursesDetailsComponent', () => {
  let component: AdminCoursesDetailsComponent;
  let fixture: ComponentFixture<AdminCoursesDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminCoursesDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCoursesDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
