package br.com.softwalter.med.api.infrastructure.controller;

import br.com.softwalter.med.api.infrastructure.controller.medico.MedicoRequest;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class medicoController {

    @PostMapping
    public String cadastrar(@RequestBody MedicoRequest request) {
        System.out.println("Payload de entrada: " + request.toString());
        return request.toString();
    }
}
