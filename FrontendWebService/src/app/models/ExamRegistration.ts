import { CourseSpecification } from "./CourseSpecification";
import ExamPart from "./ExamPart";
import { Student } from "./Student";

export class ExamRegistration{
    id:number;
    student: Student;
    course: CourseSpecification;
    dateOfRegistration:Date;
    price:number;
    examPart: ExamPart;
    classroom: string;
}