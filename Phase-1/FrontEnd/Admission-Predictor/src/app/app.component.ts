import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Admission-Predictor';
  imageSrc:string;
  ngOnInit()
  {
    this.imageSrc = "../assets/images/unnamed.jpg"
  }
}
