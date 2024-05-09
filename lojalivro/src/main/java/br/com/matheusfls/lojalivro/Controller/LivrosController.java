package br.com.matheusfls.lojalivro.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.matheusfls.lojalivro.Model.Livro;
import br.com.matheusfls.lojalivro.Repository.LivroRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LivrosController {

    @Autowired
    LivroRepository lr;

    @GetMapping("/livros")
    public ModelAndView getLivros() {
        ModelAndView mv = new ModelAndView("livros");
        mv.addObject("livros", lr.findAll());
        return mv;
    }

    @GetMapping("/addlivro")
    public String getAddLivro() {
        return "livro-add";
    }

    @PostMapping("/addlivro")
    public String postAddLivros(Livro livro) {
        lr.save(livro);
        return "redirect:/livros";
    }

}
