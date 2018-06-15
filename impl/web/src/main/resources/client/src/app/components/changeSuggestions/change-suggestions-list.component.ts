import {Component, OnInit} from '@angular/core';
import {DepartmentService} from "../../services/rest/department.service";

@Component({
  selector: 'change-suggestions-list',
  templateUrl: './change-suggestions-list.component.html',
})
export class ChangeSuggestionsListComponent implements OnInit {

  departments: Array<any> = [];
  selectedDepartment : any;
  fieldOfStudies: Array<any> = [];

  constructor(private departmentService: DepartmentService) {
  }

  ngOnInit() {
    this.departmentService.getAllDepartments().subscribe((resp: any) => {
      this.departments = resp;
    })
  }

  selectDepartment(id: any) {
    console.log(this.selectedDepartment);
    console.log(id);
    this.departmentService.getFieldOfStudiesByDepartment(id).subscribe((resp: any) => {
      this.fieldOfStudies = resp;
    })
  }
}
