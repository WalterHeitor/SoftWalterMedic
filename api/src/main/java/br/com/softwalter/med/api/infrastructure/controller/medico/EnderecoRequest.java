package br.com.softwalter.med.api.infrastructure.controller.medico;

public record EnderecoRequest(
        String logradouro,
        String bairro,
        String cep,
        String cidade,
        String uf,
        String complemento,
        String numero
) {
}
