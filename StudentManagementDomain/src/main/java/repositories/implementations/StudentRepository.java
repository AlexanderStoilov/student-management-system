package repositories.implementations;

import entities.implementations.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import repositories.base.BaseRepository;
import repositories.base.StudentsRepositoryInterface;

import java.util.List;
import java.util.Optional;

public class StudentRepository extends BaseRepository implements StudentsRepositoryInterface {

    private final EntityManager em;

    public StudentRepository() {
        super();
        this.em = this.emf.createEntityManager();
    }

    @Override
    public boolean exists(String id) {
        return get(id).isPresent();
    }

    @Override
    public List<Student> getAll() {
        return this.em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    public Optional<Student> get(String id) {
        TypedQuery<Student> query = this.em.createQuery("SELECT c FROM Student c WHERE id = ?1", Student.class);
        return Optional.ofNullable(query.setParameter(1, id).getSingleResult());
    }

    @Override
    public void save(Student entity) {
        this.em.getTransaction().begin();
        this.em.merge(entity);
        this.em.getTransaction().commit();
    }

    public void remove(Student student) {
        String id = student.getId();
        this.em.createQuery("delete from Student s where s.id=:id").setParameter("id", id).executeUpdate();
    }

    @Override
    public Student validate(String studentId) {
        Optional<Student> student = this.get(studentId);
        if (student.isEmpty()) {
            throw new IllegalArgumentException("Student with id=" + studentId + "does not exist.");
        }
        return student.get();
    }

    @Override
    public Optional<String> getUUID(int seqId) {
        TypedQuery<Student> query = this.em.createQuery("SELECT c FROM Student c", Student.class);
        return Optional.ofNullable(query.getResultList().get(seqId - 1).getId());
    }

    public int getCortegesNr() {
        TypedQuery<Student> query = this.em.createQuery("SELECT s FROM Student s", Student.class);
        return query.getResultList().size();
    }

}
