import {Component, OnInit} from "@angular/core";
import {CourseService} from "../../services/rest/course.service";
import {SemesterService} from "../../services/rest/semester.service";
import {Router} from "@angular/router";

@Component({
  selector: 'create-semester',
  templateUrl: './create-semester.component.html',
})
export class CreateSemesterComponent implements OnInit {
  courses: any[] = [];
  selectedCourse: any = null;
  semester = {
    courses: []
  };

  ctrl = this;

  constructor(private semesterService: SemesterService,
              private courseService: CourseService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.courseService.getAll().subscribe((resp: any) => {
      this.courses = resp;
    })
  }

  save() {
    this.semesterService.createSemester(this.semester).subscribe((resp: any) => {
      this.semester = {
        courses: []
      };
    })
  }

  addCourse() {
    if(this.selectedCourse != null) {
      this.semester.courses.push(this.selectedCourse);
    }
    this.selectedCourse = null;
  }

  deleteCourse(courseId: any) {
    for(var i = 0; i < this.semester.courses.length ; i++) {
      if (this.semester.courses[i].id == courseId) {
        this.semester.courses.splice(i, 1);
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
