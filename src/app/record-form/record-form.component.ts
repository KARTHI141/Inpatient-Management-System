import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../api.service';
import { PatientRecord } from '../patient.interface';

@Component({
  selector: 'app-record-form',
  templateUrl: './record-form.component.html',
  styleUrls: ['./record-form.component.css']
})
export class RecordFormComponent implements OnInit {
  record: PatientRecord = {
    patientRecordId: null, patientId: null, doctorId: null,
    doctorName: '', disease: '', treatment: '', doctorNotes: '',
    roomNumber: null, bedNumber: null
  };
  isEdit = false;
  error = '';

  constructor(private api: ApiService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEdit = true;
      this.api.getRecord(+id).subscribe(data => {
        this.record = data;
      });
    }
  }

  onSubmit(): void {
    this.error = '';
    if (this.isEdit && this.record.patientRecordId) {
      this.api.updateRecord(this.record.patientRecordId, this.record).subscribe({
        next: () => this.router.navigate(['/records']),
        error: () => this.error = 'Failed to update record'
      });
    } else {
      this.api.createRecord(this.record).subscribe({
        next: () => this.router.navigate(['/records']),
        error: () => this.error = 'Failed to create record'
      });
    }
  }
}
