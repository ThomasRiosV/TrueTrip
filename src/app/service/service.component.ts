import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent {

  constructor(private router: Router) {}

  openPersonalForm() {
    // Puedes redirigir al componente Personal o realizar otras acciones según tus necesidades
    this.router.navigate(['/src/app/components/personal']);
  }

}
