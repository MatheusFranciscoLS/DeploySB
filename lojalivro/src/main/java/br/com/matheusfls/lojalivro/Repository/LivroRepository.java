package br.com.matheusfls.lojalivro.Repository;

import org.springframework.data.repository.CrudRepository;

import br.com.matheusfls.lojalivro.Model.Livro;

public interface LivroRepository extends CrudRepository<Livro, Integer> {

}
