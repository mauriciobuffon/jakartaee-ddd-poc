package br.com.webit.dddpoc.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
public class Agregador implements br.com.webit.dddpoc.infra.Entity<Agregador, AgregadorId> {

    @EmbeddedId
    private AgregadorId agregadorId;
    @OneToMany(mappedBy = "agregador", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Entidade> entidades;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<ValorObjeto> objetos;
    @Version
    private LocalDateTime version;

    protected Agregador() {
    }

    public Agregador(AgregadorId id) {
        this();
        this.agregadorId = id;
        this.entidades = new HashSet<>();
        this.objetos = new HashSet<>();
    }

    public Entidade addEntidade(ValorObjeto objeto) {
        Entidade entidade = new Entidade(Math.abs(UUID.randomUUID().getMostSignificantBits()), this, objeto);
        if (!this.entidades.add(entidade)) {
            throw new IllegalStateException();
        }
        return entidade;
    }

    public void addObjeto(ValorObjeto objeto) {
        if (!this.objetos.add(objeto)) {
            throw new IllegalStateException();
        }
    }

    @Override
    public AgregadorId getId() {
        return agregadorId;
    }

    public Set<Entidade> getEntidades() {
        return entidades;
    }

    public Set<ValorObjeto> getObjetos() {
        return objetos;
    }

    @Override
    public boolean sameIdentityAs(Agregador other) {
        return Objects.equals(this.agregadorId, other.agregadorId);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.agregadorId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return sameIdentityAs((Agregador) obj);
    }
}
