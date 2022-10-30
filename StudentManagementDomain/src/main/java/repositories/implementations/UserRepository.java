package repositories.implementations;

import entities.implementations.Teacher;
import entities.implementations.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import repositories.base.BaseRepository;

import java.util.List;
import java.util.Optional;

public class UserRepository extends BaseRepository {
    private final EntityManager em;

    public UserRepository() {
        super();
        this.em = emf.createEntityManager();
    }

    public Optional<User> get(String username) {
        TypedQuery<User> query = this.em.createQuery("SELECT c FROM User c WHERE username = ?1", User.class);
        return Optional.ofNullable(query.setParameter(1, username).getSingleResult());
    }

    public void save(User entity) {
        this.em.getTransaction().begin();
        this.em.merge(entity);
        this.em.getTransaction().commit();
    }

    public List<User> getAll() {
        return this.em.createQuery("SELECT t FROM User t", User.class).getResultList();
    }

    public boolean exists(String id) {
        return get(id).isPresent();
    }
}
