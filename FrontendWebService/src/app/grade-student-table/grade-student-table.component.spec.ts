import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GradeStudentTableComponent } from './grade-student-table.component';

describe('GradeStudentTableComponent', () => {
  let component: GradeStudentTableComponent;
  let fixture: ComponentFixture<GradeStudentTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GradeStudentTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GradeStudentTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
