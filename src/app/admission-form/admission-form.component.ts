import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../api.service';
import { Admission } from '../patient.interface';

@Component({
  selector: 'app-admission-form',
  templateUrl: './admission-form.component.html',
  styleUrls: ['./admission-form.component.css']
})
export class AdmissionFormComponent implements OnInit {
  admission: Admission = {
    admissionId: null, patientId: null, patientName: '',
    admissionDate: new Date().toISOString().split('T')[0],
    dischargeDate: null, ward: '', roomNumber: null, bedNumber: null, status: 'ADMITTED'
  };
  isEdit = false;
  error = '';

  constructor(private api: ApiService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEdit = true;
      this.api.getAdmission(+id).subscribe(data => {
        this.admission = data;
      });
    }
  }

  onSubmit(): void {
    this.error = '';
    if (this.isEdit && this.admission.admissionId) {
      this.api.updateAdmission(this.admission.admissionId, this.admission).subscribe({
        next: () => this.router.navigate(['/admissions']),
        error: () => this.error = 'Failed to update admission'
      });
    } else {
      this.api.createAdmission(this.admission).subscribe({
        next: () => this.router.navigate(['/admissions']),
        error: () => this.error = 'Failed to create admission'
      });
    }
  }
}
