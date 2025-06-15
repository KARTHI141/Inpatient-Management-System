import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { PatientComponent } from './patient/patient.component';
import { PatientRecordComponent } from './patient-record/patient-record.component';





 const routes: Routes = [
  { path: 'patient-list', component: PatientRecordComponent },
  { path: 'add-patient', component: PatientComponent },


  
  { path: '', redirectTo: '', pathMatch: 'full' }, 
  { path: '**', redirectTo: '' } ,
  
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
