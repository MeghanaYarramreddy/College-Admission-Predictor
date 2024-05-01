import { Component, OnInit } from '@angular/core';
import { CapService } from '../cap.service';
import { Router } from '@angular/router';
import { ICollege } from '../Model/college';
import { College } from '../Model/Colleges';
import { ToastrService } from 'ngx-toastr'
@Component({
  selector: 'app-view-college',
  templateUrl: './view-college.component.html',
  styleUrls: ['./view-college.component.css']
})
export class ViewCollegeComponent implements OnInit {
page=1;
  title:string = "Colleges List";
  search:any;
  // CollegesList:ICollege[];
  samples:College[]=[];
  CollegesList:College[]=[];
  Location:any=["Hyderabad","Warangal"];
  selectedBranch:string;
  selectState:string;
  selectCity:string;
  searchTerm:string;
  states:any[]=[];
  cities:any[]=[];
  confirmClicked: boolean=true;
  cancelClicked: boolean;
  public popoverTitle:string="confirmation";
  public popoverMessage:string="Are you sure to delete ??";
  constructor(private service: CapService,private router: Router,private toastr:ToastrService) { }

  ngOnInit( ): void {
   this.service.viewColleges().subscribe(data=>this.CollegesList=data);

   this.service.getStates().subscribe((datab:any)=>{
    /*  console.log(datab); */
     this.states=datab;
   })
   this.service.getCities().subscribe((datac:any)=>{
   /*  console.log(datac); */
    this.cities=datac;
  })

  }

  // deleteCollege(college:College,i){
  //   // this.CollegesList.splice(i,1);
  //   console.log(college)
  //   if(confirm('Are sure you want to delete College')){
  //     this.service.deleteCollege(college.collegeCode).subscribe(data=>data);
  //     window.location.reload();
  //     alert("College Deleted Successfully");
  //     }
  //     this.router.navigate(['viewCollege']);
  // }


  deleteCollege(college:College,i){
    // this.CollegesList.splice(i,1);
    if(this.confirmClicked){
      // this.service.deleteCollege(college.collegeCode).subscribe(data=>data);
      this.toastr.success('Deleted Successfully', 'College');
      window.location.reload(); 
      /* alert("College Deleted Successfully"); */ 
       }
     /*  this.router.navigate(['viewCollege']); */
      if(this.cancelClicked){
 
      }
  } 
  

  updateCollege(clg){
  //  window.localStorage.setItem("collegeId", clg.collegeId.toString());
  this.service.setCollegeToUpdate(clg);
    this.router.navigate(['updateCollege']);
  }

  searchByLocation(event){
    console.log(event.target.value)
  }

  idSort(){
    console.log("sort is called");
    this.CollegesList=this.CollegesList.sort(function(a,b){
      return a.collegeCode.localeCompare(b.collegeCode)
      })
  }
  
  nameSort(){
    console.log("sort is called");
      this.CollegesList=this.CollegesList.sort(function(a,b){
        return a.collegeName.localeCompare(b.collegeName);
      })
  }
  
  
  addressSort(){
    console.log("sort is called");
      this.CollegesList=this.CollegesList.sort(function(a,b){
        return a.address.localeCompare(b.address)
      })
  }

  locationSort(){
    console.log("sort is called");
      this.CollegesList=this.CollegesList.sort(function(a,b){
        return a.state.localeCompare(b.state)
      })
  }

  citySort(){
    console.log("sort is called");
      this.CollegesList=this.CollegesList.sort(function(a,b){
        return a.city.localeCompare(b.city)
      })
  }

  contactSort(){
    console.log("sort is called");
      this.CollegesList=this.CollegesList.sort(function(a,b){
        return a.contactNumber.localeCompare(b.contactNumber)
      })
  }


  selectedState(state) {


    if (this.selectState != null && this.selectCity == null && this.selectedBranch == null) {
      this.service.viewAllByState(this.selectState).subscribe((data: any) => {

        this.CollegesList = data;
      })
    }

    if (this.selectCity != null && this.selectState == null && this.selectedBranch == null) {
      this.service.viewAllByCity(this.selectCity).subscribe((data: any) => {

        this.CollegesList = data;
      })

    }
    if (this.selectedBranch != null && this.selectCity == null && this.selectState == null) {
      this.service.viewAllBybranch(this.selectedBranch).subscribe((data: any) => {

        this.CollegesList = data;
      })
    }

    if (this.selectState != null && this.selectedBranch != null) {
      this.service.viewAllByStateAndbranch(this.selectState, this.selectedBranch).subscribe((data: any) => {
        console.log(data);
        this.CollegesList = data
      })
    }
    if (this.selectCity != null && this.selectedBranch != null) {
      this.service.viewAllByCityAndbranch(this.selectCity, this.selectedBranch).subscribe((data: any) => {
        console.log(data);
        this.CollegesList = data
      })
    }
    if (this.selectState != null && this.selectCity != null) {
      this.service.viewAllByStateAndCity(this.selectState, this.selectCity).subscribe((data: any) => {
        console.log(data);
        this.CollegesList = data
      })

    }
    if (this.selectState != null && this.selectCity != null && this.selectedBranch != null) {
      this.service.viewAll(this.selectState, this.selectCity, this.selectedBranch).subscribe((data: any) => {
        console.log(data);
        this.CollegesList = data
      })
    }

  }

}
