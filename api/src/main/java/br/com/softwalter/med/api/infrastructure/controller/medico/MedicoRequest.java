package br.com.softwalter.med.api.infrastructure.controller.medico;

import jakarta.annotation.Nullable;

public record MedicoRequest(
        String nome,
        String email,
        String crm,
        int especialidade,
        EnderecoRequest endereco
) {
}
