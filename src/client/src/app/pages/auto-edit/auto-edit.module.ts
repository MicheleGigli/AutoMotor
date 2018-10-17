import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AutoEditComponent } from './auto-edit.component';
import { AutoEditRoutingModule } from './auto-edit-routing.module';
import { FormsModule } from '@angular/forms';
import { SharedModule } from '../../shared/shared.module';


@NgModule({
  imports: [
    CommonModule,
    AutoEditRoutingModule,
    FormsModule,
    SharedModule
  ],
  declarations: [
    AutoEditComponent
  ]
})
export class AutoEditModule { }
