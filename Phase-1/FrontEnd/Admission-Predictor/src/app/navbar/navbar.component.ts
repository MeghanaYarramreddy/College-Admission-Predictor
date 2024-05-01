import { Component, OnInit } from '@angular/core';
import { CapService } from '../cap.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private service:CapService,private router:Router) { }

  ngOnInit(): void {
  }
logout(){
  this.service.logout();
}

changePassword(){
  this.router.navigate(['/resetPassword']);
}

showMenu(){

}
}
