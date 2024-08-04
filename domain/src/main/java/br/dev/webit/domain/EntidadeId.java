package br.dev.webit.domain;

import java.util.Objects;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public record EntidadeId(
        @Embedded @AttributeOverride(name = "id", column = @Column(name = "agregador_id")) AgregadorId agregadorId,
        long id) implements br.dev.webit.infra.ddd.ValueObject<EntidadeId> {

    public EntidadeId {
        Objects.requireNonNull(agregadorId);
    }

    @Override
    public boolean sameValueAs(EntidadeId other) {
        return this.equals(other);
    }

    @Override
    public String toString() {
        return Long.toString(id);
    }
}
