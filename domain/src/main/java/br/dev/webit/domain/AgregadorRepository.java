package br.dev.webit.domain;

import jakarta.persistence.NamedQuery;

@NamedQuery(name = AgregadorRepository.FIND_ALL, query = "SELECT a FROM Agregador a ORDER BY a.agregadorId.id ASC")
public interface AgregadorRepository extends br.dev.webit.infra.ddd.Repository<Agregador, AgregadorId> {

    static final String FIND_ALL = "Agregador.findAll";
}
