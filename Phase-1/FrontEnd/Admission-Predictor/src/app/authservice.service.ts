import { Injectable, Input } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class AuthserviceService {


  constructor(private router:Router) { 
  }
  

      isUserLoggedIn() {
        let user = sessionStorage.getItem('username')
        let type = sessionStorage.getItem('userType')
        return (!(user === null) && type=== 'User')
      }

      isAdminLoggedIn() {
        let user = sessionStorage.getItem('username')
        let type = sessionStorage.getItem('userType')
        return (!(user === null) && type=== 'Admin')
      }
    
      logOut() {
        sessionStorage.removeItem('username')
        sessionStorage.removeItem('userType') 
      }


  }

