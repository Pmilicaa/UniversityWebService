import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamRowComponent } from './exam-row.component';

describe('ExamRowComponent', () => {
  let component: ExamRowComponent;
  let fixture: ComponentFixture<ExamRowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExamRowComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamRowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
