import { CourseInstance } from "./CourseInstanse";
import Enrollment from "./Enrollment";

export class CourseSpecification{
    id:number;
    title: string;
    ects:number;
    code:string;
    courseInstances: CourseInstance[];
    enrollments:Enrollment[];
}