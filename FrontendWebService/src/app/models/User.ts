export  class User {
    id?:number;
    userName:string;
    password:string;
    role:string;

    constructor(userCfg: UserInterface) {
        this.id = userCfg.id;
        this.userName = userCfg.userName;
        this.password = userCfg.password;
        this.role = userCfg.role;
    }

}

interface UserInterface {
    id?: number;
    userName:string;
    password:string;
    role:string;
}