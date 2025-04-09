package manager;

import Entities.*;

import java.util.*;

public class HospitalManager {

    private final Map<Integer, Doctor> doctorMap = new HashMap<>();
    private final Map<Integer, Patient> patientMap = new HashMap<>();
    private final Map<Integer, RoomDetail> roomMap = new HashMap<>();

    public void addDoctor(Doctor doctor) {
        doctorMap.put(doctor.getDoctorId(), doctor);
    }

    public void addPatient(Patient patient, int doctorId, Integer roomNo) {
        Doctor doctor = doctorMap.get(doctorId);
        if (doctor == null) {
            System.out.println("Doctor with ID " + doctorId + " not found!");
            return;
        }

        // Build RoomDetail using builder
        RoomDetail room = new RoomDetail.Builder()
                .setRoomNo(roomNo)
                .setDoctor(doctor)
                .setPatient(patient)
                .build();

        patient.setAssignedDoctor(doctor);
        patient.setRoomDetail(room);

        roomMap.put(roomNo, room);
        patientMap.put(patient.getPatientId(), patient);

        doctor.getHandlingPatience().add(patient);
        doctor.getHandlingRooms().add(room);
    }

    public void updatePatientRoom(int patientId, int newRoomNo) {
        Patient patient = patientMap.get(patientId);
        if (patient == null) {
            System.out.println("Patient not found");
            return;
        }

        RoomDetail oldRoom = patient.getRoomDetail();
        if (oldRoom != null) {
            roomMap.remove(oldRoom.getRoomNo());
            patient.getAssignedDoctor().getHandlingRooms().remove(oldRoom);
        }

        RoomDetail newRoom = new RoomDetail.Builder()
                .setRoomNo(newRoomNo)
                .setDoctor(patient.getAssignedDoctor())
                .setPatient(patient)
                .build();

        patient.setRoomDetail(newRoom);
        roomMap.put(newRoomNo, newRoom);
        patient.getAssignedDoctor().getHandlingRooms().add(newRoom);

        System.out.println("Room updated for patient " + patient.getPatientName() + " to room " + newRoomNo);
    }

    public void printAllDoctors() {
        System.out.println("===== Doctor Details =====");
        for (Doctor doctor : doctorMap.values()) {
            System.out.println("Doctor ID: " + doctor.getDoctorId());
            System.out.println("Doctor Name: " + doctor.getDoctorName());
            System.out.println("Patients: ");
            for (Patient p : doctor.getHandlingPatience()) {
                System.out.println(" - " + p.getPatientName());
            }
            System.out.println("Rooms: ");
            for (RoomDetail r : doctor.getHandlingRooms()) {
                System.out.println(" - Room No: " + r.getRoomNo());
            }
            System.out.println("----------------------------");
        }
    }

    public void printAllPatients() {
        System.out.println("===== Patient Details =====");
        for (Patient patient : patientMap.values()) {
            System.out.println("Patient ID: " + patient.getPatientId());
            System.out.println("Patient Name: " + patient.getPatientName());
            System.out.println("Assigned Doctor: " + (patient.getAssignedDoctor() != null ? patient.getAssignedDoctor().getDoctorName() : "None"));
            System.out.println("Room No: " + (patient.getRoomDetail() != null ? patient.getRoomDetail().getRoomNo() : "None"));
            System.out.println("----------------------------");
        }
    }

    public void printAllRooms() {
        System.out.println("===== Room Details =====");
        for (RoomDetail room : roomMap.values()) {
            System.out.println("Room No: " + room.getRoomNo());
            System.out.println("Patient: " + (room.getPatient() != null ? room.getPatient().getPatientName() : "None"));
            System.out.println("Doctor: " + (room.getDoctor() != null ? room.getDoctor().getDoctorName() : "None"));
            System.out.println("----------------------------");
        }
    }

    public void printDoctorById(int doctorId) {
        Doctor doctor = doctorMap.get(doctorId);
        if (doctor == null) {
            System.out.println("Doctor with ID " + doctorId + " not found.");
            return;
        }

        System.out.println("===== Doctor Details =====");
        System.out.println("Doctor ID: " + doctor.getDoctorId());
        System.out.println("Doctor Name: " + doctor.getDoctorName());

        System.out.println("Patients:");
        for (Patient p : doctor.getHandlingPatience()) {
            System.out.println(" - " + p.getPatientName());
        }

        System.out.println("Rooms:");
        for (RoomDetail r : doctor.getHandlingRooms()) {
            System.out.println(" - Room No: " + r.getRoomNo());
        }

        System.out.println("----------------------------");
    }

    public void printPatientById(int patientId) {
        Patient patient = patientMap.get(patientId);
        if (patient == null) {
            System.out.println("Patient with ID " + patientId + " not found.");
            return;
        }

        System.out.println("===== Patient Details =====");
        System.out.println("Patient ID: " + patient.getPatientId());
        System.out.println("Patient Name: " + patient.getPatientName());
        System.out.println("Assigned Doctor: " + (patient.getAssignedDoctor() != null ? patient.getAssignedDoctor().getDoctorName() : "None"));
        System.out.println("Room No: " + (patient.getRoomDetail() != null ? patient.getRoomDetail().getRoomNo() : "None"));
        System.out.println("----------------------------");
    }
}
