import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../api.service';
import { BillingRecord } from '../patient.interface';

@Component({
  selector: 'app-billing-form',
  templateUrl: './billing-form.component.html',
  styleUrls: ['./billing-form.component.css']
})
export class BillingFormComponent implements OnInit {
  record: BillingRecord = {
    billingId: null, patientId: null, patientName: '',
    description: '', amount: null,
    billingDate: new Date().toISOString().split('T')[0],
    status: 'PENDING', paymentMethod: ''
  };
  isEdit = false;
  error = '';

  constructor(private api: ApiService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEdit = true;
      this.api.getBillingRecord(+id).subscribe(data => {
        this.record = data;
      });
    }
  }

  onSubmit(): void {
    this.error = '';
    if (this.isEdit && this.record.billingId) {
      this.api.updateBillingRecord(this.record.billingId, this.record).subscribe({
        next: () => this.router.navigate(['/billing']),
        error: () => this.error = 'Failed to update billing record'
      });
    } else {
      this.api.createBillingRecord(this.record).subscribe({
        next: () => this.router.navigate(['/billing']),
        error: () => this.error = 'Failed to create billing record'
      });
    }
  }
}
