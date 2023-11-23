import { MatDialog } from '@angular/material/dialog';
import { MatPaginatorModule } from '@angular/material/paginator';
import { Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { travelCategory } from 'src/app/models/travelCategory';
import { TravelCategoryService } from 'src/app/services/travel-category.service';
import { ConfirmDeleteTravelCategoryComponent } from '../confirm-delete-travel-category/confirm-delete-travel-category.component';


@Component({
  selector: 'app-travel-category',
  templateUrl: './travel-category.component.html',
  styleUrls: ['./travel-category.component.css']
})
export class TravelCategoryComponent {
  dsEmployees = new MatTableDataSource<travelCategory>();
  displayedColumns: string[] = ["id", "name","actions"];

  @ViewChild('paginator')
  paginator!: MatPaginator;

  constructor(private travelCategoryService: TravelCategoryService, public dialog: MatDialog) { }

  ngOnInit() {
    this.CargaEmpleados();
  }

  filterEmpleados(event: Event) {
    let filtro = (event.target as HTMLInputElement).value;
    this.dsEmployees.filter = filtro;
  }

  deleteEmployee(id: number) {
    let dialogRef = this.dialog.open(ConfirmDeleteTravelCategoryComponent);
  
    dialogRef.afterClosed().subscribe(
      selectedOption => {
        if (selectedOption == true) {
          this.travelCategoryService.deletetravelCategory(id).subscribe({
            next: (data) => {
              // Muestra el mensaje directamente en la consola
              console.log(data);
  
              // También podrías mostrar el mensaje en algún lugar en tu interfaz de usuario si es necesario
              // this.showMessage(data);
  
              // Recarga las categorías después de la eliminación
              this.CargaEmpleados();
            },
            error: (err) => {
              console.log(err);
            }
          });
        }
      }
    );
  }
  
  


  
  CargaEmpleados(): void {
    //llamada asíncrona
    this.travelCategoryService.gettravelCategorys().subscribe({
      next: (data: travelCategory[]) => {

        this.dsEmployees = new MatTableDataSource(data);
        this.dsEmployees.paginator = this.paginator;

      },
      error: (err) => {
        console.log(err);
      }
    });
  }
  
}