import { TestBed } from '@angular/core/testing';

import { RegisterControlerService } from './register-controler.service';

describe('RegisterControlerService', () => {
  let service: RegisterControlerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegisterControlerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
