module br.dev.webit.jakartapoc.domain {
    // webit
    requires transitive br.dev.webit.jakartapoc.utils;
    // jakarta
    requires jakarta.persistence;

    exports br.dev.webit.domain;
}
