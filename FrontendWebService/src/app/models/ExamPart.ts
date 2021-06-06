import ExamPartStatus from "./ExamPartStatus";
import ExamPartType from "./ExamPartType";

export default class ExamPart{
    id:number;
    examPartStartDate: string;
    classroom: string;
    examPartPoints: number;
    requiredPoints: number;
    examPartType: ExamPartType;
    examPartStatus: ExamPartStatus;
}