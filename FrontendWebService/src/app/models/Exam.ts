import ExamPart from "./ExamPart";
import Teaching from "./Teaching";

export class Exam{
    id:number;
    examPoints: number;
    grade: number;
    examParts: ExamPart[];
    teaching: Teaching;
}