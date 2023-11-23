import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ServiceComponent } from './service/service.component';
import { ContactComponent } from './contact/contact.component';
import { PortfolioComponent } from './portfolio/portfolio.component';
import { PersonalComponent } from './components/personal/personal.component';
import { LoginComponent } from './components/login/login.component';
import { TravelCategoryComponent } from './components/travel-category/travel-category.component';
import { AddEditTravelCategoryComponent } from './components/add-edit-travel-category/add-edit-travel-category.component';
import { PostComponent } from './components/post/post.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: '', component: HomeComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'service', component: ServiceComponent },
  { path: 'portfolio', component: PortfolioComponent },
  { path: 'personal', component: PersonalComponent},
  { path: 'login' , component: LoginComponent},
  { path: 'travel-category' , component: TravelCategoryComponent},
  { path: 'new-travel-category' , component: AddEditTravelCategoryComponent},
  { path: "edit-travel-category/:id", component: AddEditTravelCategoryComponent},
  { path: "post", component: PostComponent},
  
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}