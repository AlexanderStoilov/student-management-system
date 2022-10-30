package repositories.implementations;

import entities.implementations.Course;
import entities.implementations.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import repositories.base.BaseRepository;
import repositories.base.TeachersRepositoryInterface;

import java.util.List;
import java.util.Optional;

public class TeacherRepository extends BaseRepository implements TeachersRepositoryInterface {

    private final EntityManager em;

    public TeacherRepository() {
        super();
        this.em = this.emf.createEntityManager();
    }

    @Override
    public boolean exists(String id) {
        return get(id).isPresent();
    }

    @Override
    public List<Teacher> getAll() {
        return this.em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
    }

    @Override
    public Optional<Teacher> get(String id) {
        TypedQuery<Teacher> query = this.em.createQuery("SELECT c FROM Teacher c WHERE id = ?1", Teacher.class);
        return Optional.ofNullable(query.setParameter(1, id).getSingleResult());
    }

    @Override
    public void save(Teacher entity) {
        this.em.getTransaction().begin();
        this.em.merge(entity);
        this.em.getTransaction().commit();
    }

    public void remove(Teacher entity) {
        this.em.getTransaction().begin();
        this.em.remove(entity);
        this.em.getTransaction().commit();
    }

    @Override
    public Teacher validate(String teacherId) {
        Optional<Teacher> teacher = this.get(teacherId);
        if (teacher.isEmpty()) {
            throw new IllegalArgumentException("Teacher with id=" + teacherId + "does not exist.");
        }
        return teacher.get();
    }

    @Override
    public Optional<String> getUUID(int seqId) {
        TypedQuery<Teacher> query = this.em.createQuery("SELECT c FROM Teacher c", Teacher.class);
        return Optional.ofNullable(query.getResultList().get(seqId-1).getId());
    }

    public int getCortegesNr() {
        TypedQuery<Teacher> query = this.em.createQuery("SELECT t FROM Teacher t", Teacher.class);
        return query.getResultList().size();
    }

}
