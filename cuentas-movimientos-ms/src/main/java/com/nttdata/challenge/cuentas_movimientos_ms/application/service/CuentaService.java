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

    public Optional<Cuenta> obtenerCuenta(String CuentaId) {
        return repository.obtenerXId(CuentaId);
    }

    public List<Cuenta> listarCuentas() {
        return repository.listar();
    }

    public void eliminarCuenta(String CuentaId) {
        repository.eliminar(CuentaId);
    }

    public Cuenta actualizarCuenta(Cuenta Cuenta) {
        return repository.obtenerXId(Cuenta.getIdCuenta()).map(
                CuentaEncontrado -> {
                    CuentaEncontrado.setNumeroCuenta(Cuenta.getNumeroCuenta());
                    CuentaEncontrado.setTipoCuenta(Cuenta.getTipoCuenta());
                    CuentaEncontrado.setSaldoInicial(Cuenta.getSaldoInicial());
                    CuentaEncontrado.setEstado(Cuenta.getEstado());
                    return repository.guardar(CuentaEncontrado);
                } ).orElseThrow(()-> new RuntimeException("Cuenta no encontrada"));

    }

}
