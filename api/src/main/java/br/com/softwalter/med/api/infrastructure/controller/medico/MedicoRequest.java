package br.com.softwalter.med.api.infrastructure.controller.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoRequest(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        int especialidade,

        @NotNull @Valid
        EnderecoRequest endereco
) {
    public MedicoRequest(String nome, String email, String crm, int especialidade, EnderecoRequest endereco) {
        this.nome = nome;
        this.email = email;
        this.crm = crm;
        this.especialidade = especialidade;
        this.endereco = endereco;
    }
}
