package br.dev.webit.dddpoc.application;

import br.dev.webit.dddpoc.domain.Agregador;
import br.dev.webit.dddpoc.domain.AgregadorId;
import br.dev.webit.dddpoc.domain.AgregadorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

@ApplicationScoped
public class AgregadorJPARepository implements AgregadorRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<Agregador> find(AgregadorId id) {
        return Optional.ofNullable(em.find(Agregador.class, id));
    }

    @Override
    public AgregadorId nextIdentity() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Agregador> find(Predicate<Agregador> criteria) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Agregador> findAll(int offset, int limit) {
        return em.createNamedQuery(FIND_ALL, Agregador.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }

    @Override
    public void put(Agregador obj) {
        em.persist(obj);
    }

    @Override
    public void remove(Agregador obj) {
        em.remove(obj);
    }
}
