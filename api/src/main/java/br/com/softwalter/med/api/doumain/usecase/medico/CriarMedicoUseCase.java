package br.com.softwalter.med.api.doumain.usecase.medico;

import br.com.softwalter.med.api.doumain.entities.Medico;
import br.com.softwalter.med.api.doumain.entities.repositories.MedicoRepository;
import br.com.softwalter.med.api.doumain.usecase.UseCase;
import br.com.softwalter.med.api.doumain.usecase.UseCaseExecutor;
import br.com.softwalter.med.api.doumain.usecase.medico.maper.MedicoMapper;
import br.com.softwalter.med.api.infrastructure.controller.medico.MedicoResponse;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CriarMedicoUseCase extends UseCase<CriarMedicoUseCase.InputValues, CriarMedicoUseCase.OutputValues> {

    @Autowired
    private UseCaseExecutor useCaseExecutor;
    @Autowired
    private  MedicoRepository repository;
    @Autowired
    private  MedicoMapper mapper;

    @Override
    public OutputValues execute(InputValues input) {
        return criarRegistroMedico(input);
    }

    private OutputValues criarRegistroMedico(InputValues input) {
        Medico medico = mapper.inputToMedico(input);
        return mapper.medicoToOutputValues(repository.save(medico));
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Endereco {
        String logradouro;
        String bairro;
        String cep;
        String cidade;
        String uf;
        String complemento;
        String numero;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InputValues implements UseCase.InputValues {

        String nome;
        String email;
        String crm;
        int especialidade;
        Endereco endereco;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OutputValues implements UseCase.OutputValues {

        Long medicoId;
        String nome;
        String email;
        String crm;
        String especialidade;
        Endereco endereco;
    }
}
