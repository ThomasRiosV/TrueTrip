import { TestBed } from '@angular/core/testing';

import { TravelCategoryService } from './travel-category.service';

describe('TravelCategoryService', () => {
  let service: TravelCategoryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TravelCategoryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
