package br.com.elias.screenmatch.principal;
import br.com.elias.screenmatch.excecao.ErroDeConversaoException;
import br.com.elias.screenmatch.modelos.Titulo;
import br.com.elias.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String [] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
       // WHILLEEEEEEEEE
        while (!busca.equalsIgnoreCase("sair")) {
        	
       
        System.out.println("Digite o nome do filme para a busca: ");

        busca = leitura.nextLine();
        if (busca.equalsIgnoreCase("sair")) {
        	break;
        }
        String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=65a969fa";
        System.out.println(endereco);
        try {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        System.out.println(json);
       

        TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);
        System.out.println(tituloOmdb);
     //   try {
        Titulo meutitulo = new Titulo(tituloOmdb);
        System.out.println("titulo ja convertido");
        System.out.println(meutitulo);
        titulos.add(meutitulo);
        } catch (NumberFormatException e) {
            System.out.println("Aconteceu um erro: ");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
    System.out.println("Aconteceu algo, não sei o que ");
} catch (ErroDeConversaoException e) {
    System.out.println(e.getMessage());
}
        }
        System.out.println(titulos);
        
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        System.out.println("O programa finalizou corretamente.");
    }
}
