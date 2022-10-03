package com.br.teste.mapper;



import com.br.teste.dto.BoletoInputDTO;
import com.br.teste.dto.BoletoResultDTO;
import com.br.teste.model.Boleto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BoletoMapper {

    BoletoMapper INSTANCE = Mappers.getMapper(BoletoMapper.class);

    Boleto convert(BoletoInputDTO boletoInputDTO);
    BoletoResultDTO convert(Boleto boleto);

}
