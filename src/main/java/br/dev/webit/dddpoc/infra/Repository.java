package br.dev.webit.dddpoc.infra;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public interface Repository<T extends Entity<T, U>, U> {

    @Deprecated
    U nextIdentity();

    Optional<T> find(U id);

    Collection<T> find(Predicate<T> criteria);

    Collection<T> findAll(int offset, int limit);

    void put(T obj);

    void remove(T obj);
}
