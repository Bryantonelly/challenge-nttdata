package com.nttdata.challenge.cuentas_movimientos_ms.application.service;

import com.nttdata.challenge.cuentas_movimientos_ms.domain.model.Cuenta;
import com.nttdata.challenge.cuentas_movimientos_ms.infrastructure.client.FeignClienteClient;
import com.nttdata.challenge.cuentas_movimientos_ms.infrastructure.repository.JpaCuentaRepositoryAdapter;
import com.nttdata.challenge.cuentas_movimientos_ms.shared.DTO.ClienteDTO;
import com.nttdata.challenge.cuentas_movimientos_ms.shared.exception.CuentaNoEncontradaException;
import com.nttdata.challenge.cuentas_movimientos_ms.shared.exception.UsuarioNoEncontradoException;
import feign.FeignException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {

    private final JpaCuentaRepositoryAdapter repository;
    private FeignClienteClient client;

    public CuentaService(JpaCuentaRepositoryAdapter repository, FeignClienteClient client){
        this.repository = repository;
        this.client = client;
    }

    public Cuenta crearCuenta(Cuenta cuenta) {
        try {
            ClienteDTO clienteEncontrado = client.validarCuenta(cuenta.getIdCliente());
            if(clienteEncontrado == null) {
                throw new UsuarioNoEncontradoException("El cliente no existe");
            }
        }catch(FeignException e){
            throw new UsuarioNoEncontradoException("El cliente no existe");
        }
        return repository.guardar(cuenta);
    }

    public Optional<Cuenta> obtenerCuenta(Long CuentaId) {
        return repository.obtenerXId(CuentaId);
    }

    public List<Cuenta> listarCuentas() {
        return repository.listar();
    }

    public void eliminarCuenta(Long CuentaId) {
        repository.eliminar(CuentaId);
    }

    public Cuenta actualizarCuenta(Cuenta cuenta) {
        return repository.obtenerXId(cuenta.getIdCuenta()).map(
                cuentaEncontrado -> {
                    cuentaEncontrado.setNumeroCuenta(cuenta.getNumeroCuenta());
                    cuentaEncontrado.setTipoCuenta(cuenta.getTipoCuenta());
                    cuentaEncontrado.setSaldoInicial(cuenta.getSaldoInicial());
                    cuentaEncontrado.setEstado(cuenta.getEstado());
                    return repository.guardar(cuentaEncontrado);
                } ).orElseThrow(()-> new CuentaNoEncontradaException("Cuenta no encontrada"));

    }

}
