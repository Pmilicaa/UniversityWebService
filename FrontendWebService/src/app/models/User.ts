export  class User implements UserInterface {
    id?:number;
    userName:string;
    password:string;
    role:string;

    constructor(userCfg?: UserInterface) {
       if(userCfg){ this.id = userCfg.id;
        this.userName = userCfg.userName;
        this.password = userCfg.password;
        this.role = userCfg.role;
    }}

}

interface UserInterface {
    id?: number;
    userName:string;
    password:string;
    role:string;
}