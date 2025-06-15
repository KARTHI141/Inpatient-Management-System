import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PatientRecordComponent } from './patient-record/patient-record.component';
import { PatientComponent } from './patient/patient.component';

import { FormsModule } from '@angular/forms';

import { HttpClientModule } from '@angular/common/http';




@NgModule({
  declarations: [
    AppComponent,
    PatientComponent,
    PatientRecordComponent,
    
    
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [HttpClientModule,],
  bootstrap: [AppComponent]
})
export class AppModule { }
