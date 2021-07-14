import { User } from "./User";

export class Student implements StudentInterface {
    id?:number;
    firstName:string;
    lastName:string;
    cardNumber:string;
    balance:number;
    accountNumber:number;
    active: boolean
    user: User;

constructor(studentCfg: StudentInterface)
	{	
		this.id = studentCfg.id;
        this.firstName = studentCfg.firstName;
        this.lastName = studentCfg.lastName;
        this.cardNumber = studentCfg.cardNumber;
        this.balance = studentCfg.balance;
        this.accountNumber = studentCfg.accountNumber;
        this.active =studentCfg.active;
        this.user = studentCfg.user;		
	}
}

interface StudentInterface{
	id?:number;
    firstName:string;
    lastName:string;
    cardNumber:string;
    balance:number;
    accountNumber:number;
    active:boolean;
    user: User;
}
