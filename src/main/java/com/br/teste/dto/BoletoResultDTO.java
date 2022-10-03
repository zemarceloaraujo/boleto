package com.br.teste.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class BoletoResultDTO implements Serializable {

    private static final long serialVersionUID = 1l;

    private Date due_date;

    private Double original_amount;
    private Double amount;
    private Double interest_amount_calculated;
    private Double fine_amount_calcula;
}
