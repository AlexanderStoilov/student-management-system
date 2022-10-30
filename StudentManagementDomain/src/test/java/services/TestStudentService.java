package services;

import entities.implementations.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.implementations.StudentRepository;
import services.implementations.StudentService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class TestStudentService {

    private StudentService studentService;
    private StudentRepository studentRepository;

    @BeforeEach
    public void setUp() {
        this.studentRepository = mock(StudentRepository.class);
        this.studentService = new StudentService(studentRepository);
    }

    @Test
    public void testCreateNewStudentWithValidParamsDoesNotThrowException() {
        String studentName = "New Student to be added";
        int studentAge = 25;
        assertDoesNotThrow(() -> this.studentService.createStudent(studentName, studentAge));
        System.out.println("Size of repo now = " + this.studentService.getCortegesNr());
    }

    @Test
    public void testAddNewStudentWithValidParamsDoesNotThrowException() {
        String studentName = "New Student to be added";
        int studentAge = 25;
        assertDoesNotThrow(() -> this.studentService.addStudent(new Student(studentName, studentAge)));
        System.out.println("Size of repo now = " + this.studentService.getCortegesNr());
    }


    @Test
    public void testGetInvalidStudentThrowsNullPointerException() {
        int firstCortegeSeqId = this.studentService.getCortegesNr();
        assertThrows(NullPointerException.class, () -> studentService.getStudentUUID(firstCortegeSeqId));
    }

    @Test
    public void testAddValidUniqueStudentIsAddedToDatabase() {
        StudentService realStudentService = new StudentService();
        String studentName = "John Wanders";
        int studentAge = 25;
        //realStudentService.createStudent(studentName, studentAge);
        int lastRecordSeqId = realStudentService.getCortegesNr();
        assertNotEquals(0, lastRecordSeqId);
    }

    @Test
    public void testGetValidUniqueStudentIsExtractedToDatabase() {
        StudentService realStudentService = new StudentService();
        String studentName = "John Wanders";
        int studentAge = 25;
        //realStudentService.createStudent(studentName, studentAge);
        int lastRecordSeqId = realStudentService.getCortegesNr();
        String lastRecordUuid = realStudentService.getStudentUUID(lastRecordSeqId);
        Optional<Student> lastRecordStudent = realStudentService.get(lastRecordUuid);
        assertNotNull(lastRecordStudent);
    }

    @Test
    public void testGetValidUniqueStudentNameEqualsAddedName() {
        String studentName = "John Wanders";
        int studentAge = 25;
        Student addedStudent = this.studentService.createStudent(studentName, studentAge);
        assertEquals(addedStudent.getName(), studentName);
    }

    @Test
    public void testGetValidUniqueStudentAgeEqualsAddedAge() {
        String studentName = "John Wanders";
        int studentAge = 25;
        Student addedStudent = this.studentService.createStudent(studentName, studentAge);
        assertEquals(addedStudent.getAge(), studentAge);
    }

}
