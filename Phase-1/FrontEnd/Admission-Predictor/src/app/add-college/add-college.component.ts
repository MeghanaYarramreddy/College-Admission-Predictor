import { Component, OnInit } from '@angular/core';
import { CapService } from '../cap.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { College } from '../Model/Colleges';
import { Branches } from '../Model/Branches';
import { ICollege } from '../Model/college';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-add-college',
  templateUrl: './add-college.component.html',
  styleUrls: ['./add-college.component.css']
})
export class AddCollegeComponent implements OnInit {

 college:College=new College();
 branchesList:Branches[]=[];

branches:Branches=new Branches();

  status: string;
  errorMsg: string;
  msg: string;
  showDiv: boolean = false;
  selectedDepartment:any=[];
  selectedDepartmentCutoff:any=[];
  departmentList=["CSE","EEE","ECE","IT","MECH","CIVIL"];
  departments= [{ name :"", cutoff :0},
  { name :"", cutoff :0},
  { name :"", cutoff :0},
  { name :"", cutoff :0},
  { name :"", cutoff :0},
  { name :"", cutoff :0}
];
//  departments:IDepartment[];

  constructor(private _collegeService: CapService, private router: Router,private toastr:ToastrService) { }

addColleges(){
  
  console.log(this.branches);
  this.branchesList.push(this.branches);
  console.log(this.branchesList);
  console.log(this.college);
  this._collegeService.addBranches(this.branchesList).subscribe();
  this._collegeService.addCollege(this.college).subscribe(data=>{data
    
if(!data){
  this.toastr.success('Added Successfully', 'College');}
    });

}


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
      console.log(this.college)

      this.selectedDepartmentCutoff.splice(index,1);
    }
  }

  submitCreateForm(form: NgForm) {
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
    
    this._collegeService.create(collegeObj).subscribe(data=>{
      if(!data){
      //  alert("College with Code "+ form.value.collegeId+" Already Added !!")
       this.toastr.info('Already Existed with code'+form.value.collegeId,'College')
      }
      else{
        this.toastr.success('Added Successfully', 'College');
        this.router.navigate(['viewCollege']);
      }
    });
  }
  ngOnInit() {
  }


}
