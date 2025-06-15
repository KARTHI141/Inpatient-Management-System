import { Component } from '@angular/core';
import { Patient } from '../patient.interface';
import { PostPatientService } from '../post-patient.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent {
  patient: Patient = {
    patientId: null,
    name: '',
    age: null,
    gender: '',
    patientRecordId: null
  };

  constructor(private service: PostPatientService, private router: Router) {} // Inject Router

  onSubmit() {
    // Call the service method to save the patient data
    this.service.postPatient(this.patient).subscribe(
      response => {
        console.log('Patient data saved successfully:', response);
        this.router.navigate(['/patient-list']); 
     
      },
      error => {
        console.error('Error saving patient data:', error);
        
      }
    );
  }
}
