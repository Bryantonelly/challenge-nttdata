package com.nttdata.challenge.cuentas_movimientos_ms.infrastructure.repository;

import com.nttdata.challenge.cuentas_movimientos_ms.domain.model.Movimiento;
import com.nttdata.challenge.cuentas_movimientos_ms.shared.DTO.ReporteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface JpaReporteRepository extends JpaRepository<Movimiento, Long> {

    @Query(value = "SELECT m.fecha, u.nombre, c.numeroCuenta, c.tipoCuenta, m.saldoInicial, u.estado, m.valor movimiento, m.saldoDisponible\n" +
            "FROM movimientos m \n" +
            "INNER JOIN cuentas c on m.cuenta_id = c.cuenta_id\n" +
            "INNER JOIN clientes u on u.cliente_id = c.cliente_id\n" +
            "WHERE m.fecha \n" +
            "BETWEEN :fechaInicio AND :fechaFinal", nativeQuery = true)
    List<Object[]> reporte(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFinal") LocalDate fechaFinal);

}
