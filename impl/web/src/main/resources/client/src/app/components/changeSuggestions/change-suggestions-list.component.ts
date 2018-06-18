import {Component, OnInit} from '@angular/core';
import {DepartmentService} from "../../services/rest/department.service";
import {Router} from "@angular/router";
import {ChangeSuggestionService} from "../../services/rest/changeSuggestion.service";

@Component({
  selector: 'change-suggestions-list',
  templateUrl: './change-suggestions-list.component.html',
})
export class ChangeSuggestionsListComponent implements OnInit {

  departments: Array<any> = [];
  changeSuggestions: Array<any> = [];
  selectedDepartment : any;
  fieldOfStudies: Array<any> = [];

  constructor(private departmentService: DepartmentService,
              private changeSuggestionService: ChangeSuggestionService,
              private router: Router) {
  }

  ngOnInit() {
    this.departmentService.getAllDepartments().subscribe((resp: any) => {
      this.departments = resp;
    });
    this.changeSuggestionService.getAllChangeSuggestions().subscribe((resp: any) => {
      this.changeSuggestions = resp;
    })
  }

  selectDepartment(id: any) {
    this.departmentService.getFieldOfStudiesByDepartment(id).subscribe((resp: any) => {
      this.fieldOfStudies = resp;
    })
  }

  createSuggestion() {
    this.router.navigate(['createChangeSuggestion'])
  }
}
