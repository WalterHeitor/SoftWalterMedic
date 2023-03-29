package br.com.softwalter.med.api.infrastructure.controller.mapper;

import br.com.softwalter.med.api.doumain.usecase.medico.CriarMedicoUseCase;
import br.com.softwalter.med.api.doumain.usecase.medico.ListarMedicoUseCase;
import br.com.softwalter.med.api.infrastructure.controller.medico.MedicoRequest;
import br.com.softwalter.med.api.infrastructure.controller.medico.MedicoResponse;

import java.util.List;

public interface MedicoMapperController {
    CriarMedicoUseCase.InputValues requestToInputValues(MedicoRequest request);

    MedicoResponse outputValuesToResponse(CriarMedicoUseCase.OutputValues outputValues);

    List<MedicoResponse> outputValuesToListResponse(ListarMedicoUseCase.OutputValues outputValues);
}
