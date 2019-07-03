package com.sistemabancario.model;

import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;

/**
 * @author Manoel Campos da Silva Filho
 */
public class MovimentacaoTest {

    private Movimentacao instancia = new Movimentacao();

    @Before
    public void setUp() {

    }

    @Test
    public void instaciarMovimentacaoComoNapConfirmada() {

        assertFalse(instancia.isConfirmada());

    }

    @Test
    public void setValorNegativo() {
        final double invalido = -100;
        try {
            instancia.setValor(invalido);
        } catch (IllegalArgumentException e) {
        }
        final double obtido = instancia.getValor();
        assertNotEquals(invalido, obtido, 0.0001);
    }

    @Test
    public void setValorPositivo() {
        final double invalido = 100;
        instancia.setValor(invalido);
        final double obtido = instancia.getValor();
        assertEquals(invalido, obtido, 0.0001);
    }

    @Test
    public void setTipoCreditoMaiscuculo() {

        final char esperado = 'C';
        instancia.setTipo(esperado);
        final char obtido = instancia.getTipo();
        assertEquals(esperado, obtido);
        instancia.setConfirmada(true);
    }

    @Test
    public void setTipoCreditoMinusculo() {
        final char esperado = 'c';
        //final char esperado = 'C';
        instancia.setTipo(esperado);
        //instancia.setTipo('c');
        final char obtido = instancia.getTipo();
        assertEquals(esperado, obtido);

    }

    @Test
    public void setTipoInvalido() {
        final char invalido = 'X';
        try {
            instancia.setTipo(invalido);
        } catch (IllegalArgumentException e) {
        }
        final char obtido = instancia.getTipo();
        assertNotEquals(invalido, obtido);

    }

    @Test(expected = IllegalArgumentException.class)
    public void setTipoInvalidoExcecao() {
        final char invalido = 'X';
        instancia.setTipo(invalido);
    }

    public static void main(String[] args) {

        MovimentacaoTest classeTeste = new MovimentacaoTest();

        classeTeste.setTipoCreditoMaiscuculo();
        classeTeste.instaciarMovimentacaoComoNapConfirmada();
    }
}
