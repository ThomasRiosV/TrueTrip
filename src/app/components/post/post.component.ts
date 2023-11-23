import { Component, ViewChild } from '@angular/core';
import { travelCategory } from 'src/app/models/travelCategory';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { TravelCategoryService } from 'src/app/services/travel-category.service';
import { ConfirmDeleteTravelCategoryComponent } from '../confirm-delete-travel-category/confirm-delete-travel-category.component';
import { MatDialog } from '@angular/material/dialog';
import { travelPost } from 'src/app/models/travelPost';
import { PostService } from 'src/app/services/post.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent {
  evento: travelPost = {
    id: 0,
    title: '',
    description: '',
    startDate: new Date(),
    endDate: new Date(),
    destination: '',
    cost: 0,
    maxParticipants: 0
  };

  dsEmployees = new MatTableDataSource<travelPost>();
  displayedColumns: string[] = ["id", "tittle", "actions"];


  @ViewChild('paginator')
  paginator!: MatPaginator;

  constructor(private travelCategoryService: PostService, public dialog: MatDialog,private router: Router) { }

  ngOnInit() {
    this.CargaEmpleados();
  }
  guardarEvento() {
    // Lógica para guardar el evento
    this.travelCategoryService.addtravelPost(this.evento).subscribe({
      next: (data) => {
        this.router.navigate(["/post"]);

        this.CargaEmpleados(); 
      },
      error: (err) => {
        console.log(err);

      }
    });
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
          this.travelCategoryService.deletetravelPost(id).subscribe({
            next: (data) => {
              // Muestra el mensaje directamente en la consola
              console.log(data);

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
    this.travelCategoryService.getTravelPosts().subscribe({
      next: (data: travelPost[]) => {

        this.dsEmployees = new MatTableDataSource(data);
        this.dsEmployees.paginator = this.paginator;

      },
      error: (err) => {
        console.log(err);

      }
    });
  }
}
