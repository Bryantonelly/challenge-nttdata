package com.nttdata.challenge.cuentas_movimientos_ms.infrastructure.repository;

import com.nttdata.challenge.cuentas_movimientos_ms.domain.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface JpaReporteRepository extends JpaRepository<Movimiento, Long> {

    @Query(value = "SELECT m.fecha, u.nombre, c.numero_cuenta numeroCuenta, c.tipo_cuenta tipoCuenta, m.saldo_inicial saldoInicial, u.estado, m.valor movimiento, m.saldo_disponible saldoDisponible \n" +
            "FROM movimientos m \n" +
            "INNER JOIN cuentas c on m.cuenta_id = c.cuenta_id \n" +
            "INNER JOIN clientes u on u.cliente_id = c.cliente_id \n" +
            "WHERE m.fecha \n" +
            "BETWEEN :fechaInicio AND :fechaFinal", nativeQuery = true)
    List<Object[]> reporte(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFinal") LocalDate fechaFinal);

}
