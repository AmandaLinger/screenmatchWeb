package br.com.estudos.screenmatchWeb.controller;

import br.com.estudos.screenmatchWeb.domain.filme.DadosCadastroFilme;
import br.com.estudos.screenmatchWeb.domain.filme.Filme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmes") //passando a url
public class FilmeController {

    private List<Filme>filmes = new ArrayList<>();

    @GetMapping("/formulario") //informa que ao realizar um get na página, essa função seja executada
    public String carregaPaginaFormulario(){
        return "filmes/formulario"; //chama a página html nesse caminho
    }

    @GetMapping
    public String carregaPaginaListagem(Model model){
        model.addAttribute("lista",filmes);
        return "filmes/listagem";
    }

    @PostMapping
    public String cadastraFilme(DadosCadastroFilme dados){
        var filme = new Filme(dados);
        filmes.add(filme);

        return "redirect:/filmes";
    }
}
