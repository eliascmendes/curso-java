package br.com.elias.screenmatch.calculo;

public class Recomendacao {
    private String recomendacao;

    public void filtra(Classificavel classificavel) {
        if (classificavel.getClassicacao() >= 4) {
            System.out.println("Está entre os preferidos do momento");
        } else if (classificavel.getClassicacao() >=2) {
            System.out.println("Muito bem avaliado no momento");
        } else {
            System.out.println("Coloque na sua lista para assistir depois");
        }
    }
}
