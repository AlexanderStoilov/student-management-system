package repositories.base;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class BaseRepository {

    protected final EntityManagerFactory emf;

    protected BaseRepository() {
        this.emf = Persistence.createEntityManagerFactory("StudentManagementJPA");
    }
}
