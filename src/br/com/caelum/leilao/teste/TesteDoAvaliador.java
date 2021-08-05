package br.com.caelum.leilao.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class TesteDoAvaliador {

    @Test
    public void deveEntenderLancesEmOrdemCrescente() {
        Usuario joao = new Usuario("Joao");
        Usuario maria = new Usuario("Maria");
        Usuario jose = new Usuario("Jose");

        Leilao leilao = new Leilao("Playstation");

        leilao.propoe(new Lance(joao, 200.0));
        leilao.propoe(new Lance(maria, 300.0));
        leilao.propoe(new Lance(jose, 400.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        double maiorEsperado = 400;
        double menorEsperado = 200;

        System.out.println(leiloeiro.getMaiorDeTodos() == maiorEsperado);
        System.out.println(leiloeiro.getMenorDeTotos() == menorEsperado);

        Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorDeTodos(), 0.00001);
        Assert.assertEquals(menorEsperado, leiloeiro.getMenorDeTotos(), 0.00001);
    }
}
