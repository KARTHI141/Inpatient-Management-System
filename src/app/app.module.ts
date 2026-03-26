import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { PatientFormComponent } from './patient-form/patient-form.component';
import { RecordListComponent } from './record-list/record-list.component';
import { RecordFormComponent } from './record-form/record-form.component';
import { AdmissionListComponent } from './admission-list/admission-list.component';
import { AdmissionFormComponent } from './admission-form/admission-form.component';
import { BillingListComponent } from './billing-list/billing-list.component';
import { BillingFormComponent } from './billing-form/billing-form.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    PatientListComponent,
    PatientFormComponent,
    RecordListComponent,
    RecordFormComponent,
    AdmissionListComponent,
    AdmissionFormComponent,
    BillingListComponent,
    BillingFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
