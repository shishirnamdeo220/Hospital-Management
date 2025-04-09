
package Entities;

public class RoomDetail {
    Integer roomNo;
    Patient patient;
    Doctor doctor;

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Room{" + "roomNo=" + roomNo + ", patient=" + (patient != null ? patient.patientName : "null") + '}';
    }
}
