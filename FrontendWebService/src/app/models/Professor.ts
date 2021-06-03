
import { User } from "./User";

export class Professor{
    firstName:string;
    lastName:string;
    user: User;
    constructor(){ 
        this.user=new User();
        this.user.role= "ROLE_TEACHER";
    } 
}