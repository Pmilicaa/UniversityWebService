import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamPartTableComponent } from './exam-part-table.component';

describe('ExamPartTableComponent', () => {
  let component: ExamPartTableComponent;
  let fixture: ComponentFixture<ExamPartTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExamPartTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamPartTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
