import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { Personal } from 'src/app/models/personal';
import { UserService } from 'src/app/services/user.service';
import { PersonalService } from 'src/app/services/personal.service';
import { User } from 'src/app/models/user';
import { RegisterControlerService } from 'src/app/services/register-controler.service';

@Component({
  selector: 'app-persona',
  templateUrl: './personal.component.html',
  styleUrls: ['./personal.component.css']
})
export class PersonalComponent {
  personaForm!: FormGroup;
  id!: number;
  modoInsertar: boolean = true;

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private snackBar: MatSnackBar,
    private personalService: PersonalService,
    private registerControlerService: RegisterControlerService // Asegúrate de que esté inyectado
  ) {}

  ngOnInit() {
    this.loadForm();
  }

  loadForm() {
    this.personaForm = this.formBuilder.group({
      id: [""],
      firstName: ["", [Validators.required, Validators.maxLength(60), Validators.minLength(1)]],
      lastName: ["", [Validators.required, Validators.maxLength(60), Validators.minLength(1)]],
      email: ["", [Validators.required, Validators.email]],
      dateOfBirth: ["", [Validators.required]],
      address: ["", [Validators.required, Validators.maxLength(100)]],
      city: ["", [Validators.required, Validators.maxLength(30), Validators.minLength(1)]],
      state: ["", [Validators.required, Validators.maxLength(30), Validators.minLength(1)]],
      country: ["", [Validators.required, Validators.maxLength(30), Validators.minLength(1)]],
      phoneNumber: ["", [Validators.required, Validators.pattern("^[0-9]*$"), Validators.maxLength(15)]],
      password: ["", [Validators.required, Validators.maxLength(60), Validators.minLength(1)]]
    });

    this.id = this.activatedRoute.snapshot.params["id"];
    if (this.id != 0 && this.id != undefined) {
      this.modoInsertar = false;

      this.personalService.getPersonalById(this.id).subscribe({
        next: (data: Personal) => {
          this.personaForm.get("id")?.setValue(data.id);
          this.personaForm.get("firstName")?.setValue(data.firstName);
          this.personaForm.get("lastName")?.setValue(data.lastName);
          this.personaForm.get("email")?.setValue(data.email);
          this.personaForm.get("dateOfBirth")?.setValue(data.dateOfBirth);
          this.personaForm.get("address")?.setValue(data.address);
          this.personaForm.get("city")?.setValue(data.city);
          this.personaForm.get("state")?.setValue(data.state);
          this.personaForm.get("country")?.setValue(data.country);
          this.personaForm.get("phoneNumber")?.setValue(data.phoneNumber);
        },
        error: (err) => {
          console.log(err);
        }
      });
    } else {
      this.id = 0;
      this.modoInsertar = true;
    }
  }

  savePersonal() {
   

    const personal: Personal = {
      id: parseInt(this.personaForm.get("id")!.value),
      firstName: this.personaForm.get("firstName")!.value,
      lastName: this.personaForm.get("lastName")!.value,
      email: this.personaForm.get("email")!.value,
      dateOfBirth: new Date(this.personaForm.get("dateOfBirth")!.value),
      address: this.personaForm.get("address")!.value,
      city: this.personaForm.get("city")!.value,
      state: this.personaForm.get("state")!.value,
      country: this.personaForm.get("country")!.value,
      phoneNumber: this.personaForm.get("phoneNumber")!.value
    };

    const user: User = {
      id: 0,
      userName: this.personaForm.get("email")!.value,
      password: this.personaForm.get("password")!.value,
      type: "CLIENT"
    };

    const userAndPersonal = { user, personal };

    // ...  
    this.registerControlerService.onSubmit(userAndPersonal).subscribe({
  next: (response: any) => {
    console.log('Respuesta del servicio RegisterControlerService:', response);

    if (this.modoInsertar) {
      this.personalService.createPersonal(personal).subscribe({
        next: (data) => {
          this.router.navigate(["/post"]);
          this.snackBar.open("La persona se registró correctamente", "OK", { duration: 2000 });
        },
        error: (err) => {
          console.log(err);
          this.snackBar.open("Hubo un error en el registro de la persona", "OK", { duration: 2000 });
        }
      });
    } else {
      this.personalService.updatePersonal(personal).subscribe({
        next: (data) => {
          this.router.navigate(["/post"]);
          this.snackBar.open("La persona se actualizó correctamente", "OK", { duration: 2000 });
        },
        error: (err) => {
          console.log(err);
          this.snackBar.open("Hubo un error en la actualización de la persona", "OK", { duration: 2000 });
        }
      });
    }
  },
  error: (error: any) => {
    // Muestra información sobre el error en la consola
    console.error('Error en el servicio RegisterControlerService:', error);

    // Puedes agregar lógica adicional aquí para manejar el error en la interfaz de usuario si es necesario
    this.snackBar.open("Hubo un error en la solicitud al servidor", "OK", { duration: 2000 });
  }
});

// ...

  }

  cancel() {
    this.router.navigate(["/home"]);
  }
}
