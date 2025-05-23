package br.com.alura.screenmatch.service;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    public String obterDados(String endereco){
        HttpClient client = HttpClient.newHttpClient(); //como se fosse o client

        HttpRequest request = HttpRequest.newBuilder()  //cria um URI para fazer a requisição
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString()); //tentar receber a resposta
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        String json = response.body(); //aqui vamos pegar o "response.body" que foi a nossa resposta à requisição e vamos adicionar a variavel String json
        return json; //aqui retornamos a variavel do tipo string, que é a resposta json
    }
}
