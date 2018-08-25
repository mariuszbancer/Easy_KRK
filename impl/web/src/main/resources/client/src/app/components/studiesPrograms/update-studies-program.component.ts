import {StudiesProgramService} from "../../services/rest/studiesProgram.service";
import {ModuleService} from "../../services/rest/module.service";
import {EducationProgramService} from "../../services/rest/educationProgram.service";
import {Component, OnInit} from "@angular/core";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'update-studies-program',
  templateUrl: './update-studies-program-component.html',
})
export class UpdateStudiesProgramComponent implements OnInit {

  studiesProgram = {
    modules: [],
    educationProgramId: null
  };
  modules = [];
  educationPrograms = [];
  selectedModule = null;
  selectedEducationProgram = null;


  constructor(private moduleService: ModuleService,
              private studiesProgramService: StudiesProgramService,
              private educationProgramService: EducationProgramService,
              private route: ActivatedRoute) {

  }

  ngOnInit(): void {
    this.moduleService.getAllModules().subscribe((resp: any) => {
      this.modules = resp;
    });
    this.educationProgramService.getAllEducationPrograms().subscribe((resp: any) => {
      this.educationPrograms = resp;
    });
    this.route.params.subscribe(params => {
      let studiesProgramId = +params['id'];
      this.studiesProgramService.getById(studiesProgramId).subscribe((resp: any) => {
        this.studiesProgram = resp;
        if(this.studiesProgram.educationProgramId) {
          for(var i = 0; i < this.educationPrograms.length ; i ++) {
            if(this.educationPrograms[i].id == this.studiesProgram.educationProgramId) {
              this.selectedEducationProgram = this.educationPrograms[i];
            }
          }
        }
      });
    });
  }

  addModule() {
    if (this.selectedModule != null) {
      this.studiesProgram.modules.push(this.selectedModule);
    }
  }

  deleteModule(moduleId: any) {
    for (var i = 0; i < this.studiesProgram.modules.length; i++) {
      if (this.studiesProgram.modules[i].id == moduleId) {
        this.studiesProgram.modules.splice(i, 1);
      }
    }
  }

  selectModule(event: any) {
    let moduleId = event.target.value;
    let modulesToIterate = this.modules;
    for (let module of modulesToIterate) {
      if (module.id == moduleId) {
        this.selectedModule = module;
      }
    }
  }

  selectEducationProgram(event: any) {
    let educationProgramId = event.target.value;
    let educationProgramsToIterate = this.educationPrograms;
    for (let educationProgram of educationProgramsToIterate) {
      if (educationProgram.id == educationProgramId) {
        this.selectedEducationProgram = educationProgram;
      }
    }
  }

  save() {
    this.studiesProgramService.update(this.studiesProgram).subscribe((resp: any) => {
      this.studiesProgram = resp;
    })
  }
}
