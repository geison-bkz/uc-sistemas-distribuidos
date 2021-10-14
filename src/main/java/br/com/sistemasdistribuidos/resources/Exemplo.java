package br.com.sistemasdistribuidos.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exemplo")
public class Exemplo {

    @GetMapping("/index")
    public String index(){
        return "Seja Bem Vindo!";
    }

    @GetMapping("/url")
    public String url(@RequestParam(name = "nome") String nome, @RequestParam(name = "idade") int idade){
        String result =  "Olá, " + nome + "!";

        if (idade >= 18)
            result += "\nVocê é de maior.";
        else
            result += "\nVocê é de menor.";

        return result;
    }

    @GetMapping("/dinamico/{nome}")
    public String dinamico(@PathVariable(name = "nome") String nome){
        return "Olá, " + nome + "!";

    }

}
