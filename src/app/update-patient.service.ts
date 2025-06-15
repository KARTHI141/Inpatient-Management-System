import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Patient } from './patient.interface';

@Injectable({
  providedIn: 'root'
})
export class UpdatePatientService {

  private baseUrl = 'http://localhost:8080/patient';

  constructor(private http: HttpClient) { }

  updatePatient(patientId: number, updatedPatient: Patient): Observable<any> {
    const url = `${this.baseUrl}/${patientId}`;
    return this.http.put<any>(url, updatedPatient);
  }
}
