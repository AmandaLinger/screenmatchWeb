package br.com.estudos.screenmatchWeb.domain.filme;

public class Filme {
    private String nome;
    private String duracaoEmMinutos;
    private String anoLancamento;
    private String genero;

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", duracaoEmMinutos='" + duracaoEmMinutos + '\'' +
                ", anoLancamento='" + anoLancamento + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public String getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public Filme(DadosCadastroFilme dados){
        this.nome = dados.nome();
        this.duracaoEmMinutos = dados.duracao();
        this.anoLancamento = dados.ano();
        this.genero = dados.genero();
    }
}
