import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AutoEditComponent } from './auto-edit.component';

const routes: Routes = [
  {
    path: '',
    component: AutoEditComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AutoEditRoutingModule { }
