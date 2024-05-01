import { Component, OnInit } from '@angular/core';
import { CapService } from '../cap.service';
import { Router } from '@angular/router';
import { User } from '../Model/User';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  model:any={};
  user:User=new User();
message:String;
status:boolean;
  constructor(private capService:CapService,private router:Router,private toastr:ToastrService) { }
    
  editUser():any{
  
    this.capService.setUser(this.user).subscribe((data:any)=>{
      this.status=data;
      if(this.status)
        {
          this.toastr.success('Updated Successfully...', 'Profile');
        }
    });
}

  ngOnInit(): void {
      this.capService.getUser().subscribe((data:any)=>{
        this.user=data;
        console.log(this.user);
        
      });
    
    
      }
  }


