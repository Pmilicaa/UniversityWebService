import { Course } from "./Course";
import { Professor } from "./Professor";
import { TeachingType } from "./TeachingType";

export default class Teaching implements TeachingInterface{
    
    id?: number;
    courseSpecificationDto: Course;
    teacherDto: Professor;
    teachingType: TeachingType;

    constructor(teachingCfg: TeachingInterface) {
        this.id = teachingCfg.id;
        this.courseSpecificationDto = teachingCfg.courseSpecificationDto;
        this.teacherDto = teachingCfg.teacherDto;
        this.teachingType = teachingCfg.teachingType;
    }

}

interface TeachingInterface {
    id?: number;
    courseSpecificationDto: Course;
    teacherDto: Professor;
    teachingType: TeachingType;
}