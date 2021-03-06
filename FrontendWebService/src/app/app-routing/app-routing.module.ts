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
import { AdminProfileComponent } from '../admin-profile/admin-profile.component';
import { AdminStudentsComponent } from '../admin-students/admin-students.component';
import { FinanceComponent } from '../components/finance/finance.component';
import { AdminProfessorComponent } from '../components/admin-professor/admin-professor/admin-professor.component';
import { ExamComponent } from '../exam/exam.component';
import { AdminStudentDetailComponent } from '../components/admin-student-detail/admin-student-detail.component';
import { ExamsComponent } from '../components/exams/exams.component';
import { ProfessorProfileComponent } from '../professor-profile/professor-profile.component';
import { ProfessorExamsComponent } from '../professor-exams/professor-exams.component';
import { AdminCoursesComponent } from '../components/admin-courses/admin-courses.component';
import { AdminCoursesDetailsComponent } from '../components/admin-courses-details/admin-courses-details.component';
import { AdminExamRegistryComponent } from '../admin-exam-registry/admin-exam-registry.component';
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
  { path: 'profile', component: ProfileComponent},
  { path: 'adminProfile', component: AdminProfileComponent},
  { path: 'adminStudents', component: AdminStudentsComponent},
  { path: 'adminEditStudents/:id', component: AdminStudentDetailComponent},
  { path: 'navBar', component: NavbarComponent},
  { path: 'adminProfessors', component: AdminProfessorComponent},
  { path: 'finances', component: FinanceComponent},
  { path: 'exams', component: ExamsComponent},
  { path: 'professorProfile', component: ProfessorProfileComponent},
  { path: 'professorExams', component: ProfessorExamsComponent},
  { path: 'AdminCourses', component: AdminCoursesComponent},
  { path: 'AdminCoursesDetails/:id', component: AdminCoursesDetailsComponent},
  { path: 'examRegistery', component: AdminExamRegistryComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
