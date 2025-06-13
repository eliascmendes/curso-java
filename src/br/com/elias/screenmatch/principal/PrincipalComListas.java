package br.com.elias.screenmatch.principal;

import br.com.elias.screenmatch.modelos.Filme;
import br.com.elias.screenmatch.modelos.Serie;
import br.com.elias.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComListas {
    public static void main(String[] args) {
    Filme meuFilme = new Filme("Where is the friends's house", 1987);
    meuFilme.avalia(10);
    Filme outroFilme = new Filme("Driver my car", 2023);
    outroFilme.avalia(10);
    Filme filmeElias = new Filme("Life and nothing more", 1987);
 filmeElias.avalia(10);
    Serie serie = new Serie("Lost", 2000);



    ArrayList<Titulo> lista = new ArrayList<>();
    lista.add(filmeElias);
    lista.add(meuFilme);
    lista.add(outroFilme);
    lista.add(serie);


    for (Titulo item : lista) {
        System.out.println(item.getNome());
        if (item instanceof Filme filme && filme.getClassicacao() > 2) {
            System.out.println(filme.getClassicacao());

        }
    }


    ArrayList<String> buscaPorArtista = new ArrayList<>();
    buscaPorArtista.add("Ana De Armas");
    buscaPorArtista.add("Elias");
    buscaPorArtista.add("MijorButMajor");
    Collections.sort(buscaPorArtista);
    System.out.println(buscaPorArtista);
    Collections.sort(lista);
    System.out.println(lista);


    lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
    System.out.println("Ordenando por ano");
    System.out.println(lista);
    }
}
