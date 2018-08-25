import {Component, OnInit} from "@angular/core";
import {EducationProgramService} from "../../services/rest/educationProgram.service";
import {SemesterService} from "../../services/rest/semester.service";
import {StudiesPlanService} from "../../services/rest/studiesPlan.service";

@Component({
  selector: 'create-studies-plan',
  templateUrl: './create-studies-plan.component.html',
})
export class CreateStudiesPlanComponent implements OnInit {
  studiesPlan = {
    semesters: [],
    educationProgramId: null
  };
  semesters = [];
  educationPrograms = [];
  selectedSemester = null;
  selectedEducationProgram = null;


  constructor(private semesterService: SemesterService,
              private studiesPlanService: StudiesPlanService,
              private educationProgramService: EducationProgramService) {

  }

  ngOnInit(): void {
    this.semesterService.getAll().subscribe((resp: any) => {
      this.semesters = resp;
    });
    this.educationProgramService.getAllEducationPrograms().subscribe((resp: any) => {
      this.educationPrograms = resp;
    })
  }

  addSemester() {
    if(this.selectedSemester != null) {
      this.studiesPlan.semesters.push(this.selectedSemester);
    }
  }

  deleteSemester(semesterId: any) {
    for(var i = 0; i < this.studiesPlan.semesters.length ; i++) {
      if (this.studiesPlan.semesters[i].id == semesterId) {
        this.studiesPlan.semesters.splice(i, 1);
      }
    }
  }

  selectSemester(event: any) {
    let semesterId = event.target.value;
    let semestersToIterate = this.semesters;
    for(let semester of semestersToIterate) {
      if(semester.id == semesterId) {
        this.selectedSemester = semester;
      }
    }
  }

  selectEducationProgram(event: any) {
    let educationProgramId = event.target.value;
    let educationProgramsToIterate = this.educationPrograms;
    for(let educationProgram of educationProgramsToIterate) {
      if(educationProgram.id == educationProgramId) {
        this.selectedEducationProgram = educationProgram;
      }
    }
  }

  save() {
    this.studiesPlan.educationProgramId = this.selectedEducationProgram.id;
    this.studiesPlanService.create(this.studiesPlan).subscribe((resp: any) => {
      this.studiesPlan = {
        semesters: [],
        educationProgramId: null
      }
    })
  }

}
