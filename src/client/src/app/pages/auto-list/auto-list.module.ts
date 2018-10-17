import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AutoListComponent } from './auto-list.component';
import { AutoListRoutingModule } from './auto-list-routing.module';
import { FormsModule } from '@angular/forms';
import { SharedModule } from '../../shared/shared.module';


@NgModule({
  imports: [
    CommonModule,
    AutoListRoutingModule,
    FormsModule,
    SharedModule
  ],
  declarations: [
    AutoListComponent
  ]
})
export class AutoListModule { }
