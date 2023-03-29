package br.com.softwalter.med.api.infrastructure.controller.medico;

public record MedicoResponse(
        Long medicoId,
        String nome,
        String email,
        String crm,
        String especialidade,
        EnderecoResponse endereco
) {
    public MedicoResponse(Long medicoId, String nome, String email, String crm, String especialidade, EnderecoResponse endereco) {
        this.medicoId = medicoId;
        this.nome = nome;
        this.email = email;
        this.crm = crm;
        this.especialidade = especialidade;
        this.endereco = endereco;
    }
}
