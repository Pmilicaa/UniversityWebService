import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from "../app.component";
import { LoginFormComponent } from "../login-form/login-form.component";
import { RegisterFormComponent } from "../register-form/register-form.component";
import { ListGroupComponent } from '../list-group/list-group.component';
import { DocumentTableComponent } from '../document-table/document-table.component';
import { StudentInfoComponent } from '../student-info/student-info.component';
import { ProfessorInfoComponent } from '../professor-info/professor-info.component';
import { FinanceTableComponent } from '../finance-table/finance-table.component';
import { ExamTableComponent } from '../exam-table/exam-table.component';
import { StudentTableComponent } from '../student-table/student-table.component';
import { GradeStudentTableComponent } from '../grade-student-table/grade-student-table.component';
import { CourseTableComponent } from '../course-table/course-table.component';
import { NavbarComponent } from '../navbar/navbar.component';
import { ProfileComponent } from '../profile/profile.component';

const routes: Routes = [
  { path: 'login', component: LoginFormComponent },
  { path: 'register', component: RegisterFormComponent },
  { path: 'listGroup', component: ListGroupComponent },
  { path: 'documentTable', component: DocumentTableComponent },
  { path: 'studentInfo', component: StudentInfoComponent },
  { path: 'professorInfo', component: ProfessorInfoComponent },
  { path: 'financeTable', component: FinanceTableComponent },
  { path: 'examTable', component: ExamTableComponent },
  { path: 'studentTable', component: StudentTableComponent },
  { path: 'gradeTable', component: GradeStudentTableComponent },
  { path: 'courseTable', component: CourseTableComponent },
  { path: 'profile', component: ProfileComponent}
  
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
