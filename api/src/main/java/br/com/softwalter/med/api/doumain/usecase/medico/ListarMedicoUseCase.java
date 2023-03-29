package br.com.softwalter.med.api.doumain.usecase.medico;

import br.com.softwalter.med.api.doumain.entities.repositories.MedicoRepository;
import br.com.softwalter.med.api.doumain.usecase.UseCase;
import br.com.softwalter.med.api.doumain.usecase.UseCaseExecutor;
import br.com.softwalter.med.api.doumain.usecase.medico.maper.MedicoMapper;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarMedicoUseCase extends UseCase<ListarMedicoUseCase.EmptyInputValues, ListarMedicoUseCase.OutputValues> {


    private UseCaseExecutor useCaseExecutor;
    private MedicoRepository repository;
    private MedicoMapper mapper;

    public ListarMedicoUseCase(UseCaseExecutor useCaseExecutor, MedicoRepository repository, MedicoMapper mapper) {
        this.useCaseExecutor = useCaseExecutor;
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public OutputValues execute(EmptyInputValues input) {
        var medicos = repository.findAll();
        return mapper.medicoListToOutputValues(medicos);
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
    public static class Medico {

        Long medicoId;
        String nome;
        String email;
        String crm;
        String especialidade;
        Endereco endereco;
    }

    @NoArgsConstructor
    public static class EmptyInputValues implements UseCase.InputValues {
        // Vazio
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OutputValues implements UseCase.OutputValues {

        List<Medico> medicos;
    }
}
