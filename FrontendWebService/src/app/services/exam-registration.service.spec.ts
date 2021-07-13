import { TestBed } from '@angular/core/testing';

import { ExamRegistrationService } from './exam-registration.service';

describe('ExamRegistrationService', () => {
  let service: ExamRegistrationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExamRegistrationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
