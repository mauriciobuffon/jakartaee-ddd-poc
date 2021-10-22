package br.com.webit.dddpoc.application;

import br.com.webit.dddpoc.domain.Agregador;
import br.com.webit.dddpoc.domain.AgregadorId;
import br.com.webit.dddpoc.domain.AgregadorRepository;
import br.com.webit.dddpoc.domain.ValorObjeto;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import java.util.Collection;

@Path("agregadores")
@Produces("application/json")
@Stateless
public class Controller {

    @Inject
    private AgregadorRepository repository;

    @GET
    public Collection<Agregador> getAll(@QueryParam("offset") @DefaultValue("0") int offset, @QueryParam("limit") @DefaultValue("50") int limit) {
        return repository.findAll(offset, limit);
    }

    @POST
    public void post() {
        AgregadorId id = repository.nextIdentity();
        Agregador agregador = new Agregador(id);
        repository.put(agregador);
    }

    @Path("{id : \\d+}")
    @GET
    public Agregador get(@PathParam("id") long id) {
        return repository.find(new AgregadorId(id)).orElseThrow(NotFoundException::new);
    }

    @Path("{id : \\d+}")
    @DELETE
    public void delete(@PathParam("id") long id) {
        repository.remove(repository.find(new AgregadorId(id)).orElseThrow(NotFoundException::new));
    }

    @Path("{id : \\d+}/entidades")
    @POST
    public void postEntidade(@PathParam("id") long id, String dado) {
        Agregador agregador = repository.find(new AgregadorId(id)).orElseThrow(NotFoundException::new);
        agregador.addEntidade(new ValorObjeto(dado));
        repository.put(agregador);
    }

    @Path("{id : \\d+}/objetos")
    @POST
    public void postObjeto(@PathParam("id") long id, String dado) {
        Agregador agregador = repository.find(new AgregadorId(id)).orElseThrow(NotFoundException::new);
        agregador.addObjeto(new ValorObjeto(dado));
    }
}
