import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'usermodule';
  public imagesUrl;
ngOnInit(){
  this.imagesUrl = [
        'assets/img/ship1.jpg',
        'assets/img/ship2.jpg',
        'assets/img/ship3.jpg',
        'assets/img/ship4.jpg',
        //'assets/img/titanic.jpg',
        'assets/img/ship5.jpg',
        'assets/img/ship6.jpg',
        'assets/img/ship7.jpg',
        'assets/img/ship8.jpg'
        
        ];

}
}