package br.dev.webit.application.jsonb;

import java.util.UUID;

import br.dev.webit.domain.AgregadorId;
import jakarta.json.bind.adapter.JsonbAdapter;

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
