import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { CapService } from '../cap.service';

import { from } from 'rxjs';
import { College } from '../Model/Colleges';

@Component({
  selector: 'app-all-colleges',
  templateUrl: './all-colleges.component.html',
  styleUrls: ['./all-colleges.component.css']
})
export class AllCollegesComponent implements OnInit {



  samples: College[] = [];
  selectedBranch:string;
  selectState:string;
  selectCity:string;
  searchTerm:string;
  states:any[]=[];
  cities:any[]=[];
  constructor(private service: CapService, private router: Router) { }

  ngOnInit(): void {
    this.service.viewColleges().subscribe((data: any) => {
      console.log(data);

      this.samples = data;
    });
    this.service.getStates().subscribe((datab:any)=>{
      /*  console.log(datab); */
       this.states=datab;
     })
     this.service.getCities().subscribe((datac:any)=>{
     /*  console.log(datac); */
      this.cities=datac;
    })
  }



  selectedState(state) {

console.log(this.selectState)
    if (this.selectState != null && this.selectCity == null && this.selectedBranch == null) {
      this.service.viewAllByState(this.selectState).subscribe((data: any) => {

        this.samples = data;
      })
    }

    if (this.selectCity != null && this.selectState == null && this.selectedBranch == null) {
      this.service.viewAllByCity(this.selectCity).subscribe((data: any) => {

        this.samples = data;
      })

    }
    if (this.selectedBranch != null && this.selectCity == null && this.selectState == null) {
      this.service.viewAllBybranch(this.selectedBranch).subscribe((data: any) => {

        this.samples = data;
      })
    }

    if (this.selectState != null && this.selectedBranch != null) {
      this.service.viewAllByStateAndbranch(this.selectState, this.selectedBranch).subscribe((data: any) => {
        console.log(data);
        this.samples = data
      })
    }
    if (this.selectCity != null && this.selectedBranch != null) {
      this.service.viewAllByCityAndbranch(this.selectCity, this.selectedBranch).subscribe((data: any) => {
        console.log(data);
        this.samples = data
      })
    }
    if (this.selectState != null && this.selectCity != null) {
      this.service.viewAllByStateAndCity(this.selectState, this.selectCity).subscribe((data: any) => {
        console.log(data);
        this.samples = data
      })

    }
    if (this.selectState != null && this.selectCity != null && this.selectedBranch != null) {
      this.service.viewAll(this.selectState, this.selectCity, this.selectedBranch).subscribe((data: any) => {
        console.log(data);
        this.samples = data
      })
    }

  }

}