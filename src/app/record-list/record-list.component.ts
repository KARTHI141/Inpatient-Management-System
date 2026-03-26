import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { PatientRecord } from '../patient.interface';

@Component({
  selector: 'app-record-list',
  templateUrl: './record-list.component.html',
  styleUrls: ['./record-list.component.css']
})
export class RecordListComponent implements OnInit {
  records: PatientRecord[] = [];
  filteredRecords: PatientRecord[] = [];
  searchTerm = '';
  deleteId: number | null = null;
  message = '';

  constructor(private api: ApiService) {}

  ngOnInit(): void {
    this.loadRecords();
  }

  loadRecords(): void {
    this.api.getRecords().subscribe(data => {
      this.records = data;
      this.filteredRecords = data;
    });
  }

  search(): void {
    if (!this.searchTerm.trim()) {
      this.filteredRecords = this.records;
      return;
    }
    this.api.searchRecords(this.searchTerm.trim()).subscribe(data => {
      this.filteredRecords = data;
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
    this.api.deleteRecord(this.deleteId).subscribe(() => {
      this.message = 'Record deleted successfully';
      this.deleteId = null;
      this.loadRecords();
      setTimeout(() => this.message = '', 3000);
    });
  }
}
