import SMS.GraduateStudent;
import SMS.IllegalGpaException;
import SMS.Major;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GraduateStudentTest {
    private GraduateStudent graduateStudent;

    @BeforeEach
    public void setUp() {
        graduateStudent = new GraduateStudent(1, "Artem", "Oganesyan", 43, Major.ART);
    }

    @Test
    public void testSetGPA_Valid() {
        assertDoesNotThrow(() -> graduateStudent.setGPA(3.5));
        assertEquals(3.5, graduateStudent.getGPA());
    }

    @Test
    public void testSetGPA_Invalid_Low() {
        Exception exception = assertThrows(IllegalGpaException.class, ()-> graduateStudent.setGPA(-1.0));
        assertEquals("GPA must be between 0.0 and 4.0", exception.getMessage());
    }

    @Test
    public void testSetGPA_Invalid_High() {
        Exception exception = assertThrows(IllegalGpaException.class, ()-> graduateStudent.setGPA(5.0));
        assertEquals("GPA must be between 0.0 and 4.0", exception.getMessage());
    }
}
