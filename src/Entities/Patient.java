package Entities;

public class Patient {
    private Integer patientId;
    private String patientName;
    private RoomDetail roomDetail;
    private Doctor assignedDoctor;

    private Patient(Builder builder) {
        this.patientId = builder.patientId;
        this.patientName = builder.patientName;
        this.roomDetail = builder.roomDetail;
        this.assignedDoctor = builder.assignedDoctor;
    }

    public Integer getPatientId() { return patientId; }
    public String getPatientName() { return patientName; }
    public RoomDetail getRoomDetail() { return roomDetail; }
    public Doctor getAssignedDoctor() { return assignedDoctor; }

    public void setRoomDetail(RoomDetail roomDetail) {
        this.roomDetail = roomDetail;
    }

    public void setAssignedDoctor(Doctor assignedDoctor) {
        this.assignedDoctor = assignedDoctor;
    }

    public static class Builder {
        private Integer patientId;
        private String patientName;
        private RoomDetail roomDetail;
        private Doctor assignedDoctor;

        public Builder setPatientId(Integer patientId) {
            this.patientId = patientId;
            return this;
        }

        public Builder setPatientName(String patientName) {
            this.patientName = patientName;
            return this;
        }

        public Builder setRoomDetail(RoomDetail roomDetail) {
            this.roomDetail = roomDetail;
            return this;
        }

        public Builder setAssignedDoctor(Doctor assignedDoctor) {
            this.assignedDoctor = assignedDoctor;
            return this;
        }

        public Patient build() {
            return new Patient(this);
        }
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + patientId + ", name='" + patientName + '\'' + ", room=" + roomDetail + '}';
    }
}
