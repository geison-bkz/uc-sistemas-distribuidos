package br.com.sistemasdistribuidos.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calcu")
public class Calculadora {

    @GetMapping("/somar")
    public Integer somar(@RequestParam(name = "n1") int n1, @RequestParam(name = "n2") int n2){
        return n1 + n2;
    }

    @GetMapping("/diminuir")
    public Integer diminuir(@RequestParam(name = "n1") int n1, @RequestParam(name = "n2") int n2){
        return n1 - n2;
    }

    @GetMapping("/multiplicar")
    public Integer multiplicar(@RequestParam(name = "n1") int n1, @RequestParam(name = "n2") int n2){
        return n1 * n2;
    }

    @GetMapping("/dividir")
    public Integer dividir(@RequestParam(name = "n1") int n1, @RequestParam(name = "n2") int n2){
        return n1 / n2;
    }

}
