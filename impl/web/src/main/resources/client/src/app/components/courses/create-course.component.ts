import {Component, OnInit} from "@angular/core";
import {CourseService} from "../../services/rest/course.service";

@Component({
  selector: 'create-course',
  templateUrl: './create-course.component.html',
})
export class CreateCourseComponent implements OnInit {

  course: any = {};
  courseForms: any[] = [];
  courseTypes: any[] = [];
  passingMethods: any[] = [];
  courseKinds: any[] = [];

  constructor(private courseService: CourseService) {
  }

  ngOnInit(): void {
    this.courseService.getEnumConstants().subscribe((resp: any) => {
      this.courseForms = resp.courseForms;
      this.courseTypes = resp.courseTypes;
      this.passingMethods = resp.passingMethods;
      this.courseKinds = resp.courseKinds;
    })
  }

  createCourse() {
    this.courseService.createCourse(this.course).subscribe((resp: any) => {
      console.log(resp);
      this.course = {}
    })
  }
}
