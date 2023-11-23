import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-confirm-delete-travel-category',
  templateUrl: './confirm-delete-travel-category.component.html',
  styleUrls: ['./confirm-delete-travel-category.component.css']
})
export class ConfirmDeleteTravelCategoryComponent {
  constructor (private dialogRef: MatDialogRef<ConfirmDeleteTravelCategoryComponent>) {}
  cancel(){
    this.dialogRef.close(false);
  }

  confirm(){
    this.dialogRef.close(true);
  }


}
