export interface Patient {
  patientId: number | null;
  name: string;
  age: number | null;
  gender: string;
  phone: string;
  address: string;
}

export interface PatientRecord {
  patientRecordId: number | null;
  patientId: number | null;
  doctorId: number | null;
  doctorName: string;
  disease: string;
  treatment: string;
  doctorNotes: string;
  roomNumber: number | null;
  bedNumber: number | null;
}

export interface Admission {
  admissionId: number | null;
  patientId: number | null;
  patientName: string;
  admissionDate: string;
  dischargeDate: string | null;
  ward: string;
  roomNumber: number | null;
  bedNumber: number | null;
  status: string;
}

export interface BillingRecord {
  billingId: number | null;
  patientId: number | null;
  patientName: string;
  description: string;
  amount: number | null;
  billingDate: string;
  status: string;
  paymentMethod: string;
}

export interface DashboardStats {
  totalPatients: number;
  totalRecords: number;
  totalAdmissions: number;
  activeAdmissions: number;
  totalBilling: number;
  totalRevenue: number;
  pendingAmount: number;
}