import { TestBed } from '@angular/core/testing';

import { AdminProfessorsService } from './admin-professors.service';

describe('AdminProfessorsService', () => {
  let service: AdminProfessorsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminProfessorsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
