import {EducationProgramService} from "../../services/rest/educationProgram.service";
import {StudiesPlanService} from "../../services/rest/studiesPlan.service";
import {SemesterService} from "../../services/rest/semester.service";
import {Component, OnInit} from "@angular/core";
import {ActivatedRoute} from "@angular/router";


@Component({
  selector: 'update-studies-plan',
  templateUrl: './update-studies-plan.component.html',
})
export class UpdateStudiesPlanComponent implements OnInit {
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
              private educationProgramService: EducationProgramService,
              private route: ActivatedRoute) {

  }

  ngOnInit(): void {
    this.semesterService.getAll().subscribe((resp: any) => {
      this.semesters = resp;
    });
    this.educationProgramService.getAllEducationPrograms().subscribe((resp: any) => {
      this.educationPrograms = resp;
      this.route.params.subscribe(params => {
        let studiesPlanId = +params['id'];
        this.studiesPlanService.getById(studiesPlanId).subscribe((resp: any) => {
          this.studiesPlan = resp;
        });
      })
    });
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

  save() {
    this.studiesPlanService.update(this.studiesPlan).subscribe((resp: any) => {
      this.studiesPlan = resp;
    })
  }

}
