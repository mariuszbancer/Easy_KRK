import {Component, OnInit} from "@angular/core";
import {EducationProgramService} from "../../services/rest/educationProgram.service";
import {Router} from "@angular/router";

@Component({
  selector: 'education-programs',
  templateUrl: './education-programs-list.component.html',
})
export class EducationProgramsListComponent implements OnInit {
  educationPrograms: any[] = [];

  constructor(private educationProgramService: EducationProgramService,
              private router: Router) {

  }

  ngOnInit(): void {
    this.educationProgramService.getAllEducationPrograms().subscribe((resp: any) => {
      this.educationPrograms = resp;
    })
  }

  add() {
    this.router.navigate(['createEducationProgram']);
  }
}
