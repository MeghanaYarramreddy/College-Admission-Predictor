import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CapService } from '../cap.service';

@Component({
  selector: 'app-view-feedback',
  templateUrl: './view-feedback.component.html',
  styleUrls: ['./view-feedback.component.css']
})
export class ViewFeedbackComponent implements OnInit {
  feedbackData: any[] = [];
  searchText
  constructor(private capService:CapService,private router:Router) { }

  ngOnInit(): void {
    this.capService.getfeedback().subscribe((data: any) => this.feedbackData = data);

    console.log(this.feedbackData);
    //console.log(this.data);
  }

}
