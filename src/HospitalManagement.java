import Entities.Doctor;
import Entities.Patient;
import manager.HospitalManager;

import java.util.HashSet;

public class HospitalManagement {
    public static void main(String[] args) {
        HospitalManager manager = new HospitalManager();

        Doctor d1 = new Doctor();
        d1.setDoctorId(1);
        d1.setDoctorName("Dr. House");
        d1.setHandlingPatience(new HashSet<>());
        d1.setHandlingRooms(new HashSet<>());
        manager.addDoctor(d1);

        Patient p1 = new Patient();
        p1.setPatientId(101);
        p1.setPatientName("John Doe");
        manager.addPatient(p1, 1, 200);

        Patient p2 = new Patient();
        p2.setPatientId(102);
        p2.setPatientName("Jane Roe");
        manager.addPatient(p2, 1, 201);
        manager.printAllDoctors();
        manager.printAllDoctors();
        manager.printDoctorById(1);
        manager.printPatientById(101);
        manager.printPatientById(102);
    }
}
