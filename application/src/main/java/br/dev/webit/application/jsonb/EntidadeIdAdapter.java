package br.dev.webit.application.jsonb;

import br.dev.webit.domain.EntidadeId;
import jakarta.json.bind.adapter.JsonbAdapter;
import java.util.UUID;

public class EntidadeIdAdapter implements JsonbAdapter<EntidadeId, UUID> {

    @Override
    public UUID adaptToJson(EntidadeId original) {
        return UUID.fromString(original.toString());
    }

    @Override
    public EntidadeId adaptFromJson(UUID adapted) {
        throw new UnsupportedOperationException();
    }
}
