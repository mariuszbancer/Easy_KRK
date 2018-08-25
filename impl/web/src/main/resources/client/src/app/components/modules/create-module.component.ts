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

  ctrl = this;

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
      this.module = {
        courses: []
      };
    })
  }

  addCourse() {
    if(this.selectedCourse != null) {
      this.module.courses.push(this.selectedCourse);
    }
    this.selectedCourse = null;
  }

  deleteCourse(courseId: any) {
    for(var i = 0; i < this.module.courses.length ; i++) {
      if (this.module.courses[i].id == courseId) {
        this.module.courses.splice(i, 1);
      }
    }
  }

  createCourse() {
    this.router.navigate(['createCourse']);
  }

  selectCourse(event: any) {
    let courseId = event.target.value;
    let coursesToIterate = this.courses;
    for(let course of coursesToIterate) {
      if(course.id == courseId) {
        this.selectedCourse = course;
      }
    }
  }
}
