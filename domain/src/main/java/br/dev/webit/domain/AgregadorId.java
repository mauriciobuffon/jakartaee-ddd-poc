package br.dev.webit.domain;

import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Embeddable;

@Embeddable
public class AgregadorId implements br.dev.webit.infra.ddd.ValueObject<AgregadorId> {

    private UUID id;

    protected AgregadorId() {
    }

    public AgregadorId(UUID id) {
        this();
        this.id = Objects.requireNonNull(id);
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
