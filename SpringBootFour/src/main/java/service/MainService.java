package service;

import dao.RepositoryStudent;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MainService {
    //
    @Autowired
    private RepositoryStudent repositoryStudent;

    public Collection<Book> findAllBooks() {
        List<Book> books = new ArrayList<Book>();
        for(Book book: repositoryStudent.findAll()){
            books.add(book);
        }

        return books;
    }
}
