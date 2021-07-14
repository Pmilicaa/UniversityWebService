import { Component, OnInit } from '@angular/core';
import { UserServiceService } from 'src/app/services/user-service.service';
import AdminExamRegistry from '../models/AdminExamRegistry';
@Component({
  selector: 'app-admin-exam-registry',
  templateUrl: './admin-exam-registry.component.html',
  styleUrls: ['./admin-exam-registry.component.css']
})
export class AdminExamRegistryComponent implements OnInit {
  title = "Exam Registry";
  constructor(private userServiceService: UserServiceService) { }
  adminExamRegistrys: AdminExamRegistry[] ;
  public selectedAdminExamRegistry:AdminExamRegistry = new AdminExamRegistry();
  ngOnInit(): void {
    this.userServiceService.getAllExamRegistrys()
                           .subscribe((adminExamRegistrys)=>{this.adminExamRegistrys=adminExamRegistrys
      this.adminExamRegistrys.forEach(adminExamRegistry => { 
        adminExamRegistry.date=adminExamRegistry.examDateTime.split('T')[0];
        adminExamRegistry.time=adminExamRegistry.examDateTime.split('T')[1].substring(0,8);
        
      });
      }
      
      );
  }

  editExams(){
    console.log(this.selectedAdminExamRegistry);
    this.userServiceService.editExamPartRegistry(this.selectedAdminExamRegistry).subscribe((result) => {
      if(result){
        this.selectedAdminExamRegistry=new AdminExamRegistry();
        


      }
    });
  }
  public showeditExams(selectedAdminExamRegistry: AdminExamRegistry): void {
    this.selectedAdminExamRegistry=JSON.parse(JSON.stringify(selectedAdminExamRegistry));

    let x = document.getElementById("editExams");
    if (x.style.display === "none") {
      x.style.display = "block";
    } else {
      x.style.display = "none";
    }
  }
}
