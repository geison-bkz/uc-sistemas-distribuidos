package br.com.sistemasdistribuidos.services;

import org.springframework.stereotype.Service;

@Service
public class ImcService {

    public String calc(double peso, double altura){
        double IMC = peso / (altura*altura);
        String result = "Resultado IMC: "+IMC;

        if (IMC < 18.5)
            result += " • Você está abaixo do peso.";
        else if (IMC >= 18.5 && IMC <= 24.9)
            result += " • Você está em um intervalo normal.";
        else if (IMC >= 25 && IMC <= 29.9)
            result += " • Você está sobrepeso.";
        else if (IMC >= 30 && IMC <= 34.9)
            result += " • Você está em obesidade classe I.";
        else if (IMC >= 35 && IMC <= 39.9)
            result += " • Você está em obesidade classe II.";
        else
            result += " • Você está em obesidade classe III.";

        return result;
    }
}
