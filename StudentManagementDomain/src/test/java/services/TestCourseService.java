package services;

import entities.implementations.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.implementations.CourseRepository;
import services.implementations.CourseService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class TestCourseService {

    private CourseService courseService;
    private CourseRepository courseRepository;

    @BeforeEach
    public void setUp() {
        this.courseRepository = mock(CourseRepository.class);
        this.courseService = new CourseService(courseRepository);
    }

    @Test
    public void testAddNewCourseWithValidParamsDoesNotThrowException() {
        String courseName = "New Course to be added";
        double courseHours = 130D;
        assertDoesNotThrow(() -> this.courseService.addCourse(new Course(courseName, courseHours)));
        System.out.println("Size of repo now = " + this.courseService.getCortegesNr());
    }

    @Test
    public void testCreateNewCourseWithValidParamsDoesNotThrowException() {
        String courseName = "New Course to be added";
        double courseHours = 130D;
        assertDoesNotThrow(() -> this.courseService.createCourse(courseName, courseHours));
        System.out.println("Size of repo now = " + this.courseService.getCortegesNr());
    }

    @Test
    public void testGetInvalidCourseThrowsNullPointerException() {
        int firstCortegeSeqId = this.courseService.getCortegesNr();
        assertThrows(NullPointerException.class, () -> courseService.getCourseUUID(firstCortegeSeqId));
    }

    @Test
    public void testAddValidUniqueCourseIsAddedToDatabase() {
        CourseService realCourseService = new CourseService();
        String courseName = "Indian";
        double courseTotalHours = 130.0;
        //realCourseService.createCourse(courseName, courseTotalHours);
        int lastRecordSeqId = realCourseService.getCortegesNr();
        assertNotEquals(0, lastRecordSeqId);
    }

    @Test
    public void testGetValidUniqueCourseIsExtractedToDatabase() {
        CourseService realCourseService = new CourseService();
        String courseName = "Indian";
        double courseTotalHours = 130.0;
        //realCourseService.createCourse(courseName, courseTotalHours);
        int lastRecordSeqId = realCourseService.getCortegesNr();
        String lastRecordUuid = realCourseService.getCourseUUID(lastRecordSeqId);
        Optional<Course> lastRecordCourse = realCourseService.get(lastRecordUuid);
        assertNotNull(lastRecordCourse);
    }

    @Test
    public void testGetValidUniqueCourseNameEqualsAddedName() {
        String courseName = "Quebecois";
        double courseTotalHours = 115.0;
        Course addedCourse = this.courseService.createCourse(courseName, courseTotalHours);
        assertEquals(addedCourse.getName(), courseName);
    }

    @Test
    public void testGetValidUniqueCourseTotalHoursEqualsAddedTotalHours() {
        String courseName = "Quebecois";
        double courseTotalHours = 115.0;
        Course addedCourse = this.courseService.createCourse(courseName, courseTotalHours);
        assertEquals(addedCourse.getTotalHours(), courseTotalHours);
    }

}
