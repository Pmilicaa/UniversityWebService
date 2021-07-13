
import { CourseInstance } from "./CourseInstanse";
import Teaching from "./Teaching";

export class Course implements CourseInterface{
    id?: number;
    title: string;
    ects: number;
    code: string;
    active: boolean;
    // teaching: Teaching[];
    //courseInstance: CourseInstance[];

    constructor (courseCfg: CourseInterface) {
        this.id = courseCfg.id;
        this.title = courseCfg.title;
        this.ects = courseCfg.ects;
        this.code = courseCfg.code;
        this.active = courseCfg.active;
    }

}

interface CourseInterface {
    id?: number;
    title: string;
    ects: number;
    code: string;
    active: boolean;
}
//Ovo je samo napravljeno kao dummy klasa,u bekendu jos ima polja enrollment i course instace