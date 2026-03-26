import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { Admission } from '../patient.interface';

@Component({
  selector: 'app-admission-list',
  templateUrl: './admission-list.component.html',
  styleUrls: ['./admission-list.component.css']
})
export class AdmissionListComponent implements OnInit {
  admissions: Admission[] = [];
  filteredAdmissions: Admission[] = [];
  searchTerm = '';
  deleteId: number | null = null;
  dischargeId: number | null = null;
  message = '';

  constructor(private api: ApiService) {}

  ngOnInit(): void {
    this.loadAdmissions();
  }

  loadAdmissions(): void {
    this.api.getAdmissions().subscribe(data => {
      this.admissions = data;
      this.filteredAdmissions = data;
    });
  }

  search(): void {
    if (!this.searchTerm.trim()) {
      this.filteredAdmissions = this.admissions;
      return;
    }
    this.api.searchAdmissions(this.searchTerm.trim()).subscribe(data => {
      this.filteredAdmissions = data;
    });
  }

  confirmDischarge(id: number): void {
    this.dischargeId = id;
  }

  cancelDischarge(): void {
    this.dischargeId = null;
  }

  onDischarge(): void {
    if (this.dischargeId === null) return;
    this.api.dischargePatient(this.dischargeId).subscribe(() => {
      this.message = 'Patient discharged successfully';
      this.dischargeId = null;
      this.loadAdmissions();
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
    this.api.deleteAdmission(this.deleteId).subscribe(() => {
      this.message = 'Admission deleted successfully';
      this.deleteId = null;
      this.loadAdmissions();
      setTimeout(() => this.message = '', 3000);
    });
  }
}
