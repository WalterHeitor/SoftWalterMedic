package br.com.softwalter.med.api.doumain.usecase.medico.maper.impl;

import br.com.softwalter.med.api.doumain.entities.Endereco;
import br.com.softwalter.med.api.doumain.entities.Especialidade;
import br.com.softwalter.med.api.doumain.entities.Medico;
import br.com.softwalter.med.api.doumain.usecase.medico.CriarMedicoUseCase;
import br.com.softwalter.med.api.doumain.usecase.medico.ListarMedicoUseCase;
import br.com.softwalter.med.api.doumain.usecase.medico.maper.MedicoMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MedicoMapperImpl implements MedicoMapper {
    @Override
    public Medico inputToMedico(CriarMedicoUseCase.InputValues input) {
        return Medico.builder()
                .nome(input.getNome())
                .email(input.getEmail())
                .crm(input.getCrm())
                .especialidade(Especialidade.getEspecialidadePorId(input.getEspecialidade()))
                .endereco(enderecoRequestToEndereco(input.getEndereco()))
                .build();
    }

    private Endereco enderecoRequestToEndereco(CriarMedicoUseCase.Endereco endereco) {
        return Endereco.builder()
                .logradouro(endereco.getLogradouro())
                .bairro(endereco.getBairro())
                .cep(endereco.getCep())
                .complemento(endereco.getComplemento())
                .cidade(endereco.getCidade())
                .uf(endereco.getUf())
                .numero(endereco.getNumero())
                .build();
    }

    @Override
    public CriarMedicoUseCase.OutputValues medicoToOutputValues(Medico medico) {
        return CriarMedicoUseCase.OutputValues.builder()
                .medicoId(medico.getMedicoId())
                .nome(medico.getNome())
                .email(medico.getEmail())
                .crm(medico.getCrm())
                .especialidade(medico.getEspecialidade().descricao)
                .endereco(enderecoToOutputValues(medico.getEndereco()))
                .build();
    }

    @Override
    public ListarMedicoUseCase.OutputValues medicoListToOutputValues(List<Medico> medicos) {
        return ListarMedicoUseCase.OutputValues.builder()
                .medicos(medicosToOutputValues(medicos))
                .build();
    }

    private List<ListarMedicoUseCase.Medico> medicosToOutputValues(List<Medico> medicos) {
        return medicos.stream().map(medico -> ListarMedicoUseCase.Medico.builder()
                .medicoId(medico.getMedicoId())
                .nome(medico.getNome())
                .email(medico.getEmail())
                .crm(medico.getCrm())
                .especialidade(medico.getEspecialidade().descricao)
                .endereco(enderecoToMedicosOutputValues(medico.getEndereco()))
                .build()).collect(Collectors.toList());
    }

    private ListarMedicoUseCase.Endereco enderecoToMedicosOutputValues(Endereco endereco) {
        return ListarMedicoUseCase.Endereco.builder()
                .logradouro(endereco.getLogradouro())
                .bairro(endereco.getBairro())
                .cep(endereco.getCep())
                .complemento(endereco.getComplemento())
                .cidade(endereco.getCidade())
                .uf(endereco.getUf())
                .numero(endereco.getNumero())
                .build();
    }

    private CriarMedicoUseCase.Endereco enderecoToOutputValues(Endereco endereco) {
        return CriarMedicoUseCase.Endereco.builder()
                .logradouro(endereco.getLogradouro())
                .bairro(endereco.getBairro())
                .cep(endereco.getCep())
                .complemento(endereco.getComplemento())
                .cidade(endereco.getCidade())
                .uf(endereco.getUf())
                .numero(endereco.getNumero())
                .build();
    }
}
