package br.dev.webit.dddpoc.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Version;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Entidade implements br.dev.webit.dddpoc.infra.Entity<Entidade, EntidadeId> {

    @EmbeddedId
    private EntidadeId entidadeId;
    @ManyToOne
    @MapsId("agregadorId")
    private Agregador agregador;
    @Embedded
    private ValorObjeto objeto;
    @Version
    private LocalDateTime version;

    protected Entidade() {
    }

    Entidade(long id, Agregador agregador, ValorObjeto objeto) {
        this();
        this.entidadeId = new EntidadeId(agregador.getId(), id);
        this.agregador = agregador;
        this.objeto = objeto;
    }

    @Override
    public EntidadeId getId() {
        return entidadeId;
    }

    public ValorObjeto getObjeto() {
        return objeto;
    }

    @Override
    public boolean sameIdentityAs(Entidade other) {
        return Objects.equals(this.entidadeId, other.entidadeId);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.entidadeId);
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
        return sameIdentityAs((Entidade) obj);
    }
}
