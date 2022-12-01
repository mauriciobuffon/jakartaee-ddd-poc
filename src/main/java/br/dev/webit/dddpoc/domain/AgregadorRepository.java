package br.dev.webit.dddpoc.domain;

import br.dev.webit.dddpoc.infra.Repository;
import jakarta.persistence.NamedQuery;

@NamedQuery(name = AgregadorRepository.FIND_ALL, query = "SELECT a FROM Agregador a ORDER BY a.agregadorId.id ASC")
public interface AgregadorRepository extends Repository<Agregador, AgregadorId> {

    static final String FIND_ALL = "Agregador.findAll";
}
