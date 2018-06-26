import {Component, OnInit} from "@angular/core";
import {ModuleService} from "../../services/rest/module.service";

@Component({
  selector: 'create-module',
  templateUrl: './create-module.component.html',
})
export class CreateModuleComponent implements OnInit {


  constructor(private moduleService: ModuleService) {
  }

  ngOnInit(): void {

  }

}
