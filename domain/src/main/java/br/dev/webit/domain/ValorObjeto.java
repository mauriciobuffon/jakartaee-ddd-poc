package br.dev.webit.domain;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class ValorObjeto implements br.dev.webit.infra.ddd.ValueObject<ValorObjeto> {

    private String dado;

    protected ValorObjeto() {
    }

    public ValorObjeto(String dado) {
        this();
        dado = Objects.requireNonNull(dado).replaceAll("\\s+", " ").strip();
        if (dado.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.dado = dado;
    }

    public String getDado() {
        return dado;
    }

    @Override
    public boolean sameValueAs(ValorObjeto other) {
        return Objects.equals(this.dado, other.dado);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.dado);
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
        return sameValueAs((ValorObjeto) obj);
    }
}
