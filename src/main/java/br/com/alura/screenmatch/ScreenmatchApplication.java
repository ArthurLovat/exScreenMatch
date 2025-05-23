package br.com.alura.screenmatch;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	// minha apikey 8a180701
	@Override //Basicamente sobrescrever o metodo run
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();

		String titulo = "gilmore girls";

		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=" + URLEncoder.encode(titulo, StandardCharsets.UTF_8) + "&apikey=8a180701");
		System.out.println(json); //imprime o json

//		json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
//		System.out.println(json);

		//Agora vamos implementar o conversor
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class); //aqui nos ultilizamos a classe
		System.out.println(dados);//imprime os dados ja convertidos      //pra converter os dados (ConverteDados, IConverteDados)

	}
}
