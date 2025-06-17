package com.nttdata.challenge.cuentas_movimientos_ms.infrastructure.client;

import com.nttdata.challenge.cuentas_movimientos_ms.shared.DTO.CuentaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "personas-clientes-ms", url = "personas-clientes-ms")
public interface FeignClienteClient {
    @GetMapping("/api/clientes/{id}")
    CuentaDTO validarCuenta(@PathVariable("id") Long idCliente);
}
