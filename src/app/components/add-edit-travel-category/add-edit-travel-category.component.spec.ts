import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditTravelCategoryComponent } from './add-edit-travel-category.component';

describe('AddEditTravelCategoryComponent', () => {
  let component: AddEditTravelCategoryComponent;
  let fixture: ComponentFixture<AddEditTravelCategoryComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddEditTravelCategoryComponent]
    });
    fixture = TestBed.createComponent(AddEditTravelCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
