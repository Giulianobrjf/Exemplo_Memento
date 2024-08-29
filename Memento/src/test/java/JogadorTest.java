import org.example.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class JogadorTest {

    @Test
    public void deveArmazenarEstados() {
        Jogador jogador = new Jogador();
        jogador.setEstado(new JogadorEstadoTransferido());
        jogador.setEstado(new JogadorEstadoLesionado());
        assertEquals(2, jogador.getHistoricoEstados().size());
    }

    @Test
    public void deveRetornarEstadoInicial() {
        Jogador jogador = new Jogador();
        jogador.setEstado(new JogadorEstadoTransferido());
        jogador.setEstado(new JogadorEstadoLesionado());
        jogador.restauraEstado(0);
        assertEquals("Transferido", jogador.getEstado().getNomeEstado());
    }

    @Test
    public void deveRetornarEstadoAnterior() {
        Jogador jogador = new Jogador();
        jogador.setEstado(new JogadorEstadoTransferido());
        jogador.setEstado(new JogadorEstadoLesionado());
        jogador.setEstado(new JogadorEstadoSuspenso());
        jogador.setEstado(new JogadorEstadoEmprestado());
        jogador.restauraEstado(2);
        assertEquals("Suspenso", jogador.getEstado().getNomeEstado());
    }

    @Test
    public void deveRetornarExcecaoIndiceInvalido() {
        try {
            Jogador jogador = new Jogador();
            jogador.restauraEstado(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }
}
