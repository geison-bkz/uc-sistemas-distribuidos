package br.com.sistemasdistribuidos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemasdistribuidos.services.ImcService;

@RestController
@RequestMapping("/")
public class ImcResource {

    @Autowired
    ImcService service;

    @GetMapping("imc")
    public String index(@RequestParam(name = "peso") double peso, @RequestParam(name = "altura") double altura){
        return service.calc(peso, altura);
    }
}
