import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './home/home.component';
import { MaterialModule } from './shared/material/material.module';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { IonicModule } from '@ionic/angular';
import { ContactComponent } from './contact/contact.component';
import { ServiceComponent } from './service/service.component';
import { PortfolioComponent } from './portfolio/portfolio.component';
import { MatCardModule } from '@angular/material/card';
import { PersonalComponent } from './components/personal/personal.component';
import { LoginComponent } from './components/login/login.component';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDialogModule } from '@angular/material/dialog';
import { TravelCategoryComponent } from './components/travel-category/travel-category.component';
import { ConfirmDeleteTravelCategoryComponent } from './components/confirm-delete-travel-category/confirm-delete-travel-category.component';
import { AddEditTravelCategoryComponent } from './components/add-edit-travel-category/add-edit-travel-category.component';
import { PostComponent } from './components/post/post.component';


@NgModule({
  declarations: [
    AppComponent,
    TravelCategoryComponent,
    PersonalComponent,
    LoginComponent,
    ConfirmDeleteTravelCategoryComponent,
    AddEditTravelCategoryComponent,
    ContactComponent,
    FooterComponent,
    HeaderComponent,
    PortfolioComponent,
    ServiceComponent,
    PostComponent,
    HomeComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatCardModule,
    IonicModule.forRoot(),
    FormsModule,
    MatIconModule,
    MatFormFieldModule,
    MatDialogModule,

  ],
  providers: [],
  bootstrap: [AppComponent , PostComponent]
})
export class AppModule { }
