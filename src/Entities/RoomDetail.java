package Entities;

public class RoomDetail {
    private Integer roomNo;
    private Patient patient;
    private Doctor doctor;

    private RoomDetail(Builder builder) {
        this.roomNo = builder.roomNo;
        this.patient = builder.patient;
        this.doctor = builder.doctor;
    }

    public Integer getRoomNo() { return roomNo; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public static class Builder {
        private Integer roomNo;
        private Patient patient;
        private Doctor doctor;

        public Builder setRoomNo(Integer roomNo) {
            this.roomNo = roomNo;
            return this;
        }

        public Builder setPatient(Patient patient) {
            this.patient = patient;
            return this;
        }

        public Builder setDoctor(Doctor doctor) {
            this.doctor = doctor;
            return this;
        }

        public RoomDetail build() {
            return new RoomDetail(this);
        }
    }

    @Override
    public String toString() {
        return "Room{" + "roomNo=" + roomNo + ", patient=" + (patient != null ? patient.getPatientName() : "null") + '}';
    }
}
