import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessorStudentTableComponent } from './professor-student-table.component';

describe('ProfessorStudentTableComponent', () => {
  let component: ProfessorStudentTableComponent;
  let fixture: ComponentFixture<ProfessorStudentTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfessorStudentTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessorStudentTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
