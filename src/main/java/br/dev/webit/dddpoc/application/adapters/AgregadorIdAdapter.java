package br.dev.webit.dddpoc.application.adapters;

import br.dev.webit.dddpoc.domain.AgregadorId;
import jakarta.json.bind.adapter.JsonbAdapter;
import java.util.UUID;

public class AgregadorIdAdapter implements JsonbAdapter<AgregadorId, UUID> {

    @Override
    public UUID adaptToJson(AgregadorId original) {
        return UUID.fromString(original.toString());
    }

    @Override
    public AgregadorId adaptFromJson(UUID adapted) {
        return new AgregadorId(adapted);
    }
}
