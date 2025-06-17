package com.nttdata.challenge.cuentas_movimientos_ms.infrastructure.repository;

import com.nttdata.challenge.cuentas_movimientos_ms.domain.model.Movimiento;
import org.springframework.stereotype.Repository;
import com.nttdata.challenge.Movimientos_movimientos_ms.domain.repository.MovimientoRepositoryPort;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaMovimientoRepositoryAdapter implements MovimientoRepositoryPort {

    private final JpaMovimientoRepository repository;

    public JpaMovimientoRepositoryAdapter(JpaMovimientoRepository repository){
        this.repository = repository;
    }

    @Override
    public Movimiento guardar(Movimiento movimiento) {
        return repository.save(movimiento);
    }

    @Override
    public Optional<Movimiento> obtenerXId(Long idMovimiento) {
        return repository.findById(idMovimiento);
    }

    @Override
    public List<Movimiento> listar() {
        return repository.findAll();
    }

    @Override
    public void eliminar(Long idMovimiento) {
        repository.deleteById(idMovimiento);
    }
}
