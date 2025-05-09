import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentBSTTest {
    private AppointmentBST bst;

    @BeforeEach
    void setUp() {
        bst = new AppointmentBST();
    }

    @Test
    void testInsertSingleAppointment() {
        PatientAppointment appt = new PatientAppointment("Alice", LocalTime.of(9, 0));
        bst.addAppointment(appt);

        List<PatientAppointment> result = new ArrayList<>();
        collectInOrder(bst.getRoot(), result);

        assertEquals(1, result.size());
        assertEquals(appt, result.get(0));
    }

    @Test
    void testDuplicateInsertion() {
        PatientAppointment appt1 = new PatientAppointment("Bob", LocalTime.of(10, 0));
        PatientAppointment appt2 = new PatientAppointment("Charlie", LocalTime.of(10, 0)); // duplicate

        bst.addAppointment(appt1);
        bst.addAppointment(appt2);

        List<PatientAppointment> result = new ArrayList<>();
        collectInOrder(bst.getRoot(), result);

        assertEquals(1, result.size());  // Only one should be inserted
        assertEquals(appt1, result.get(0));
    }

    @Test
    void testInOrderTraversal() {
        bst.addAppointment(new PatientAppointment("Carol", LocalTime.of(8, 30)));
        bst.addAppointment(new PatientAppointment("Dave", LocalTime.of(9, 45)));
        bst.addAppointment(new PatientAppointment("Eve", LocalTime.of(8, 15)));

        List<PatientAppointment> result = new ArrayList<>();
        collectInOrder(bst.getRoot(), result);

        assertEquals(3, result.size());
        assertEquals("Eve", result.get(0).getPatientName());
        assertEquals("Carol", result.get(1).getPatientName());
        assertEquals("Dave", result.get(2).getPatientName());
    }

    // Helper method to collect in-order traversal into a list
    private void collectInOrder(AppointmentNode node, List<PatientAppointment> list) {
        if (node != null) {
            collectInOrder(node.left, list);
            list.add(node.data);
            collectInOrder(node.right, list);
        }
    }
}
