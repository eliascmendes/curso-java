package br.com.elias.screenmatch.principal;
import br.com.elias.screenmatch.modelos.Titulo;
import br.com.elias.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String [] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o nome do filme para a busca: ");

        var busca = leitura.nextLine();

        String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=65a969fa";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        String json = response.body();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

        TituloOmdb tituloOmdb = gson.fromJson(response.body(), TituloOmdb.class);
        System.out.println(tituloOmdb);
        try {
        Titulo meutitulo = new Titulo(tituloOmdb);
        System.out.println("titulo ja convertido");
        System.out.println(meutitulo);

        } catch (NumberFormatException e) {
            System.out.println("Aconteceu um erro: ");
            System.out.println(e.getMessage());
        }

        System.out.println("O programa finalizou corretamente.");
    }
}
