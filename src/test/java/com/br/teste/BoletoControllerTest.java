package com.br.teste;

import com.br.teste.controller.BoletoController;
import com.br.teste.dto.BoletoInputDTO;
import com.br.teste.service.BoletoService;
import com.br.teste.util.UtilDiverso;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BoletoController.class)
public class BoletoControllerTest {


    @MockBean
    private BoletoService boletoService;

    @Autowired
    private MockMvc mvcMock;


    @Test
    public void createBoleto() throws Exception {

        mvcMock.perform( MockMvcRequestBuilders
                        .post("/calcularJuros")
                        .content(UtilDiverso.asJsonString(new BoletoInputDTO()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.amount").exists());
    }

}
