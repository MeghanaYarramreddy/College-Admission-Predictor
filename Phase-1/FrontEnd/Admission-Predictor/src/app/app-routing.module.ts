import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FooternavComponent } from './footernav/footernav.component';
import { CorouselbarComponent } from './corouselbar/corouselbar.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { ViewCollegeComponent } from './view-college/view-college.component';
import { AddCollegeComponent } from './add-college/add-college.component';
import { ViewStudentsComponent } from './view-students/view-students.component';
import { ViewFeedbackComponent } from './view-feedback/view-feedback.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { PredictedCollegesComponent } from './predicted-colleges/predicted-colleges.component';
import { AllCollegesComponent } from './all-colleges/all-colleges.component';
import { GiveFeedbackComponent } from './give-feedback/give-feedback.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { UpdateCollegeComponent } from './update-college/update-college.component';
import { AuthGaurdService } from './auth-gaurd.service';
import { AdminGuard } from './admin.guard';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
import { MainHomeComponent } from './main-home/main-home.component';


const routes: Routes = [
  {path : '',redirectTo: '/admission', pathMatch:'full'}, 
  {path :'aboutUs', component: FooternavComponent},
  {path :'carousel', component:CorouselbarComponent},
  {path :'login', component:UserLoginComponent},
  {path :'adminLogin', component:AdminLoginComponent},
  {path :'register', component:UserRegistrationComponent},
  {path :'forgotPassword', component:ForgotPasswordComponent},
  {path :'updateCollege', component:UpdateCollegeComponent,canActivate:[AdminGuard]},
  {path :'resetPassword', component:ResetPasswordComponent,canActivate:[AdminGuard]},
  {path :'viewCollege', component:ViewCollegeComponent,canActivate:[AdminGuard]},
  {path :'addCollege', component:AddCollegeComponent,canActivate:[AdminGuard]},
  {path :'viewStudents', component:ViewStudentsComponent,canActivate:[AdminGuard]},
  {path :'viewFeedback', component:ViewFeedbackComponent,canActivate:[AdminGuard]},
  {path :'adminHome', component:AdminHomeComponent,canActivate:[AdminGuard]},
  {path :'userHome', component:UserHomeComponent,canActivate:[AuthGaurdService]},
  {path :'predictedColleges', component:PredictedCollegesComponent,canActivate:[AuthGaurdService]},
  {path :'allColleges', component:AllCollegesComponent,canActivate:[AuthGaurdService]},
  {path :'giveFeedback', component:GiveFeedbackComponent,canActivate:[AuthGaurdService]},
  {path :'userProfile', component:UserProfileComponent,canActivate:[AuthGaurdService]},
  {path :'admission', component:MainHomeComponent},

  
     
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
