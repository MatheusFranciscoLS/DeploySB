package br.com.marcelo.lojalivro.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.marcelo.lojalivro.Model.Livro;
import br.com.marcelo.lojalivro.Repository.LivroRepository;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RestController
public class LivrosController {
    @Autowired
    LivroRepository livroRepository;

    @GetMapping("/livros-list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("livros-list");
        mv.addObject("livros", livroRepository.findAll());
        return mv;

    }

    @PostMapping("/livros-add")
    public ModelAndView create(@RequestBody Livro livro) {
        ModelAndView mv = new ModelAndView("livros-add");
        livroRepository.save(livro);
        mv.setViewName("redirect:livros-list");
        return mv;
       

    }

}