import { Component, OnInit } from '@angular/core';
import { CapService } from '../cap.service';
import { College } from '../Model/Colleges';
import { Router } from '@angular/router';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
pdfMake.vfs = pdfFonts.pdfMake.vfs;
import { ViewChild, ElementRef } from '@angular/core';  
import * as jsPDF from 'jspdf';
import { ExportService } from '../export.service';
import { Export } from '../Model/Export';
 
@Component({
  selector: 'app-predicted-colleges',
  templateUrl: './predicted-colleges.component.html',
  styleUrls: ['./predicted-colleges.component.css']
})
export class PredictedCollegesComponent implements OnInit {
  samples:College[]=[];
  selectedBranch:string;
  contact:string;
  a:boolean=true;
  b:boolean=false;
  c:boolean=true;
  userName
  newcontact: number;
  exportSamples:Export[]=[];
exportSample:Export=new Export();
  constructor(private service:CapService,private router:Router,private exportService: ExportService) { }
 
  ngOnInit(): void {
    this.contact= localStorage.getItem("mobile");
    this.newcontact=parseInt(this.contact);
    this.service.viewCollegesOnMarks(this.newcontact).subscribe((data:any)=>{
      console.log(data);
      this.samples=data;
      this.exportSamples=[]
      for(let i=0;i<this.samples.length;i++){
        this.exportSample.CollegeCode=this.samples[i].collegeCode
        this.exportSample.CollegeName=this.samples[i].collegeName
        this.exportSample.State=this.samples[i].state
        this.exportSample.City=this.samples[i].city
        this.exportSample.Address=this.samples[i].address
        this.exportSample.ContactNumber=this.samples[i].contactNumber

        if(this.exportSample !=null)
        {
          this.exportSamples.push(this.exportSample);
          this.exportSample=new Export();
        }
      }
      
    })
    this.userName=localStorage.getItem('user')
  }
 
selectBranch(branch){  
  console.log(this.selectedBranch)
  this.contact= localStorage.getItem("mobile");
  console.log(this.contact);
  this.b=true;
  this.c=false;
  this.service.viewpredictedColleges(this.contact,this.selectedBranch).subscribe((data:any)=>{
    console.log(data);
   
    this.samples=data;
    this.exportSamples=[]
    for(let i=0;i<this.samples.length;i++){
      this.exportSample.CollegeCode=this.samples[i].collegeCode
      this.exportSample.CollegeName=this.samples[i].collegeName
      this.exportSample.State=this.samples[i].state
      this.exportSample.City=this.samples[i].city
      this.exportSample.Address=this.samples[i].address
      this.exportSample.ContactNumber=this.samples[i].contactNumber

      if(this.exportSample !=null)
      {
        this.exportSamples.push(this.exportSample);
        this.exportSample=new Export();
      }
    }
  })
}

// title = 'angular-exportexcel-example';

  export() {
    this.exportService.exportExcel(this.exportSamples, 'exportSamples');
  }




}