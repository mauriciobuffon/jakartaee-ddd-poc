package br.dev.webit.application.jsonb;

import br.dev.webit.domain.EntidadeId;
import jakarta.json.bind.adapter.JsonbAdapter;

public class EntidadeIdAdapter implements JsonbAdapter<EntidadeId, Long> {

    @Override
    public Long adaptToJson(EntidadeId original) {
        return Long.valueOf(original.toString());
    }

    @Override
    public EntidadeId adaptFromJson(Long adapted) {
        throw new UnsupportedOperationException();
    }
}
