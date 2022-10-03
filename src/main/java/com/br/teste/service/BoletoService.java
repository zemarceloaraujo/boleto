package com.br.teste.service;

import com.br.teste.dao.BoletoDAO;
import com.br.teste.dto.BoletoInputDTO;
import com.br.teste.dto.BoletoResultDTO;
import com.br.teste.exception.TesteException;
import com.br.teste.mapper.BoletoMapper;
import com.br.teste.model.Boleto;
import com.br.teste.util.UtilCalculo;
import com.br.teste.util.UtilData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoletoService {

    private static Logger LOGGER = LoggerFactory.getLogger(BoletoService.class);

    @Autowired
    private BoletoDAO boletoDAO;



    public BoletoResultDTO verificarJurosBoleto(BoletoInputDTO boletoInputDTO) throws TesteException{

        try {

            Boleto boleto =  BoletoMapper.INSTANCE.convert(boletoInputDTO);

            boleto = new UtilData().verificarQuantidadeDiasAtrasadoBoleto(boleto);

             if(boleto.getNumber_days_late() > 0){
                boleto.setInterest_amount_calculated(new UtilCalculo().calcularJuros(boleto.getNumber_days_late()));
                boleto =  new UtilCalculo().calcularValorFinalBoleto(boleto);
             }

            return BoletoMapper.INSTANCE.convert(boletoDAO.save(boleto));

        }catch (Exception te){
            LOGGER.error(te.getLocalizedMessage());
            throw  new TesteException(new Long("0001"), "BoletoService.verificarJurosBoleto() -  Erro ao calcular o valor do juros");
        }
    }
}
