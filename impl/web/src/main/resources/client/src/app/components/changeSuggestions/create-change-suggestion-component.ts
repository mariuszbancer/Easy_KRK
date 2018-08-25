import {Component, OnInit} from "@angular/core";
import {DepartmentService} from "../../services/rest/department.service";
import {Router} from "@angular/router";
import {ChangeSuggestionService} from "../../services/rest/changeSuggestion.service";

@Component({
  selector: 'create-change-suggestion',
  templateUrl: './create-change-suggestion.component.html',
})
export class CreateChangeSuggestionComponent implements OnInit {

  departments: Array<any> = [];
  selectedDepartment : any;
  fieldOfStudies: Array<any> = [];
  selectedFieldOfStudy: any;
  changeSuggestionContent: string;
  changeSuggestionType: string;

  constructor(private departmentService: DepartmentService,
              private router: Router,
              private changeSuggestionService: ChangeSuggestionService) {
  }

  ngOnInit() {
    this.departmentService.getAllDepartments().subscribe((resp: any) => {
      this.departments = resp;
    })
  }

  selectDepartment(id: any) {
    this.departmentService.getFieldOfStudiesByDepartment(id).subscribe((resp: any) => {
      this.fieldOfStudies = resp;
    })
  }

  save() {
    var changeSuggestion = {
      content: this.changeSuggestionContent,
      changeSuggestionType: this.changeSuggestionType,
      fieldOfStudyId: this.selectedFieldOfStudy,
      departmentId: this.selectedDepartment
    };
    this.changeSuggestionService.createChangeSuggestion(changeSuggestion)
      .subscribe((resp) => {
        this.router.navigate(['changesSuggestions']);
      })
  }

  redirectToChangeSuggestionList() {
    this.router.navigate(['changesSuggestions']);
  }
}
