
package Entities;
import java.util.Set;

public class Doctor {
    Integer doctorId;
    String doctorName;
    Set<Patient> handlingPatience;
    Set<RoomDetail> handlingRooms;

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Set<Patient> getHandlingPatience() {
        return handlingPatience;
    }

    public void setHandlingPatience(Set<Patient> handlingPatience) {
        this.handlingPatience = handlingPatience;
    }

    public Set<RoomDetail> getHandlingRooms() {
        return handlingRooms;
    }

    public void setHandlingRooms(Set<RoomDetail> handlingRooms) {
        this.handlingRooms = handlingRooms;
    }

    @Override
    public String toString() {
        return "Doctor{" + "id=" + doctorId + ", name='" + doctorName + '\'' + '}';
    }
}
