import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminExamRegistryComponent } from './admin-exam-registry.component';

describe('AdminExamRegistryComponent', () => {
  let component: AdminExamRegistryComponent;
  let fixture: ComponentFixture<AdminExamRegistryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminExamRegistryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminExamRegistryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
