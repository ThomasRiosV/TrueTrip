import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TravelCategoryComponent } from './travel-category.component';

describe('TravelCategoryComponent', () => {
  let component: TravelCategoryComponent;
  let fixture: ComponentFixture<TravelCategoryComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TravelCategoryComponent]
    });
    fixture = TestBed.createComponent(TravelCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
