package com.br.teste.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "boleto")

public class Boleto {

    @Id
    private String bar_code;

    private Date payment_date;
    private Date due_date;

    private Double original_amount;
    private Double amount;
    private Double interest_amount_calculated;
    private Double fine_amount_calculated;
    private Long  number_days_late;
}
