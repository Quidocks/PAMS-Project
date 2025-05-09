import java.time.LocalTime;

public class PatientAppointment {
    private String patientName;
    private LocalTime appointmentTime;

    public PatientAppointment(String patientName, LocalTime appointmentTime) {
        this.patientName = patientName;
        this.appointmentTime = appointmentTime;
    }

    public LocalTime getTime() {
        return appointmentTime;
    }

    public String getPatientName() {
        return patientName;
    }

    @Override
    public String toString() {
        return "PatientAppointment{" +
                "patientName='" + patientName + '\'' +
                ", appointmentTime=" + appointmentTime +
                '}';
    }
}
