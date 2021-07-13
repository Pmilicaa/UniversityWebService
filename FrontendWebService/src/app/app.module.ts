import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

import { AppComponent } from './app.component';
import { LoginFormComponent } from "./login-form/login-form.component";
import { RegisterFormComponent } from "./register-form/register-form.component";
import { ListGroupComponent } from './list-group/list-group.component';
import { DocumentTableComponent } from './document-table/document-table.component';
import { StudentInfoComponent } from './student-info/student-info.component';
import { ProfessorInfoComponent } from './professor-info/professor-info.component';
import { FinanceTableComponent } from './finance-table/finance-table.component';
import { ExamTableComponent } from './exam-table/exam-table.component';
import { StudentTableComponent } from './student-table/student-table.component';
import { GradeStudentTableComponent } from './grade-student-table/grade-student-table.component';
import { CourseTableComponent } from './course-table/course-table.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ProfileComponent } from './profile/profile.component';
import { UserInfoComponent } from './user-info/user-info.component';
import { FinanceComponent } from './components/finance/finance.component';
import { FinanceHistoryComponent } from './components/finance-history/finance-history.component';
import { FinanceInfoComponent } from './components/finance-info/finance-info.component';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { AdminStudentsComponent } from './admin-students/admin-students.component';
import { AdminProfessorComponent } from './components/admin-professor/admin-professor/admin-professor.component';
import { ProfessorProfileComponent } from './professor-profile/professor-profile.component';
import { ProfessorNavbarComponent } from './professor-navbar/professor-navbar.component';
import { ExamComponent } from './exam/exam.component';
import { AdminStudentDetailComponent } from './components/admin-student-detail/admin-student-detail.component';


import { DocumentTableRowComponent } from './components/document-table-row/document-table-row.component';
import { ExamsComponent } from './components/exams/exams.component';
import { ExamRowComponent } from './components/exam-row/exam-row.component';
import { ExamPartTableComponent } from './components/exam-part-table/exam-part-table.component';
import { ExamPartRowComponent } from './components/exam-part-row/exam-part-row.component';
import { ProfessorExamsComponent } from './professor-exams/professor-exams.component';
import { ProfessorCoursesComponent } from './components/professor-courses/professor-courses.component';
import { AdminCoursesComponent } from './components/admin-courses/admin-courses.component';
import { AdminCoursesDetailsComponent } from './components/admin-courses-details/admin-courses-details.component';
import { ProfessorStudentTableComponent } from './components/professor-student-table/professor-student-table.component';
import { CourseServiceService } from './services/course-service.service';
import { AdminExamRegistryComponent } from './admin-exam-registry/admin-exam-registry.component';

@NgModule({
  declarations: [ 
    AppComponent, 
    LoginFormComponent,
    RegisterFormComponent, 
    NavbarComponent, 
    ProfileComponent,
    DocumentTableComponent,
    UserInfoComponent,
    StudentInfoComponent,
    FinanceComponent,
    FinanceHistoryComponent,
    FinanceInfoComponent,
    AdminProfileComponent,
    AdminStudentsComponent,
    AdminProfessorComponent,
    ProfessorProfileComponent,
    ProfessorNavbarComponent,
    ExamComponent,
    ProfessorInfoComponent,
    DocumentTableRowComponent,
    ExamsComponent,
    ExamTableComponent,
    ExamRowComponent,
    ExamPartTableComponent,
    ExamPartRowComponent,
    ProfessorExamsComponent,
    ProfessorCoursesComponent,
    AdminStudentDetailComponent,
    AdminCoursesComponent,
    AdminCoursesDetailsComponent,
    CourseTableComponent,
    ProfessorStudentTableComponent,
    AdminExamRegistryComponent
  ],
  imports: [
    AppRoutingModule,
    RouterModule,
    BrowserModule,
    FormsModule,
    HttpClientModule,
    CommonModule
  ],
  exports: [],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
