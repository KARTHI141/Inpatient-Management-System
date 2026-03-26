import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { Patient } from '../patient.interface';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {
  patients: Patient[] = [];
  filteredPatients: Patient[] = [];
  searchTerm = '';
  deleteId: number | null = null;
  message = '';

  constructor(private api: ApiService) {}

  ngOnInit(): void {
    this.loadPatients();
  }

  loadPatients(): void {
    this.api.getPatients().subscribe(data => {
      this.patients = data;
      this.filteredPatients = data;
    });
  }

  search(): void {
    if (!this.searchTerm.trim()) {
      this.filteredPatients = this.patients;
      return;
    }
    this.api.searchPatients(this.searchTerm.trim()).subscribe(data => {
      this.filteredPatients = data;
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
    this.api.deletePatient(this.deleteId).subscribe(() => {
      this.message = 'Patient deleted successfully';
      this.deleteId = null;
      this.loadPatients();
      setTimeout(() => this.message = '', 3000);
    });
  }
}
