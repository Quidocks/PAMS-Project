public class AppointmentNode {
    public PatientAppointment data;
    public AppointmentNode left;
    public AppointmentNode right;

    public AppointmentNode(PatientAppointment appointment) {
        this.data = appointment;
        this.left = null;
        this.right = null;
    }
}
