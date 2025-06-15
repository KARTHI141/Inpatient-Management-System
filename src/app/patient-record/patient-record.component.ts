import { Component, OnInit, OnDestroy } from '@angular/core';
import { Patient } from '../patient.interface';
import { AddpatientService } from '../addpatient.service';
import { DeletePatientService } from '../delete.service';

import { Subscription } from 'rxjs';
import { UpdatePatientService } from '../update-patient.service';
@Component({
  selector: 'app-patient-record',
  templateUrl: './patient-record.component.html',
  styleUrls: ['./patient-record.component.css']
})
export class PatientRecordComponent implements OnInit, OnDestroy {
  patients: Patient[] = [];
  filteredPatients: Patient[] = [];
  searchPatientID: string | null = null;

  private subscription: Subscription = new Subscription();

  constructor(
    private addPatientService: AddpatientService,
    private deletePatientService: DeletePatientService,
    private putPatientService: UpdatePatientService
  ) {}

  ngOnInit(): void {
    this.subscription = this.addPatientService.getPatients().subscribe(patients => {
      this.patients = patients.reverse();
      this.filteredPatients = patients;
    });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  filterPatients(): void {
    if (!this.searchPatientID) {
      this.filteredPatients = this.patients;
      return;
    }

    const searchId = parseInt(this.searchPatientID.trim(), 10);
    if (!isNaN(searchId)) {
      this.filteredPatients = this.patients.filter(patient =>
        patient.patientId === searchId
      );
    } else {
      this.filteredPatients = this.patients;
    }
  }

  onDelete(patientId: number): void {
    this.deletePatientService.deletePatient(patientId).subscribe(
      response => {
        console.log('Patient deleted successfully');
        this.patients = this.patients.filter(patient => patient.patientId !== patientId);
        this.filterPatients();
      },
      error => {
        console.error('Error deleting patient:', error);
      }
    );
  }

  onEditButtonClick(patient: Patient): void {
    
  }
}
