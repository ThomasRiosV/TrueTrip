import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { travelCategory } from 'src/app/models/travelCategory';
import { TravelCategoryService } from 'src/app/services/travel-category.service';


@Component({
  selector: 'app-add-edit-travel-category',
  templateUrl: './add-edit-travel-category.component.html',
  styleUrls: ['./add-edit-travel-category.component.css']
})
export class AddEditTravelCategoryComponent {
  addEditForm!: FormGroup;
  id!:number;
  modoInsertar: boolean = true;

  constructor (private formBuilder: FormBuilder, private employeeService: TravelCategoryService, private router: Router, 
              private activatedRoute: ActivatedRoute, private snackBar: MatSnackBar) {}

  ngOnInit(){
    this.loadForm();
  }

  loadForm() {

    this.addEditForm = this.formBuilder.group(
      {
        id:[""],
        name:["", [Validators.required, Validators.maxLength(60), Validators.minLength(1)]],
      }
    );

    this.id = this.activatedRoute.snapshot.params["id"];
    if (this.id!=0 && this.id!=undefined) {
      this.modoInsertar = false;
      this.employeeService.gettravelCategory(this.id).subscribe({
        next: (data:travelCategory)=> {
          this.addEditForm.get("id")?.setValue(data.id);
          this.addEditForm.get("name")?.setValue(data.name);
  
        },
        error: (err) => {
          console.log(err);
        }
      })
    } else {
      this.id=0;
      this.modoInsertar = true;
    };

  }

  saveEmployee(){
    const empleado: travelCategory = {
      id: parseInt(this.addEditForm.get("id")!.value),
      name: this.addEditForm.get("name")!.value,
    };

    if (this.modoInsertar) {
      this.employeeService.addtravelCategory(empleado).subscribe({
        next: (data) => {
            this.router.navigate(["/travel-category"]);
            this.snackBar.open("El empleado se registró correctamente", "OK", {duration:2000});
        },
        error: (err) => {
          console.log(err);
          this.snackBar.open("Hubo un error en el registro del empleado", "OK", {duration:2000});
        }
      });
    } else {
      this.employeeService.updatetravelCategory(empleado).subscribe({
        next: (data) => {
          this.router.navigate(["/travel-category"]);
          this.snackBar.open("El empleado se actualizó correctamente", "OK", {duration:2000});
      },
      error: (err) => {
        console.log(err);
        this.snackBar.open("Hubo un error en la actualización del empleado", "OK", {duration:2000});
      }
      });
    }

  
  }

  cancel() {
    this.router.navigate(["/travel-category"]);    
  }
}
