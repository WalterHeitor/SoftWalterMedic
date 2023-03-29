package br.com.softwalter.med.api.infrastructure.controller;

import br.com.softwalter.med.api.doumain.usecase.UseCaseExecutor;
import br.com.softwalter.med.api.doumain.usecase.medico.CriarMedicoUseCase;
import br.com.softwalter.med.api.doumain.usecase.medico.ListarMedicoUseCase;
import br.com.softwalter.med.api.infrastructure.controller.mapper.MedicoMapperController;
import br.com.softwalter.med.api.infrastructure.controller.medico.MedicoRequest;
import br.com.softwalter.med.api.infrastructure.controller.medico.MedicoResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.apache.logging.log4j.message.ParameterizedMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.logging.Level;


@AllArgsConstructor
@RestController
@RequestMapping("medicos")
public class MedicoController {

    private UseCaseExecutor useCaseExecutor;
    private CriarMedicoUseCase criarMedico;
    private ListarMedicoUseCase listarMedico;
    private MedicoMapperController mapperController;

    private static final Logger LOGGER = LoggerFactory.getLogger(MedicoController.class);

    @PostMapping
    @Transactional
    public ResponseEntity<MedicoResponse> cadastrar(@RequestBody @Valid MedicoRequest request) {
        LOGGER.info("Payload de entrada: {}", new ParameterizedMessage(request.toString()));

        MedicoResponse medicoResponse = useCaseExecutor.execute(
                criarMedico,
                mapperController.requestToInputValues(request),
                outputValues -> mapperController.outputValuesToResponse(outputValues));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(medicoResponse.medicoId()).toUri();
        LOGGER.info("Payload de saida: {}", medicoResponse);

        return ResponseEntity.created(location).body(medicoResponse);
    }

    @GetMapping
    public ResponseEntity<List<MedicoResponse>> listar() {
        LOGGER.info("Metodo list não temos payload de entrada: ");

        List<MedicoResponse> medicosResponse = useCaseExecutor.execute(
                listarMedico,
                new ListarMedicoUseCase.EmptyInputValues(),
                outputValues -> mapperController.outputValuesToListResponse(outputValues));

        LOGGER.info("Payload de saida: {}",  new ParameterizedMessage(medicosResponse.toString())) ;

        return ResponseEntity.ok(medicosResponse);
    }
}
