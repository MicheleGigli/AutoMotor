import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AutoListComponent } from './auto-list.component';

const routes: Routes = [
  {
    path: '',
    component: AutoListComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AutoListRoutingModule { }
