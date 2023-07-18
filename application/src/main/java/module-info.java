module br.dev.webit.jakart.application {
    // webit
    requires br.dev.webit.jakartapoc.domain;

    // jakarta
    requires jakarta.persistence;
    requires jakarta.cdi;
    requires jakarta.transaction;
    requires jakarta.ws.rs;
    requires jakarta.json.bind;

    provides br.dev.webit.domain.AgregadorRepository with br.dev.webit.application.jaxrs.AgregadorJPARepository;
}
