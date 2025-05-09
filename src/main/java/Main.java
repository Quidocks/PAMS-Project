import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        AppointmentBST bst = new AppointmentBST();

        PatientAppointment appt1 = new PatientAppointment("John Doe", LocalTime.of(10, 0));
        PatientAppointment appt2 = new PatientAppointment("Jane Smith", LocalTime.of(9, 0));
        PatientAppointment appt3 = new PatientAppointment("Bob Lee", LocalTime.of(10, 0)); // duplicate

        bst.addAppointment(appt1);
        bst.addAppointment(appt2);
        bst.addAppointment(appt3);

        System.out.println("\nIn-order traversal of appointments:");
        bst.inOrderTraversal(bst.getRoot());
    }
}
