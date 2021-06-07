import { CourseInstance } from "./CourseInstanse";
import ExamPart from "./ExamPart";
import { Student } from "./Student";

export class ExamRegistration{
    id:number;
    student: Student;
    course: CourseInstance;
    dateOfRegistration:Date;
    price:number;
    examPart: ExamPart;
    classRoom: string;
}