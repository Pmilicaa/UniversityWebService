
import Teaching from "./Teaching";
import { User } from "./User";

export class Professor{
    id:number;
    firstName:string;
    lastName:string;
    teaching: Teaching[];
    user: User;
    constructor(){ 
        this.user=new User();
        this.user.role= "ROLE_TEACHER";
    } 
}