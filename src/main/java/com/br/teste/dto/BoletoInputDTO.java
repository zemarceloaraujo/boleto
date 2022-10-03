package com.br.teste.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class BoletoInputDTO implements Serializable {

    private static final long serialVersionUID = 1l;

    private String bar_code;

    private Date payment_date;
}
