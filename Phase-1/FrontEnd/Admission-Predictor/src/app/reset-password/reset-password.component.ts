import { Component, OnInit } from '@angular/core';
import { CapService } from '../cap.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {

  status: Boolean;
  message: string;

  constructor(private capService: CapService, private router: Router,private toastr:ToastrService) { }

  ngOnInit(): void {
  }
  curPass;
  newPass;
  mobNum: Number;
  onSubmit(passwordForm: any) {
    this.curPass = passwordForm.curPasswordRef,
      this.newPass = passwordForm.passwordRef,
      this.mobNum = parseInt(sessionStorage.getItem('username'));
    console.log(this.curPass, this.newPass, this.mobNum)
    this.capService.changePassword(this.mobNum, this.curPass, this.newPass).subscribe((data: any) => {
      this.status = data;
      if (this.status) {
        this.toastr.success('Updated Successfully...', 'Password');
      }
      else {
        this.message = "Invalid Password"
      }
    });
  }


}
