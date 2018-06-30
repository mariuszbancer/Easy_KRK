import {Component, OnInit} from "@angular/core";
import {CourseService} from "../../services/rest/course.service";
import {UsersService} from "../../services/rest/user.service";

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
  studiesProfiles: any[] = [];
  selectedGuardian: any = {};
  users: any[] = [];

  constructor(private courseService: CourseService,
              private userService: UsersService) {
  }

  ngOnInit(): void {
    this.courseService.getEnumConstants().subscribe((resp: any) => {
      this.courseForms = resp.courseForms;
      this.courseTypes = resp.courseTypes;
      this.passingMethods = resp.passingMethods;
      this.courseKinds = resp.courseKinds;
      this.studiesProfiles = resp.studiesProfiles;
    });

    this.userService.getAll().subscribe((resp: any) => {
      this.users = resp;
    });
  }

  createCourse() {
    this.courseService.createCourse(this.course).subscribe((resp: any) => {
      this.course = {}
    })
  }

  selectGuardian(event: any) {
    let guardianId = event.target.value;
    let guardiansToIterate = this.users;
    for(let guardian of guardiansToIterate) {
      if(guardian.id == guardianId) {
        this.selectedGuardian = guardian;
      }
    }
  }
}
