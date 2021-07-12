
import { CourseInstance } from "./CourseInstanse";
import Teaching from "./Teaching";

export class Course implements CourseInterface{
    id?: number;
    title: string;
    ects: number;
    code: string;
    // teaching: Teaching[];
    //courseInstance: CourseInstance[];

    constructor (courseCfg: CourseInterface) {
        this.id = courseCfg.id;
        this.title = courseCfg.title;
        this.ects = courseCfg.ects;
        this.code = courseCfg.code;
    }

}

interface CourseInterface {
    id?: number;
    title: string;
    ects: number;
    code: string;
}
//Ovo je samo napravljeno kao dummy klasa,u bekendu jos ima polja enrollment i course instace