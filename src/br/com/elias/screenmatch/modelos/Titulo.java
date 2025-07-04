package br.com.elias.screenmatch.modelos;

import br.com.elias.screenmatch.excecao.ErroDeConversaoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    @SerializedName("Title")
    private String nome;
    @SerializedName("Year")
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;
    // primeiro os atriutos , depois os metodos por recomendação.


    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb titulo) throws ErroDeConversaoException {
        this.nome = titulo.title();

        if (titulo.year().length() > 4) {
            throw new ErroDeConversaoException("Não consegui conveter  o ano. Porque tem mais de 04 caracteres.");
        }
        this.anoDeLancamento = Integer.valueOf(titulo.year());
        this.duracaoEmMinutos = Integer.valueOf(titulo.runtime().substring(0,2));
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFilhaTecnica() {
        System.out.println("Nome do filme" + nome);
        System.out.println("Ano de lançamento "  + anoDeLancamento);
    }

    public void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes ++;
    }

    public double pegaMedia() {
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }


    @Override
    public String toString() {
        return
                "(nome= '" + nome + '\'' +
                ", anoDeLancamento= " + anoDeLancamento +
              "," + "duracao em minutos " +  duracaoEmMinutos + ")";
    }
}
