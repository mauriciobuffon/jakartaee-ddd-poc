package br.dev.webit.dddpoc.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class EntidadeId implements br.dev.webit.dddpoc.infra.ValueObject<EntidadeId> {

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "agregador_id"))
    private AgregadorId agregadorId;
    private UUID id;

    protected EntidadeId() {
    }

    EntidadeId(AgregadorId agregadorId, UUID id) {
        this();
        this.agregadorId = agregadorId;
        this.id = id;
    }

    @Override
    public boolean sameValueAs(EntidadeId other) {
        if (this.id != other.id) {
            return false;
        } else if (!Objects.equals(this.agregadorId, other.agregadorId)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.agregadorId);
        hash = 61 * hash + Objects.hashCode(this.id);
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
        return sameValueAs((EntidadeId) obj);
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
