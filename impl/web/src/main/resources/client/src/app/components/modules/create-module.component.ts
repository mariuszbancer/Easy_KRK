import {Component, OnInit} from "@angular/core";
import {ModuleService} from "../../services/rest/module.service";
import {CourseService} from "../../services/rest/course.service";
import {Router} from "@angular/router";

@Component({
  selector: 'create-module',
  templateUrl: './create-module.component.html',
})
export class CreateModuleComponent implements OnInit {
  courses: any[] = [];
  selectedCourse: any = null;
  module = {
    courses: []
  };

  constructor(private moduleService: ModuleService,
              private courseService: CourseService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.courseService.getAll().subscribe((resp: any) => {
      this.courses = resp;
    })
  }

  save() {
    this.moduleService.createModule(this.module).subscribe((resp: any) => {
      console.log(resp);
    })
  }

  addCourse() {
    if(this.selectedCourse != null) {
      this.module.courses.push(this.selectedCourse);
    }
    this.selectedCourse = null;
  }

  createCourse() {
    this.router.navigate(['createCourse']);
  }
}
