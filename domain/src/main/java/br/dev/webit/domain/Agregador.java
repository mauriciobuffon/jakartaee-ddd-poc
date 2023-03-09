package br.dev.webit.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;

@Entity
@IdClass(AgregadorId.class)
public class Agregador implements br.dev.webit.infra.ddd.Entity<Agregador, AgregadorId> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(mappedBy = "agregador", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Entidade> entidades;
    @ElementCollection(fetch = FetchType.EAGER)
    @AttributeOverride(name = "dado", column = @Column(nullable = false))
    private Set<ValorObjeto> objetos;
    @Version
    private LocalDateTime version;

    public Agregador() {
        this.entidades = new HashSet<>();
        this.objetos = new HashSet<>();
    }

    Agregador(UUID id) {
        this();
        this.id = id;
    }

    public Entidade addEntidade(ValorObjeto objeto) {
        Entidade entidade = new Entidade(UUID.randomUUID().getLeastSignificantBits() & 0x7fff_ffff_ffff_ffffL, this, objeto);
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
        return new AgregadorId(id);
    }

    public Set<Entidade> getEntidades() {
        return entidades;
    }

    public Set<ValorObjeto> getObjetos() {
        return objetos;
    }

    @Override
    public boolean sameIdentityAs(Agregador other) {
        return Objects.equals(this.id, other.id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
