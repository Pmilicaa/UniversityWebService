import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamPartRowComponent } from './exam-part-row.component';

describe('ExamPartRowComponent', () => {
  let component: ExamPartRowComponent;
  let fixture: ComponentFixture<ExamPartRowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExamPartRowComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamPartRowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
