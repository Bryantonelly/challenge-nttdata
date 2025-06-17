package com.nttdata.challenge.cuentas_movimientos_ms.application.service;

import com.nttdata.challenge.cuentas_movimientos_ms.domain.model.Cuenta;
import com.nttdata.challenge.cuentas_movimientos_ms.infrastructure.repository.JpaCuentaRepositoryAdapter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {

    private JpaCuentaRepositoryAdapter repository;

    public CuentaService(JpaCuentaRepositoryAdapter repository){
        this.repository = repository;
    }

    public Cuenta crearCuenta(Cuenta Cuenta) {
        return repository.guardar(Cuenta);
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
                } ).orElseThrow(()-> new RuntimeException("Cuenta no encontrada"));

    }

}
