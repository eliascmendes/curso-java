package br.com.elias.screenmatch.principal;

import br.com.elias.screenmatch.calculo.*;
import br.com.elias.screenmatch.modelos.Episodio;
import br.com.elias.screenmatch.modelos.Filme;
import br.com.elias.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Where is the friends's house", 1987);
        meuFilme.setDuracaoEmMinutos(83);

        meuFilme.exibeFilhaTecnica();
        meuFilme.avalia(10);
        meuFilme.avalia(10);
        meuFilme.avalia(10);
        System.out.println(meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());

        Serie serie = new Serie("Lost", 2000);
        serie.setNome("Documentário Where is my friend's house");
        serie.setAnoDeLancamento(2002);
        serie.setTemporadas(2);
        serie.setEpisodiosPorTemporadas(5);
        serie.setMinutosPorEpisodio(30);
        System.out.println("Duração em minutos para maratonar a série:" + serie.getDuracaoEmMinutos());


        Filme outroFilme = new Filme("Where is the friends's house", 1987);
        outroFilme.setDuracaoEmMinutos(83);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(outroFilme);
        calculadora.inclui(meuFilme);
        System.out.println(calculadora.getTempoTotal());

        Recomendacao recomendacao = new Recomendacao();
        recomendacao.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(2);
        episodio.setSerie(serie);
        episodio.setTotalVisualizacoes(300);

        recomendacao.filtra(episodio);
        Filme filmeElias = new Filme("Driver my car", 2023);
        filmeElias.setDuracaoEmMinutos(188);
        filmeElias.avalia(9.5);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeElias);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);
        System.out.println("Tamanho da lista de filmes:" + listaDeFilmes.size());

        System.out.println("Primeiro filme " + listaDeFilmes.get(0).getNome());
        System.out.println("toString" + listaDeFilmes.get(0).toString());



    }
}
