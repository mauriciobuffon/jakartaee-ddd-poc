package br.dev.webit.domain;

import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Embeddable;

@Embeddable
public record AgregadorId(UUID id) implements br.dev.webit.infra.ddd.ValueObject<AgregadorId> {

    public AgregadorId {
        Objects.requireNonNull(id);
    }

    @Override
    public boolean sameValueAs(AgregadorId other) {
        return this.equals(other);
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
