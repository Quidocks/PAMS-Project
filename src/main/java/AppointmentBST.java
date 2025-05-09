public class AppointmentBST {
    private AppointmentNode root;

    public AppointmentBST() {
        root = null;
    }

    public void addAppointment(PatientAppointment appointment) {
        root = insertRec(root, appointment);
    }

    private AppointmentNode insertRec(AppointmentNode root, PatientAppointment appointment) {
        if (root == null) {
            // Empty spot: insert here
            return new AppointmentNode(appointment);
        }

        // Compare appointment times
        if (appointment.getTime().isBefore(root.data.getTime())) {
            // Go left
            root.left = insertRec(root.left, appointment);
        } else if (appointment.getTime().isAfter(root.data.getTime())) {
            // Go right
            root.right = insertRec(root.right, appointment);
        } else {
            // Duplicate time: do nothing
            System.out.println("Duplicate appointment time at " + appointment.getTime() + ". Skipping insert.");
        }

        return root;
    }

    public void inOrderTraversal(AppointmentNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.data);
            inOrderTraversal(node.right);
        }
    }

    public AppointmentNode getRoot() {
        return root;
    }
}
