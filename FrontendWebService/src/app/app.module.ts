import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { RegisterFormComponent } from './register-form/register-form.component';
import { ListGroupComponent } from './list-group/list-group.component';
import { DocumentTableComponent } from './document-table/document-table.component';
import { StudentInfoComponent } from './student-info/student-info.component';
import { ProfessorInfoComponent } from './professor-info/professor-info.component';
import { FinanceTableComponent } from './finance-table/finance-table.component';
import { ExamTableComponent } from './exam-table/exam-table.component';
import { StudentTableComponent } from './student-table/student-table.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginFormComponent,
    RegisterFormComponent,
    ListGroupComponent,
    DocumentTableComponent,
    StudentInfoComponent,
    ProfessorInfoComponent,
    ExamTableComponent,
    StudentTableComponent,
    FinanceTableComponent,
    ExamTableComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
