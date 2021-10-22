package br.com.webit.dddpoc.application.adapters;

import br.com.webit.dddpoc.domain.EntidadeId;
import jakarta.json.Json;
import jakarta.json.JsonNumber;
import jakarta.json.bind.adapter.JsonbAdapter;

public class EntidadeIdAdapter implements JsonbAdapter<EntidadeId, JsonNumber> {

    @Override
    public JsonNumber adaptToJson(EntidadeId original) {
        return Json.createValue(Long.parseLong(original.toString()));
    }

    @Override
    public EntidadeId adaptFromJson(JsonNumber adapted) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
