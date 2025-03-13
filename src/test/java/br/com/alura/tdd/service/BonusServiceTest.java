package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    @Order(1)
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto(){
        BonusService service = new BonusService();

        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus( new Funcionario(
                                                "Wellington",
                                                 LocalDate.now(),
                                                 new BigDecimal("25000")
                                                                            )
                )
        );
    }

    @Test
    @Order(2)
    void bonusDeveriaSerDezPorCentoDoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.
                calcularBonus(
                        new Funcionario(
                                "Wellington",
                                LocalDate.now(),
                                new BigDecimal("9000")
                        )
                );

        assertEquals(new BigDecimal("900.00"), bonus);
    }

    @Test
    @Order(3)
    void bonusDeveriaSerDezPorCentoParaSalarioDeExatamenteDezMilReais(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.
                calcularBonus(
                        new Funcionario(
                                "WellingtonS",
                                LocalDate.now(),
                                new BigDecimal("10000")
                        )
                );

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}