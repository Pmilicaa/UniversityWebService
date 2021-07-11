import { TestBed } from '@angular/core/testing';

import { AdminCoursesServiceService } from './admin-courses-service.service';

describe('AdminCoursesServiceService', () => {
  let service: AdminCoursesServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminCoursesServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
