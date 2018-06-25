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
  selectedDepartment: number;
  selectedFieldOfStudy: number;
  selectedChangeSuggestionType: string;
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

  updateSuggestion(id: number) {
    this.router.navigate(['updateChangeSuggestion', id])
  }

  deleteSuggestion(id: null) {
    this.changeSuggestionService.deleteById(id).subscribe((resp: any) => {
      this.changeSuggestionService.getAllChangeSuggestions().subscribe((resp: any) => {
        this.changeSuggestions = resp;
      })
    })
  }

  applyFilter(suggestion: any) {
    let filterResult = true;
    if(this.selectedDepartment !== undefined && this.selectedDepartment != null && this.selectedDepartment > 0) {
      filterResult = filterResult && suggestion.departmentId == this.selectedDepartment;
    }
    if(this.selectedFieldOfStudy !== undefined && this.selectedFieldOfStudy != null && this.selectedFieldOfStudy > 0) {
      filterResult = filterResult && suggestion.fieldOfStudyId == this.selectedFieldOfStudy
    }
    if(this.selectedChangeSuggestionType !== undefined && this.selectedChangeSuggestionType != null && this.selectedChangeSuggestionType != ""){
      filterResult = filterResult && suggestion.changeSuggestionType == this.selectedChangeSuggestionType;
    }
    return filterResult;
  }
}
