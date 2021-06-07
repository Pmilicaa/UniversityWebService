import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import Enrollment from '../models/Enrollment';

@Injectable({
  providedIn: 'root'
})
export class EventServiceService {

  private examDetailsEvent = new BehaviorSubject<Enrollment>(new Enrollment);

  emitExamDetailsEvent(enrollment: Enrollment){
    this.examDetailsEvent.next(enrollment);
  }

  examDetailsListener(){
    return this.examDetailsEvent.asObservable();
  }

  constructor() { }
}
