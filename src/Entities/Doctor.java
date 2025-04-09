package Entities;

import java.util.Set;

public class Doctor {
    private Integer doctorId;
    private String doctorName;
    private Set<Patient> handlingPatience;
    private Set<RoomDetail> handlingRooms;

    private Doctor(Builder builder) {
        this.doctorId = builder.doctorId;
        this.doctorName = builder.doctorName;
        this.handlingPatience = builder.handlingPatience;
        this.handlingRooms = builder.handlingRooms;
    }

    public Integer getDoctorId() { return doctorId; }
    public String getDoctorName() { return doctorName; }
    public Set<Patient> getHandlingPatience() { return handlingPatience; }
    public Set<RoomDetail> getHandlingRooms() { return handlingRooms; }

    public void setHandlingPatience(Set<Patient> handlingPatience) {
        this.handlingPatience = handlingPatience;
    }

    public void setHandlingRooms(Set<RoomDetail> handlingRooms) {
        this.handlingRooms = handlingRooms;
    }

    public static class Builder {
        private Integer doctorId;
        private String doctorName;
        private Set<Patient> handlingPatience;
        private Set<RoomDetail> handlingRooms;

        public Builder setDoctorId(Integer doctorId) {
            this.doctorId = doctorId;
            return this;
        }

        public Builder setDoctorName(String doctorName) {
            this.doctorName = doctorName;
            return this;
        }

        public Builder setHandlingPatience(Set<Patient> handlingPatience) {
            this.handlingPatience = handlingPatience;
            return this;
        }

        public Builder setHandlingRooms(Set<RoomDetail> handlingRooms) {
            this.handlingRooms = handlingRooms;
            return this;
        }

        public Doctor build() {
            return new Doctor(this);
        }
    }

    @Override
    public String toString() {
        return "Doctor{" + "id=" + doctorId + ", name='" + doctorName + '\'' + '}';
    }
}
