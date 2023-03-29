package br.com.softwalter.med.api.infrastructure.controller.medico;

public record EnderecoResponse(
        String logradouro,
        String bairro,
        String cep,
        String cidade,
        String uf,
        String complemento,
        String numero
) {
    public EnderecoResponse(String logradouro, String bairro, String cep, String cidade, String uf, String complemento, String numero) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.complemento = complemento;
        this.numero = numero;
    }
}
