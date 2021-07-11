import { Course } from "./Course";
import { CourseSpecification } from "./CourseSpecification";

export class CourseInstance{
    id:number;
    startDate: Date;
    endDate: Date;
    courseSpec: CourseSpecification;
}