import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CapService } from '../cap.service';
import { User } from '../Model/User';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  message:string;
  status:Boolean;
  userDetails:User=new User();
  constructor(private capService:CapService,private router:Router,private toastr:ToastrService) { }
  onSubmit(loginForm:any){
    this.capService.loginUser(loginForm).subscribe((data:any)=>{
      this.status=data;
      if(this.status)
        {
          sessionStorage.setItem('username', loginForm.phone + "");
          sessionStorage.setItem('userType', 'User');
          this.capService.getUserName().subscribe(data=>{
           this.userDetails= data;
           console.log(this.userDetails)
           sessionStorage.setItem('user',this.userDetails.name);
           console.log( sessionStorage.getItem('user'))
          });
          this.toastr.success('Logged in Successfully', 'User');
          this.router.navigate(['/userHome']);
  
  
        }
      else{
        this.message="Invalid UserName or password!!!";
      }
    });
  }
  


  ngOnInit(): void {
  }

}
