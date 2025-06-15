import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DeletePatientService {

  constructor(private http: HttpClient) { }

  deletePatient(patientId: number): Observable<any> {
    return this.http.delete<any>(`http://localhost:8080/patient/${patientId}`);
  }
}
