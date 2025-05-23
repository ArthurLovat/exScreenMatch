package br.com.alura.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados{

    private ObjectMapper mapper = new ObjectMapper(); //iremos ultilizar o ObjectMapper para converter os dados

    @Override //aqui implementamos uma metodo da interface
    public <T> T obterDados(String json, Class<T> classe) {

        try {
            return mapper.readValue(json, classe);
        }
        catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
