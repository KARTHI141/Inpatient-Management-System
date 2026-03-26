import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../api.service';
import { Patient } from '../patient.interface';

@Component({
  selector: 'app-patient-form',
  templateUrl: './patient-form.component.html',
  styleUrls: ['./patient-form.component.css']
})
export class PatientFormComponent implements OnInit {
  patient: Patient = { patientId: null, name: '', age: null, gender: '', phone: '', address: '' };
  isEdit = false;
  message = '';
  error = '';

  constructor(private api: ApiService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEdit = true;
      this.api.getPatient(+id).subscribe(data => {
        this.patient = data;
      });
    }
  }

  onSubmit(): void {
    this.error = '';
    if (!this.patient.name.trim()) {
      this.error = 'Name is required';
      return;
    }

    if (this.isEdit && this.patient.patientId) {
      this.api.updatePatient(this.patient.patientId, this.patient).subscribe({
        next: () => {
          this.router.navigate(['/patients']);
        },
        error: () => {
          this.error = 'Failed to update patient';
        }
      });
    } else {
      this.api.createPatient(this.patient).subscribe({
        next: () => {
          this.router.navigate(['/patients']);
        },
        error: () => {
          this.error = 'Failed to create patient';
        }
      });
    }
  }
}
