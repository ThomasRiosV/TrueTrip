import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmDeleteTravelCategoryComponent } from './confirm-delete-travel-category.component';

describe('ConfirmDeleteTravelCategoryComponent', () => {
  let component: ConfirmDeleteTravelCategoryComponent;
  let fixture: ComponentFixture<ConfirmDeleteTravelCategoryComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ConfirmDeleteTravelCategoryComponent]
    });
    fixture = TestBed.createComponent(ConfirmDeleteTravelCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
