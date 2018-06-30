import {Component, OnInit} from "@angular/core";
import {ModuleService} from "../../services/rest/module.service";
import {StudiesProgramService} from "../../services/rest/studiesProgram.service";
import {EducationProgramService} from "../../services/rest/educationProgram.service";

@Component({
  selector: 'create-studies-program',
  templateUrl: './create-studies-program.component.html',
})
export class CreateStudiesProgramComponent implements OnInit {

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
              private educationProgramService: EducationProgramService) {

  }

  ngOnInit(): void {
    this.moduleService.getAllModules().subscribe((resp: any) => {
      this.modules = resp;
    });
    this.educationProgramService.getAllEducationPrograms().subscribe((resp: any) => {
      this.educationPrograms = resp;
    })
  }

  addModule() {
    if(this.selectedModule != null) {
      this.studiesProgram.modules.push(this.selectedModule);
    }
  }

  deleteModule(moduleId: any) {
    for(var i = 0; i < this.studiesProgram.modules.length ; i++) {
      if (this.studiesProgram.modules[i].id == moduleId) {
        this.studiesProgram.modules.splice(i, 1);
      }
    }
  }

  selectModule(event: any) {
    let moduleId = event.target.value;
    console.log(moduleId);
    let modulesToIterate = this.modules;
    for(let module of modulesToIterate) {
      if(module.id == moduleId) {
        this.selectedModule = module;
      }
    }
  }

  selectEducationProgram(event: any) {
    let educationProgramId = event.target.value;
    console.log(educationProgramId);
    let educationProgramsToIterate = this.educationPrograms;
    for(let educationProgram of educationProgramsToIterate) {
      if(educationProgram.id == educationProgramId) {
        this.selectedEducationProgram = educationProgram;
      }
    }
  }

  save() {
    this.studiesProgram.educationProgramId = this.selectedEducationProgram.id;
    this.studiesProgramService.create(this.studiesProgram).subscribe((resp: any) => {
      this.studiesProgram = {
        modules: [],
        educationProgramId: null
      }
    })
  }

}
