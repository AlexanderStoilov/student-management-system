package services;

import entities.enums.TeacherDegree;
import entities.implementations.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.implementations.TeacherRepository;
import services.implementations.TeacherService;

import java.util.Locale;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class TestTeacherService {

    private TeacherService teacherService;
    private TeacherRepository teacherRepository;

    @BeforeEach
    public void setUp() {
        this.teacherRepository = mock(TeacherRepository.class);
        this.teacherService = new TeacherService(teacherRepository);
    }

    @Test
    public void testAddNewTeacherWithValidParamsDoesNotThrowException() {
        String teacherName = "New Student to be added";
        String teacherTitle = "phd";
        assertDoesNotThrow(() -> this.teacherService.addTeacher(new Teacher(teacherName, teacherTitle)));
        System.out.println("Size of repo now = " + this.teacherService.getCortegesNr());
    }

    @Test
    public void testCreateNewStudentWithValidParamsDoesNotThrowException() {
        String teacherName = "New Student to be added";
        String teacherTitle = "phd";
        assertDoesNotThrow(() -> this.teacherService.createTeacher(teacherName, teacherTitle));
        System.out.println("Size of repo now = " + this.teacherService.getCortegesNr());
    }


    @Test
    public void testGetInvalidStudentThrowsNullPointerException() {
        int firstCortegeSeqId = this.teacherService.getCortegesNr();
        assertThrows(NullPointerException.class, () -> teacherService.getTeacherUUID(firstCortegeSeqId));
    }

    @Test
    public void testAddValidUniqueStudentIsAddedToDatabase() {
        TeacherService realTeacherService = new TeacherService();
        String teacherName = "New Student to be added";
        String teacherTitle = "phd";
        //realTeacherService.createTeacher(teacherName, teacherTitle);
        int lastRecordSeqId = realTeacherService.getCortegesNr();
        assertNotEquals(0, lastRecordSeqId);
    }

    @Test
    public void testGetValidUniqueStudentIsExtractedToDatabase() {
        TeacherService realTeacherService = new TeacherService();
        String teacherName = "New Student to be added";
        String teacherTitle = "phd";
        //realTeacherService.createTeacher(teacherName, teacherTitle);
        int lastRecordSeqId = realTeacherService.getCortegesNr();
        String lastRecordUuid = realTeacherService.getTeacherUUID(lastRecordSeqId);
        Optional<Teacher> lastRecordStudent = realTeacherService.get(lastRecordUuid);
        assertNotNull(lastRecordStudent);
    }

    @Test
    public void testGetValidUniqueStudentNameEqualsAddedName() {
        String teacherName = "New Student to be added";
        String teacherTitle = "phd";
        Teacher addedTeacher = this.teacherService.createTeacher(teacherName, teacherTitle);
        assertEquals(addedTeacher.getName(), teacherName);
    }

    @Test
    public void testGetValidUniqueStudentAgeEqualsAddedAge() {
        String teacherName = "New Student to be added";
        String teacherTitle = "phd";
        Teacher addedTeacher = this.teacherService.createTeacher(teacherName, teacherTitle);
        assertEquals(addedTeacher.getDegree(), TeacherDegree.valueOf(teacherTitle.toUpperCase(Locale.ROOT)));
    }

}
