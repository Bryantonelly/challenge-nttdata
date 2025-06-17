package com.nttdata.challenge.cuentas_movimientos_ms.infrastructure.repository;

import com.nttdata.challenge.cuentas_movimientos_ms.domain.model.Cuenta;
import com.nttdata.challenge.cuentas_movimientos_ms.domain.repository.CuentaRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaCuentaRepositoryAdapter implements CuentaRepositoryPort {

    private final JpaCuentaRepository repository;

    public JpaCuentaRepositoryAdapter(JpaCuentaRepository repository){
        this.repository = repository;
    }

    @Override
    public Cuenta guardar(Cuenta cuenta) {
        return repository.save(cuenta);
    }

    @Override
    public Optional<Cuenta> obtenerXId(Long idCuenta) {
        return repository.findById(idCuenta);
    }

    @Override
    public List<Cuenta> listar() {
        return repository.findAll();
    }

    @Override
    public void eliminar(Long idCuenta) {
        repository.deleteById(idCuenta);
    }
}
