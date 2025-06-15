import { TestBed } from '@angular/core/testing';

import { PostPatientService } from './post-patient.service';

describe('PostPatientService', () => {
  let service: PostPatientService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PostPatientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
