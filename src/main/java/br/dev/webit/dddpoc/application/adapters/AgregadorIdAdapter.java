package br.dev.webit.dddpoc.application.adapters;

import br.dev.webit.dddpoc.domain.AgregadorId;
import jakarta.json.Json;
import jakarta.json.JsonNumber;
import jakarta.json.bind.adapter.JsonbAdapter;

public class AgregadorIdAdapter implements JsonbAdapter<AgregadorId, JsonNumber> {

    @Override
    public JsonNumber adaptToJson(AgregadorId original) {
        return Json.createValue(Long.parseLong(original.toString()));
    }

    @Override
    public AgregadorId adaptFromJson(JsonNumber adapted) {
        return new AgregadorId(adapted.longValueExact());
    }
}
