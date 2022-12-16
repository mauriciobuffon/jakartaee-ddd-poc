package br.dev.webit.application.jsonb;

import jakarta.json.Json;
import jakarta.json.JsonString;
import jakarta.json.bind.adapter.JsonbAdapter;
import java.util.UUID;

public class UUIDAdapter implements JsonbAdapter<UUID, JsonString> {

    @Override
    public JsonString adaptToJson(UUID original) {
        return Json.createValue(original.toString());
    }

    @Override
    public UUID adaptFromJson(JsonString adapted) {
        return UUID.fromString(adapted.getString());
    }
}
