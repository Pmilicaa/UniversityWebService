import { Component, Input, OnInit } from '@angular/core';
import ExamPart from 'src/app/models/ExamPart';

@Component({
  selector: 'app-exam-part-table',
  templateUrl: './exam-part-table.component.html',
  styleUrls: ['./exam-part-table.component.css']
})
export class ExamPartTableComponent implements OnInit {

  @Input() examParts: ExamPart[];
  statusSortChecked: boolean;

  constructor() { }

  onCheckClick(){
    var sortCheckbox = <HTMLInputElement>document.getElementById("statusSortCheckbox");
    if(sortCheckbox.checked == true){
      this.examParts.sort(function(a: ExamPart, b: ExamPart){
        var typeA = a.examPartStatus.name;
        var typeB = b.examPartStatus.name;
        if (typeA < typeB) {
          return -1;
        }
        if (typeA > typeB) {
          return 1;
        }

        return 0;
      });
    }else{
      this.examParts.sort(function(a: ExamPart, b: ExamPart){
        var typeA = a.examPartStatus.name;
        var typeB = b.examPartStatus.name;
        if (typeB < typeA) {
          return -1;
        }
        if (typeB > typeA) {
          return 1;
        }

        return 0;
      });
    }
  }

  ngOnInit(): void {
  }

}
