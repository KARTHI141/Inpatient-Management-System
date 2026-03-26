import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Patient, PatientRecord, Admission, BillingRecord, DashboardStats } from './patient.interface';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private baseUrl = environment.apiUrl;

  constructor(private http: HttpClient) {}

  // Dashboard
  getDashboardStats(): Observable<DashboardStats> {
    return this.http.get<DashboardStats>(`${this.baseUrl}/dashboard`);
  }

  // Patients
  getPatients(): Observable<Patient[]> {
    return this.http.get<Patient[]>(`${this.baseUrl}/patients`);
  }

  getPatient(id: number): Observable<Patient> {
    return this.http.get<Patient>(`${this.baseUrl}/patients/${id}`);
  }

  createPatient(patient: Patient): Observable<Patient> {
    return this.http.post<Patient>(`${this.baseUrl}/patients`, patient);
  }

  updatePatient(id: number, patient: Patient): Observable<Patient> {
    return this.http.put<Patient>(`${this.baseUrl}/patients/${id}`, patient);
  }

  deletePatient(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/patients/${id}`);
  }

  searchPatients(keyword: string): Observable<Patient[]> {
    return this.http.get<Patient[]>(`${this.baseUrl}/patients/search/${keyword}`);
  }

  // Patient Records
  getRecords(): Observable<PatientRecord[]> {
    return this.http.get<PatientRecord[]>(`${this.baseUrl}/records`);
  }

  getRecord(id: number): Observable<PatientRecord> {
    return this.http.get<PatientRecord>(`${this.baseUrl}/records/${id}`);
  }

  createRecord(record: PatientRecord): Observable<PatientRecord> {
    return this.http.post<PatientRecord>(`${this.baseUrl}/records`, record);
  }

  updateRecord(id: number, record: PatientRecord): Observable<PatientRecord> {
    return this.http.put<PatientRecord>(`${this.baseUrl}/records/${id}`, record);
  }

  deleteRecord(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/records/${id}`);
  }

  getRecordsByPatient(patientId: number): Observable<PatientRecord[]> {
    return this.http.get<PatientRecord[]>(`${this.baseUrl}/records/patient/${patientId}`);
  }

  searchRecords(keyword: string): Observable<PatientRecord[]> {
    return this.http.get<PatientRecord[]>(`${this.baseUrl}/records/search/${keyword}`);
  }

  // Admissions
  getAdmissions(): Observable<Admission[]> {
    return this.http.get<Admission[]>(`${this.baseUrl}/admissions`);
  }

  getAdmission(id: number): Observable<Admission> {
    return this.http.get<Admission>(`${this.baseUrl}/admissions/${id}`);
  }

  createAdmission(admission: Admission): Observable<Admission> {
    return this.http.post<Admission>(`${this.baseUrl}/admissions`, admission);
  }

  updateAdmission(id: number, admission: Admission): Observable<Admission> {
    return this.http.put<Admission>(`${this.baseUrl}/admissions/${id}`, admission);
  }

  dischargePatient(id: number): Observable<Admission> {
    return this.http.put<Admission>(`${this.baseUrl}/admissions/${id}/discharge`, {});
  }

  deleteAdmission(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/admissions/${id}`);
  }

  searchAdmissions(keyword: string): Observable<Admission[]> {
    return this.http.get<Admission[]>(`${this.baseUrl}/admissions/search/${keyword}`);
  }

  // Billing
  getBillingRecords(): Observable<BillingRecord[]> {
    return this.http.get<BillingRecord[]>(`${this.baseUrl}/billing`);
  }

  getBillingRecord(id: number): Observable<BillingRecord> {
    return this.http.get<BillingRecord>(`${this.baseUrl}/billing/${id}`);
  }

  createBillingRecord(record: BillingRecord): Observable<BillingRecord> {
    return this.http.post<BillingRecord>(`${this.baseUrl}/billing`, record);
  }

  updateBillingRecord(id: number, record: BillingRecord): Observable<BillingRecord> {
    return this.http.put<BillingRecord>(`${this.baseUrl}/billing/${id}`, record);
  }

  markBillingAsPaid(id: number, paymentMethod: string): Observable<BillingRecord> {
    return this.http.put<BillingRecord>(`${this.baseUrl}/billing/${id}/pay`, { paymentMethod });
  }

  deleteBillingRecord(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/billing/${id}`);
  }

  searchBilling(keyword: string): Observable<BillingRecord[]> {
    return this.http.get<BillingRecord[]>(`${this.baseUrl}/billing/search/${keyword}`);
  }
}
