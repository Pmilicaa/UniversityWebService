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
    FinanceInfoComponent
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
