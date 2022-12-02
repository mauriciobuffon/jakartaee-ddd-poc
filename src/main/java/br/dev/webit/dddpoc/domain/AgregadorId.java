package br.dev.webit.dddpoc.domain;

import jakarta.persistence.Embeddable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class AgregadorId implements br.dev.webit.dddpoc.infra.ValueObject<AgregadorId> {

    private UUID id;

    protected AgregadorId() {
    }

    public AgregadorId(UUID id) {
        this();
        this.id = id;
    }

    @Override
    public boolean sameValueAs(AgregadorId other) {
        return Objects.equals(this.id, other.id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        return sameValueAs((AgregadorId) obj);
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
