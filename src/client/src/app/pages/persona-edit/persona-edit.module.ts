import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PersonaEditComponent } from './persona-edit.component';
import { PersonaEditRoutingModule } from './persona-edit-routing.module';
import { FormsModule } from '@angular/forms';
import { SharedModule } from '../../shared/shared.module';


@NgModule({
  imports: [
    CommonModule,
    PersonaEditRoutingModule,
    FormsModule,
    SharedModule
  ],
  declarations: [
    PersonaEditComponent
  ]
})
export class PersonaEditModule { }
