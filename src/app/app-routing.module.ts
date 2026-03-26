import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { PatientFormComponent } from './patient-form/patient-form.component';
import { RecordListComponent } from './record-list/record-list.component';
import { RecordFormComponent } from './record-form/record-form.component';
import { AdmissionListComponent } from './admission-list/admission-list.component';
import { AdmissionFormComponent } from './admission-form/admission-form.component';
import { BillingListComponent } from './billing-list/billing-list.component';
import { BillingFormComponent } from './billing-form/billing-form.component';

const routes: Routes = [
  { path: '', component: DashboardComponent },
  { path: 'patients', component: PatientListComponent },
  { path: 'patients/new', component: PatientFormComponent },
  { path: 'patients/edit/:id', component: PatientFormComponent },
  { path: 'records', component: RecordListComponent },
  { path: 'records/new', component: RecordFormComponent },
  { path: 'records/edit/:id', component: RecordFormComponent },
  { path: 'admissions', component: AdmissionListComponent },
  { path: 'admissions/new', component: AdmissionFormComponent },
  { path: 'admissions/edit/:id', component: AdmissionFormComponent },
  { path: 'billing', component: BillingListComponent },
  { path: 'billing/new', component: BillingFormComponent },
  { path: 'billing/edit/:id', component: BillingFormComponent },
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
