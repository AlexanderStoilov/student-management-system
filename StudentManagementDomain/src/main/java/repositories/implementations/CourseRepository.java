package repositories.implementations;

import entities.implementations.Course;
import entities.implementations.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import repositories.base.BaseRepository;
import repositories.base.CoursesRepositoryInterface;

import java.util.List;
import java.util.Optional;

public class CourseRepository extends BaseRepository implements CoursesRepositoryInterface {

    private final EntityManager em;

    public CourseRepository() {
        super();
        this.em = emf.createEntityManager();
    }

    @Override
    public boolean exists(String id) {
        return get(id).isPresent();
    }

    @Override
    public List<Course> getAll() {
        return this.em.createQuery("SELECT s FROM Course s", Course.class).getResultList();
    }

    @Override
    public Optional<Course> get(String id) {
        TypedQuery<Course> query = this.em.createQuery("SELECT c FROM Course c WHERE id = ?1", Course.class);
        return Optional.ofNullable(query.setParameter(1, id).getSingleResult());
    }

    @Override
    public void save(Course entity) {
        this.em.getTransaction().begin();
        this.em.merge(entity);
        this.em.getTransaction().commit();
    }

    public void remove(Course entity) {
        this.em.getTransaction().begin();
        this.em.remove(entity);
        this.em.getTransaction().commit();
    }

    @Override
    public Course validate(String courseId) {
        Optional<Course> course = this.get(courseId);
        if (course.isEmpty()) {
            throw new IllegalArgumentException("Course with id=" + courseId + "does not exist.");
        }
        return course.get();
    }

    public Teacher getTeacher(String id) {
        return this.em.find(Course.class, id).getTeacher();
    }

    @Override
    public Optional<String> getUUID(int seqId) {
        TypedQuery<Course> query = this.em.createQuery("SELECT c FROM Course c", Course.class);
        return Optional.ofNullable(query.getResultList().get(seqId - 1).getId());
    }

    public int getCortegesNr(){
        TypedQuery<Course> query = this.em.createQuery("SELECT c FROM Course c", Course.class);
        return query.getResultList().size();
    }

}
