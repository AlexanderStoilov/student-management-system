package repositories.base;

import java.util.List;
import java.util.Optional;

public interface BaseRepositoryInterface<T> {

    boolean exists(String id);

    List<T> getAll();

    Optional<T> get(String id);

    void save(T entity);

    T validate(String id);

    Optional<String> getUUID(int seqId);

}
