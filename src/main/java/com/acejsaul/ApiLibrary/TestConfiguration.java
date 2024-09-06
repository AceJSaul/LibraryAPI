package com.acejsaul.ApiLibrary;

import com.acejsaul.ApiLibrary.entities.Author;
import com.acejsaul.ApiLibrary.entities.Book;
import com.acejsaul.ApiLibrary.entities.User;
import com.acejsaul.ApiLibrary.entities.enums.UserRole;
import com.acejsaul.ApiLibrary.repository.AuthorRepository;
import com.acejsaul.ApiLibrary.repository.BookRepository;
import com.acejsaul.ApiLibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Year;

@Configuration
@Profile("h2TestDB")
public class TestConfiguration implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {

        // Authors
        Author author1 = new Author(null, "Fiódor", "Dostoiévski");
        Author author2 = new Author(null, "Graciliano", "Ramos");

        authorRepository.save(author1);
        authorRepository.save(author2);

        //Books
        Book book1 = new Book(null,
                "Crime e Castigo",
                "Neste livro, Raskólnikov, um jovem estudante, pobre e desesperado, perambula pelas ruas de São Petersburgo até cometer um crime que tentará justificar por uma teoria: grandes homens, como César ou Napoleão, foram assassinos absolvidos pela História.",
                Year.parse("1866"),
                author1,
                "https://www.livrariamegafauna.com.br/wp-content/uploads/2021/08/9788588808836.jpg");

        Book book2 = new Book(null,
                "Vidas Secas",
                "A obra descreve os momentos de uma família de retirantes que atravessam o sertão nordestino. Todos estão fugindo da miséria e da seca e em busca de uma vida melhor.",
                Year.parse("1938"),
                author2,
                "https://m.media-amazon.com/images/I/618-b9Im6dL._AC_UF1000,1000_QL80_.jpg");

        bookRepository.save(book1);
        bookRepository.save(book2);

        // Users

        User user1 = new User("AceJ",
                            "Saul",
                            "acejsaul@gmail.com",
                            "abcdefg",
                            UserRole.ADMIN);
        user1.addToFav(book1);
        user1.addToFav(book2);
        userRepository.save(user1);
    }
}
