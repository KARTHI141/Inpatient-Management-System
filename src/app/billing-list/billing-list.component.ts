import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { BillingRecord } from '../patient.interface';

@Component({
  selector: 'app-billing-list',
  templateUrl: './billing-list.component.html',
  styleUrls: ['./billing-list.component.css']
})
export class BillingListComponent implements OnInit {
  records: BillingRecord[] = [];
  filteredRecords: BillingRecord[] = [];
  searchTerm = '';
  deleteId: number | null = null;
  payId: number | null = null;
  paymentMethod = 'CASH';
  message = '';

  constructor(private api: ApiService) {}

  ngOnInit(): void {
    this.loadRecords();
  }

  loadRecords(): void {
    this.api.getBillingRecords().subscribe(data => {
      this.records = data;
      this.filteredRecords = data;
    });
  }

  search(): void {
    if (!this.searchTerm.trim()) {
      this.filteredRecords = this.records;
      return;
    }
    this.api.searchBilling(this.searchTerm.trim()).subscribe(data => {
      this.filteredRecords = data;
    });
  }

  confirmPay(id: number): void {
    this.payId = id;
    this.paymentMethod = 'CASH';
  }

  cancelPay(): void {
    this.payId = null;
  }

  onPay(): void {
    if (this.payId === null) return;
    this.api.markBillingAsPaid(this.payId, this.paymentMethod).subscribe(() => {
      this.message = 'Payment recorded successfully';
      this.payId = null;
      this.loadRecords();
      setTimeout(() => this.message = '', 3000);
    });
  }

  confirmDelete(id: number): void {
    this.deleteId = id;
  }

  cancelDelete(): void {
    this.deleteId = null;
  }

  onDelete(): void {
    if (this.deleteId === null) return;
    this.api.deleteBillingRecord(this.deleteId).subscribe(() => {
      this.message = 'Billing record deleted successfully';
      this.deleteId = null;
      this.loadRecords();
      setTimeout(() => this.message = '', 3000);
    });
  }

  getTotalAmount(): number {
    return this.filteredRecords.reduce((sum, r) => sum + (r.amount || 0), 0);
  }

  getPaidAmount(): number {
    return this.filteredRecords.filter(r => r.status === 'PAID').reduce((sum, r) => sum + (r.amount || 0), 0);
  }

  getPendingAmount(): number {
    return this.filteredRecords.filter(r => r.status === 'PENDING').reduce((sum, r) => sum + (r.amount || 0), 0);
  }
}
