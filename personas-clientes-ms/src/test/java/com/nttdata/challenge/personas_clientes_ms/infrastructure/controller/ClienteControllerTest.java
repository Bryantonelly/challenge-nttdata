package com.nttdata.challenge.personas_clientes_ms.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.challenge.personas_clientes_ms.shared.DTO.ClienteDTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void exitoCrearCliente() throws Exception {
        ClienteDTO clienteDTO = new ClienteDTO();
//        clienteDTO.setClienteId(1L);
        clienteDTO.setNombre("Bryan");
        clienteDTO.setContrasenia("1234");
        clienteDTO.setGenero("M");
        clienteDTO.setEdad(30);
        clienteDTO.setIdentificacion("12345678");
        clienteDTO.setDireccion("Av. Siempre Viva 123");
        clienteDTO.setTelefono("987654321");
        clienteDTO.setEstado(true);

        mockMvc.perform(post("/api/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(clienteDTO)))
                .andExpect(status().isOk());
    }
}
