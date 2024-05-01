import { Component, OnInit } from '@angular/core';
import { CapService } from '../cap.service';
import { Router } from '@angular/router';
import { User } from '../Model/User';

@Component({
  selector: 'app-user-navbar',
  templateUrl: './user-navbar.component.html',
  styleUrls: ['./user-navbar.component.css']
})
export class UserNavbarComponent implements OnInit {

  constructor(private service:CapService,private router:Router) { }

  user:User=new User();

  ngOnInit(): void {
   this.service.getUserName().subscribe(data=>
    this.user=data
    )
    console.log(this.user.name)
  }
  logout(){
    this.service.logout();
  }
  
}
