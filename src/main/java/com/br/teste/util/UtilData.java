package com.br.teste.util;

import com.br.teste.model.Boleto;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class UtilData {

    private static final String DATA_BASE_BACEN = "07/10/1997";
    private static final String PADRAO_FORMATACAO_DATA = "dd/MM/uuuu";

    public Boleto verificarQuantidadeDiasAtrasadoBoleto(Boleto boleto){

        DateTimeFormatter   parser      = DateTimeFormatter.ofPattern(PADRAO_FORMATACAO_DATA);
        LocalDate           dataBase    = LocalDate.parse(DATA_BASE_BACEN, parser);
        LocalDate           dataBoleto  = dataBase.plusDays(obterDataBoleto( boleto.getBar_code()));

        boleto.setPayment_date(Date.from(dataBoleto.atStartOfDay(ZoneId.systemDefault()).toInstant()));

        if(verificarSeBoletoVencido(dataBoleto)){
            boleto.setNumber_days_late(ChronoUnit.DAYS.between(dataBoleto , LocalDate.now()));
        }

        return boleto;
    }

    private Long obterDataBoleto(String codigoBarra){

        String data =  codigoBarra.substring(5,9);

        return new Long(data);
    }

    private Boolean verificarSeBoletoVencido(LocalDate dataBoleto){

        LocalDate dataAtual = LocalDate.now();

        if (dataAtual.isBefore(dataBoleto)) {
            return false;
        }
        return true;
    }
}
