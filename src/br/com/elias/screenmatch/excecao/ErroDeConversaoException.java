package br.com.elias.screenmatch.excecao;

public class ErroDeConversaoException extends Exception {
    private String mensagem;

    public ErroDeConversaoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}