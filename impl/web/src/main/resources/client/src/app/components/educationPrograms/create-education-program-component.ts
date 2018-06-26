import {Component, OnInit} from "@angular/core";
import {EducationProgramService} from "../../services/rest/educationProgram.service";
import {FieldOfStudyService} from "../../services/rest/fieldOfStudy.service";
import {Router} from "@angular/router";

@Component({
  selector: 'create-education-program',
  templateUrl: './create-education-program-component.html',
})
export class CreateEducationProgramComponent implements OnInit {
  educationProgram = {};
  studiesProfiles: any[] = [];
  levelsOfEducation: any[] = [];
  courseForms: any[] = [];
  fieldOfStudies: any[] = [];

  constructor(private educationProgramService: EducationProgramService,
              private fieldOfStudyService: FieldOfStudyService,
              private router: Router) {

  }

  ngOnInit(): void {
    this.educationProgramService.getEnums().subscribe((resp: any) => {
      this.studiesProfiles = resp.studiesProfiles;
      this.levelsOfEducation = resp.levelsOfEducation;
      this.courseForms = resp.courseForms;
    });

    this.fieldOfStudyService.getAll().subscribe((resp: any) => {
      this.fieldOfStudies = resp;
    })
  }

  save() {
    this.educationProgramService.createEducationProgram(this.educationProgram).subscribe((resp: any) => {
      this.router.navigate(['educationPrograms'])
    })
  }

  cancel() {
    this.router.navigate(['educationPrograms'])
  }

}
