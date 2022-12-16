package br.dev.webit.infra.ddd;

import java.io.Serializable;

public interface ValueObject<T> extends Serializable {

    boolean sameValueAs(T other);
}
