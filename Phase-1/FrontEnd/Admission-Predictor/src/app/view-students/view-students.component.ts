import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { Router } from '@angular/router';
import { CapService } from '../cap.service';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';

@Component({
  selector: 'app-view-students',
  templateUrl: './view-students.component.html',
  styleUrls: ['./view-students.component.css']
})
export class ViewStudentsComponent implements OnInit {
  searchText
  displayedColumns: string[] = ['phoneNo', 'name', 'email', 'gender', 'dob',
  'hallTicketNumber','marks'];
 dataSource

 @ViewChild(MatPaginator,{static: false}) paginator: MatPaginator; 
 @ViewChild(MatSort,{static: false}) sort : MatSort;
 config:any;

  constructor(private capService:CapService,private router:Router) {
    this.config = {
      itemsPerPage: 1,
      currentPage: 1,
    };
   }
  userData: any[] = [];
  ngOnInit(): void {
    this.capService.getuserData().subscribe((data:any)=> {
    this.userData = data;
    this.dataSource = new MatTableDataSource(this.userData);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    console.log(this.userData);
    });
  }

  doFilter = (value: string) => {
    this.dataSource.filter = value.trim().toLocaleLowerCase();
  }

  pageChanged(event) {
    this.config.currentPage = event;
  }
}
