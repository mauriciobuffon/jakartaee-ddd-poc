package br.dev.webit.infra.ddd;

import java.io.Serializable;

public interface Entity<T, U> extends Serializable {

    U getId();

    boolean sameIdentityAs(T other);
}
