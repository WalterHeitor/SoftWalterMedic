package br.com.softwalter.med.api.doumain.usecase.medico.maper;

import br.com.softwalter.med.api.doumain.entities.Medico;
import br.com.softwalter.med.api.doumain.usecase.medico.CriarMedicoUseCase;
import br.com.softwalter.med.api.doumain.usecase.medico.ListarMedicoUseCase;

import java.util.List;

public interface MedicoMapper {
    Medico inputToMedico(CriarMedicoUseCase.InputValues input);

    CriarMedicoUseCase.OutputValues medicoToOutputValues(Medico medico);

    ListarMedicoUseCase.OutputValues medicoListToOutputValues(List<Medico> medicos);
}
