import { AuthGuard } from './auth/auth.guard';
import { RegistrationComponent } from './registration/registration.component';
import { AdminComponent } from './admin/admin.component';
import { CoursesPageComponent } from './courses-page/courses-page.component';
import { UsersComponent } from './users/users.component';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
    { path: "registration", component: RegistrationComponent },
    { path: "login", component: LoginComponent },
    { path: "home", component: HomePageComponent },
    // { path: "home", loadChildren:()=>import('./home/home.module').then(a=>a.MainModule), canActivate:[AuthGuard] },
    { path: "users", component: UsersComponent },
    { path: "courses", component: CoursesPageComponent },
    { path: "admin", component: AdminComponent },
    { path: "", redirectTo: "login", pathMatch: "full" },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
