package br.com.matheusfls.lojalivro.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.matheusfls.lojalivro.Model.Livro;
import br.com.matheusfls.lojalivro.Repository.LivroRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RestController
public class LivrosController {

    @Autowired
    LivroRepository lr;

    @GetMapping("/livros")
    public List<Livro> list() {
        return (List<Livro>) this.lr.findAll();
    }

    @PostMapping("/livros")
    public Livro create(@RequestBody Livro livro) {
        return this.lr.save(livro);
    }

}
