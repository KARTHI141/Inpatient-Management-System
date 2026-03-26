import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { DashboardStats } from '../patient.interface';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  stats: DashboardStats = {
    totalPatients: 0,
    totalRecords: 0,
    totalAdmissions: 0,
    activeAdmissions: 0,
    totalBilling: 0,
    totalRevenue: 0,
    pendingAmount: 0
  };

  constructor(private api: ApiService) {}

  ngOnInit(): void {
    this.api.getDashboardStats().subscribe(data => {
      this.stats = data;
    });
  }
}
