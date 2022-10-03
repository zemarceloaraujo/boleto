package com.br.teste.util;

import com.br.teste.model.Boleto;

import java.text.DecimalFormat;

public class UtilCalculo {

    private static final Double TAXA_MENSAL_JUROS = Double.valueOf(0.033);

    public Double calcularJuros(Long quantidadeDias){
        return quantidadeDias * TAXA_MENSAL_JUROS;
    }

    public Boleto calcularValorFinalBoleto(Boleto boleto){

        Double valor = Double.valueOf(boleto.getBar_code().substring(9,17));
        Double valorJuro =   (valor * 2) / 100;
        Double valorTotal = valor +  valorJuro + boleto.getInterest_amount_calculated();

        boleto.setOriginal_amount(valor);
        boleto.setFine_amount_calculated(valorJuro);
        boleto.setInterest_amount_calculated(valorTotal);

        return boleto;
    }

}
