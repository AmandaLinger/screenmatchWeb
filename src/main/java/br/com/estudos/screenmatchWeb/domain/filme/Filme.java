package br.com.estudos.screenmatchWeb.domain.filme;

import jakarta.persistence.*;

@Entity //informa que a classe é uma tabela no banco de dados
@Table(name = "filmes") //passando o nome da tabela no bd
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //informa que o banco de dados que gerará o numero de id
    private Long id;
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

    public Long getId() {
        return id;
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

    public Filme(){}
}
