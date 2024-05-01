import { Component, OnInit } from '@angular/core';
import { ICollege } from '../Model/college';
import { FormGroup, FormBuilder, NgForm } from '@angular/forms';
import { CapService } from '../cap.service';
import { Router } from '@angular/router';
import { College } from '../Model/Colleges';
import { Branches } from '../Model/Branches';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-update-college',
  templateUrl: './update-college.component.html',
  styleUrls: ['./update-college.component.css']
})
export class UpdateCollegeComponent implements OnInit {

  status: string;
  errorMsg: string;
  msg: string;
  showDiv: boolean = false;
  collegeId:any;
  selectedDepartment:any=[];
  selectedDepartmentCutoff:any=[];
  departmentList=[{ name :"EEE", selected :false},
  { name :"CSE", selected :false},
  { name :"MECH", selected :true},
  { name :"CIVIL", selected :false},
  { name :"IT", selected :false},
  { name :"ECE", selected :false}
];
  departments= [{ name :"", cutoff :0},
  { name :"", cutoff :0},
  { name :"", cutoff :0},
  { name :"", cutoff :0},
  { name :"", cutoff :0},
  { name :"", cutoff :0}
];

  college: ICollege;
  editForm: FormGroup;
  form: FormGroup;

  constructor(private _collegeService: CapService, private router: Router,private formBuilder:  FormBuilder,private toastr:ToastrService) {   }

  onSubmit() {  }

  departmentChange(event){
    let index = this.selectedDepartment.indexOf(event.target.value);
    if(index==-1){
      this.selectedDepartment.push(event.target.value);
    }else{
      this.selectedDepartment.splice(index,1);
    }
  }

  cutoffChange(event){
    let index = this.selectedDepartment.indexOf(event.target.value);
    if(index==-1){
      this.selectedDepartmentCutoff.push(event.target.value);
    }else{
      this.selectedDepartmentCutoff.splice(index,1);
    }
  }

  

  submitUpdateForm(form: NgForm) {
    let ld=this.selectedDepartment.length;
    let i=0, empty = 6 - ld;
    for(;i<ld;++i){
      this.departments[i].name = this.selectedDepartment[i];
      this.departments[i].cutoff = this.selectedDepartmentCutoff[i];
    }
    this.departments.splice(ld,empty);
    var collegeObj:ICollege;
    this.showDiv=true;
    collegeObj={
      collegeId:form.value.collegeId,
      collegeName:form.value.collegeName,
      address:form.value.address,
      location:form.value.location,
      city:form.value.city,
      contactNumber:form.value.contactNumber,
      departments:this.departments
    };
   
      
    this._collegeService.updateCollege(collegeObj).subscribe(
      responseCreateStatus=>{
        this.status = responseCreateStatus;
        if(this.status){
          // alert("College Updated Successfully");
          this.toastr.success('Updated Successfully...', 'College');
          this.router.navigate(['viewCollege']);
        }
      },
      responseCreateError => {
        this.errorMsg = responseCreateError;
      }
    );
}

  collegeToUpdate:College=new College();
  branchListToUpdate:Branches[]=[];
  ngOnInit() {
    this.collegeId = window.localStorage.getItem("collegeId");
    // this.college= this._collegeService.getCollgeById(this.collegeId);
    this.collegeToUpdate=this._collegeService.getCollege();
    }

}
