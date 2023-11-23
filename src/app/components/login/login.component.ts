import { MatSnackBar } from '@angular/material/snack-bar';
import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginForm!:FormGroup;
  hide:boolean=true;

  constructor(
    private formBuilder:FormBuilder,
    private userService: UserService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(){
    this.loadForm();
  }

  loadForm() {
    
    this.loginForm = this.formBuilder.group(
      {
        userName:["", [Validators.required, Validators.maxLength(20), Validators.minLength(4)]],
        password:["", [Validators.required, Validators.maxLength(20), Validators.minLength(4)]]
      }
    );

  }

  loginUser() {
    const user: User = {
      id: 0,
      userName: this.loginForm.get("userName")!.value,
      password: this.loginForm.get("password")!.value,
      type: "ROLE_STUDENT",


    };

    this.userService.login(user).subscribe({
      next: (data) => {
        this.router.navigate(["/home"]);
        this.snackBar.open("El usuario se logeó correctamente", "OK", {duration:2000});
    },
    error: (err) => {
      console.log(err);
      this.snackBar.open("Hubo un error en la autenticación del usuario: "+err.error.message, "OK", {duration:2000});
    }
    });

  }


  cancel() {
    this.router.navigate(["/"]);    
  }

}
