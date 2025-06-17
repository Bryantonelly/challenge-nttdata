package com.nttdata.challenge.personas_clientes_ms.domain.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class clienteTest {

    @Test
    void exitoCliente() throws JsonProcessingException {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1L);
        cliente.setNombre("BRYAN");
        cliente.setGenero("MASCULINO");
        cliente.setEdad(12);
        cliente.setIdentificacion("71425367");
        cliente.setDireccion("DIRECCION");
        cliente.setTelefono("934567823");
        cliente.setContrasenia("1234");
        cliente.setEstado(Boolean.TRUE);

        assertEquals(1L, cliente.getIdCliente());
        assertEquals("BRYAN", cliente.getNombre());
        assertEquals("MASCULINO", cliente.getGenero());
        assertEquals(12, cliente.getEdad());
        assertEquals("71425367", cliente.getIdentificacion());
        assertEquals("DIRECCION", cliente.getDireccion());
        assertEquals("934567823", cliente.getTelefono());
        assertEquals("1234", cliente.getContrasenia());
        assertTrue(cliente.getEstado());
    }
}
