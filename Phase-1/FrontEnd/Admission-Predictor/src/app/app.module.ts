import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { UserNavbarComponent } from './user-navbar/user-navbar.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

import { HomenavComponent } from './homenav/homenav.component';
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
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { UserHomeComponent } from './user-home/user-home.component';
import { PredictedCollegesComponent } from './predicted-colleges/predicted-colleges.component';
import { AllCollegesComponent } from './all-colleges/all-colleges.component';
import { GiveFeedbackComponent } from './give-feedback/give-feedback.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UserFooterComponent } from './user-footer/user-footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { IgxCardModule } from 'igniteui-angular';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { MatCardModule, MatButtonModule, MatFormFieldModule, MatInputModule, MatTableModule, MatSortModule, MatPaginatorModule } from '@angular/material';
import { UpdateCollegeComponent } from './update-college/update-college.component';
import {DataTableModule} from 'angular-6-datatable';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
import { ExportAsModule } from 'ngx-export-as';
import { ExportDirective } from './_directives/export.directive';
import { MainHomeComponent } from './main-home/main-home.component';
import { HomeNavComponent } from './home-nav/home-nav.component';
import { ConfirmationPopoverModule } from 'angular-confirmation-popover'; 
import { ToastrModule} from 'ngx-toastr';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    UserNavbarComponent,
    HomenavComponent,
    FooternavComponent,
    CorouselbarComponent,
    UserLoginComponent,
    UserRegistrationComponent,
    AdminLoginComponent,
    ViewCollegeComponent,
    AddCollegeComponent,
    ViewStudentsComponent,
    ViewFeedbackComponent,
    AdminHomeComponent,
    UserHomeComponent,
    PredictedCollegesComponent,
    AllCollegesComponent,
    GiveFeedbackComponent,
    UserProfileComponent,
    UserFooterComponent,
    ForgotPasswordComponent,
    UpdateCollegeComponent,
    ResetPasswordComponent,
    ExportDirective,
    MainHomeComponent,
    HomeNavComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    CommonModule,
    ReactiveFormsModule,
    Ng2SearchPipeModule,
    BrowserAnimationsModule,
    IgxCardModule ,
    MatInputModule,
    NgxPaginationModule,
    MatCardModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule, 
    MatTableModule, 
    MatSortModule,
    MatPaginatorModule,
    DataTableModule,
    ExportAsModule,
    ToastrModule.forRoot({
      timeOut: 9000,
      positionClass: 'toast-top-right',
      preventDuplicates: false,
    }),
    ConfirmationPopoverModule.forRoot({
      confirmButtonType: 'danger'
    }),
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
