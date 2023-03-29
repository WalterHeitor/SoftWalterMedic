package br.com.softwalter.med.api.infrastructure.controller.mapper.impl;

import br.com.softwalter.med.api.doumain.usecase.medico.CriarMedicoUseCase;
import br.com.softwalter.med.api.doumain.usecase.medico.ListarMedicoUseCase;
import br.com.softwalter.med.api.infrastructure.controller.mapper.MedicoMapperController;
import br.com.softwalter.med.api.infrastructure.controller.medico.EnderecoRequest;
import br.com.softwalter.med.api.infrastructure.controller.medico.EnderecoResponse;
import br.com.softwalter.med.api.infrastructure.controller.medico.MedicoRequest;
import br.com.softwalter.med.api.infrastructure.controller.medico.MedicoResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MedicoMapperControllerImpl implements MedicoMapperController {
    @Override
    public CriarMedicoUseCase.InputValues requestToInputValues(MedicoRequest request) {
        return CriarMedicoUseCase.InputValues.builder()
                .nome(request.nome())
                .email(request.email())
                .crm(request.crm())
                .especialidade(request.especialidade())
                .endereco(enderecoRequestToInputvalues(request.endereco()))
                .build();
    }

    @Override
    public MedicoResponse outputValuesToResponse(CriarMedicoUseCase.OutputValues outputValues) {
        return new MedicoResponse(
                outputValues.getMedicoId(),
                outputValues.getNome(),
                outputValues.getEmail(),
                outputValues.getCrm(),
                outputValues.getEspecialidade(),
                outputValuesToEnderecoResponse(outputValues.getEndereco())
        );
    }

    @Override
    public List<MedicoResponse> outputValuesToListResponse(ListarMedicoUseCase.OutputValues outputValues) {
        return outputValues.getMedicos().stream().map(medico -> new MedicoResponse(
                medico.getMedicoId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getEspecialidade(),
                outputValuesToListResponseEndereco(medico.getEndereco())
        )).collect(Collectors.toList());
    }

    private EnderecoResponse outputValuesToListResponseEndereco(ListarMedicoUseCase.Endereco endereco) {
        return new EnderecoResponse(
                endereco.getLogradouro(),
                endereco.getBairro(),
                endereco.getCep(),
                endereco.getCidade(),
                endereco.getUf(),
                endereco.getComplemento(),
                endereco.getNumero()
        );
    }

    private EnderecoResponse outputValuesToEnderecoResponse(CriarMedicoUseCase.Endereco endereco) {
        return new EnderecoResponse(
                endereco.getLogradouro(),
                endereco.getBairro(),
                endereco.getCep(),
                endereco.getCidade(),
                endereco.getUf(),
                endereco.getComplemento(),
                endereco.getNumero()
        );
    }

    private CriarMedicoUseCase.Endereco enderecoRequestToInputvalues(EnderecoRequest endereco) {

        return CriarMedicoUseCase.Endereco.builder()
                .logradouro(endereco.logradouro())
                .bairro(endereco.bairro())
                .cep(endereco.cep())
                .complemento(endereco.complemento())
                .cidade(endereco.cidade())
                .uf(endereco.uf())
                .numero(endereco.numero())
                .build();
    }
}
