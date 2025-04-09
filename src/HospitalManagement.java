import Entities.Doctor;
import Entities.Patient;
import manager.HospitalManager;

import java.util.HashSet;

public class HospitalManagement {
    public static void main(String[] args) {
        HospitalManager manager = new HospitalManager();

        Doctor d1 = new Doctor.Builder()
                .setDoctorId(1)
                .setDoctorName("Dr. House")
                .setHandlingPatience(new HashSet<>())
                .setHandlingRooms(new HashSet<>())
                .build();
        manager.addDoctor(d1);

        Patient p1 = new Patient.Builder()
                .setPatientId(101)
                .setPatientName("John Doe")
                .build();
        manager.addPatient(p1, 1, 200);

        Patient p2 = new Patient.Builder()
                .setPatientId(102)
                .setPatientName("Jane Roe")
                .build();
        manager.addPatient(p2, 1, 201);

        manager.printAllDoctors();
        manager.printDoctorById(1);
        manager.printPatientById(101);
        manager.printPatientById(102);
    }
}
