package repositories.implementations;

import entities.implementations.Course;
import entities.implementations.Grade;
import entities.implementations.Student;
import jakarta.persistence.EntityManager;
import repositories.base.BaseRepository;

import java.util.List;

public class GradeRepository extends BaseRepository {
    private final EntityManager em;

    public GradeRepository() {
        super();
        this.em = emf.createEntityManager();
    }

    public void save(Grade entity) {
        this.em.getTransaction().begin();
        this.em.merge(entity);
        this.em.getTransaction().commit();
    }

    public void remove(Grade entity) {
        this.em.getTransaction().begin();
        this.em.remove(entity);
        this.em.getTransaction().commit();
    }

    public List<Grade> getAll() {
        return this.em.createQuery("SELECT s FROM Grade s", Grade.class).getResultList();
    }
}
