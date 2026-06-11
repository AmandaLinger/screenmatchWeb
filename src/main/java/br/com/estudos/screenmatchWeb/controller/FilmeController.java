package br.com.estudos.screenmatchWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/filmes") //passando a url
public class FilmeController {

    @GetMapping //informa que ao realizar um get na página, essa função seja executada
    public String carregaPaginaFormulario(){
        return "filmes/formulario"; //chama a página html nesse caminho
    }
}
