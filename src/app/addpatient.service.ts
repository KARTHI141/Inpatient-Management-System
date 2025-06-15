import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Patient } from './patient.interface';

@Injectable({
  providedIn: 'root'
})
export class AddpatientService {

  constructor(private http: HttpClient) { }

  getPatients(): Observable<Patient[]> {
    
    return this.http.get<Patient[]>("http://localhost:8080/patients");
  }

  getPatientById(patientId: number): Observable<Patient> {
    
    return this.http.get<Patient>(`http://localhost:8080/patients/${patientId}`);
  }
}
