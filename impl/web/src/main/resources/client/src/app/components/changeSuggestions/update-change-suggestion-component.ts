import {Component, OnInit} from "@angular/core";
import {DepartmentService} from "../../services/rest/department.service";
import {ActivatedRoute, Router} from "@angular/router";
import {JsonHttp} from "../../services/auth/json-http";
import {ChangeSuggestionService} from "../../services/rest/changeSuggestion.service";

@Component({
  selector: 'update-change-suggestion',
  templateUrl: './update-change-suggestion.component.html',
})
export class UpdateChangeSuggestionComponent implements OnInit {

  departments: Array<any> = [];
  selectedDepartment : any;
  fieldOfStudies: Array<any> = [];
  selectedFieldOfStudy: any;
  changeSuggestionContent: string;
  changeSuggestionType: string;
  currentChangeSuggestion: any = {};
  constructor(private departmentService: DepartmentService,
              private router: Router,
              private changeSuggestionService: ChangeSuggestionService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      let changeSuggestionId = +params['id']; // (+) converts string 'id' to a number
      this.changeSuggestionService.getById(changeSuggestionId).subscribe((resp: any) => {
        this.currentChangeSuggestion = resp;
        this.departmentService.getAllDepartments().subscribe((resp: any) => {
          this.departments = resp;
        });

        this.departmentService.getFieldOfStudiesByDepartment(this.currentChangeSuggestion.departmentId).subscribe((resp: any) => {
          this.fieldOfStudies = resp;
        })
      })
    });
  }

  selectDepartment(id: any) {
    this.departmentService.getFieldOfStudiesByDepartment(id).subscribe((resp: any) => {
      this.fieldOfStudies = resp;
      this.currentChangeSuggestion.fieldIfStudyId = null;
    })
  }

  update() {
    this.changeSuggestionService.updateChangeSuggestion(this.currentChangeSuggestion)
      .subscribe((resp) => {
        this.currentChangeSuggestion = resp;
      })
  }

  redirectToChangeSuggestionList() {
    this.router.navigate(['changesSuggestions']);
  }
}
