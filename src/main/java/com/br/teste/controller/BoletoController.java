package com.br.teste.controller;

import com.br.teste.dto.BoletoInputDTO;
import com.br.teste.dto.BoletoResultDTO;
import com.br.teste.service.BoletoService;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
public class BoletoController {

    private static Logger LOGGER = LoggerFactory.getLogger(BoletoController.class);

    @Autowired
    private BoletoService boletoService;

    @PostMapping(value = "/calcularJuros")
    public ResponseEntity<BoletoResultDTO> calcularJuros (@Valid @RequestBody BoletoInputDTO boletoInputDTO)   {

        try{
            var boletoResultDTO = boletoService.verificarJurosBoleto(boletoInputDTO);
            return new ResponseEntity<BoletoResultDTO>(boletoResultDTO, HttpStatus.CREATED);

        }catch (Exception ex){
            LOGGER.error(ex.getLocalizedMessage());
            ex.printStackTrace();
        }

        return new ResponseEntity<BoletoResultDTO>(new BoletoResultDTO(), HttpStatus.FORBIDDEN);
    }
}
