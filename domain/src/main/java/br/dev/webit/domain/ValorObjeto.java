package br.dev.webit.domain;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ValorObjeto(String dado) implements br.dev.webit.infra.ddd.ValueObject<ValorObjeto> {

    public ValorObjeto {
        dado = Objects.requireNonNull(dado).replaceAll("\\s+", " ").strip();
        if (dado.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public String getDado() {
        return dado;
    }

    @Override
    public boolean sameValueAs(ValorObjeto other) {
        return this.equals(other);
    }
}
