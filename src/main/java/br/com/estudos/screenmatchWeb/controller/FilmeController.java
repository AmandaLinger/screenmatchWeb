package br.com.estudos.screenmatchWeb.controller;

import br.com.estudos.screenmatchWeb.domain.filme.DadosAtualizacaoFilme;
import br.com.estudos.screenmatchWeb.domain.filme.DadosCadastroFilme;
import br.com.estudos.screenmatchWeb.domain.filme.Filme;
import br.com.estudos.screenmatchWeb.domain.filme.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmes") //passando a url
public class FilmeController {

    @Autowired
    private FilmeRepository repository;

    @GetMapping("/formulario") //informa que ao realizar um get na página, essa função seja executada
    public String carregaPaginaFormulario(Long id, Model model) {
        if(id!=null){
            var filme = repository.getReferenceById(id);
            model.addAttribute("filme", filme);
        }
        return "filmes/formulario"; //chama a página html nesse caminho
    }

    @GetMapping
    public String carregaPaginaListagem(Model model){
        model.addAttribute("lista", repository.findAll()); //usando métodos da JPA
        return "filmes/listagem";
    }

    @PostMapping
    public String cadastraFilme(DadosCadastroFilme dados){
        var filme = new Filme(dados);
        repository.save(filme);

        return "redirect:/filmes";
    }

    @PutMapping
    @Transactional
    public String atualizaFilme(DadosAtualizacaoFilme dados){
        var filme = repository.getReferenceById(dados.id());
        filme.atualizaDados(dados);

        return "redirect:/filmes";
    }

    @DeleteMapping
    public String removeFilme(Long id){
        repository.deleteById(id);
        return "redirect:/filmes";
    }
}
