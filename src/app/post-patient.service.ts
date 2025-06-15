import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Patient } from './patient.interface';

@Injectable({
  providedIn: 'root'
})
export class PostPatientService {

  constructor(private http: HttpClient) { }

  
  postPatient(patientData: Patient): Observable<Patient[]> {
    
    return this.http.post<Patient[]>("http://localhost:8080/patient", patientData);
  }
}
