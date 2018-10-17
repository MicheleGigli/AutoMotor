import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PersonaListComponent } from './persona-list.component';
import { PersonaListRoutingModule } from './persona-list-routing.module';
import { FormsModule } from '@angular/forms';
import { SharedModule } from '../../shared/shared.module';


@NgModule({
  imports: [
    CommonModule,
    PersonaListRoutingModule,
    FormsModule,
    SharedModule
  ],
  declarations: [
    PersonaListComponent
  ]
})
export class PersonaListModule { }
