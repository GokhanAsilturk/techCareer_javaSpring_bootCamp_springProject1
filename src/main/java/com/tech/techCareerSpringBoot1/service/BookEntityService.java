package com.tech.techCareerSpringBoot1.service;

import com.tech.techCareerSpringBoot1.data.entity.Book;
import com.tech.techCareerSpringBoot1.data.request.UpdateBookNameAndReleaseYearRequest;
import com.tech.techCareerSpringBoot1.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class BookEntityService implements IBookEntityService {

    private final BookRepo bookRepo;

    @Autowired
    public BookEntityService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Book save(Book book) {

        return this.bookRepo.save(book);
    }

    @Override
    public Book deleteBook(int id) {
        Book book = this.bookRepo.findById(id).orElseThrow(() -> new NotFoundException("This book not found!"));
        book.setIsDeleted(true);
        this.bookRepo.save(book);
        return book;
    }

    @Override
    public Book updateNameOfAuthorByBook(int id, String authorName) {
        Book book = this.bookRepo.findById(id).orElseThrow(() -> new NotFoundException("This book not found!"));
        book.setAuthorID(authorName);
        this.bookRepo.save(book);
        return book;
    }


    @Override
    public List<Book> getAllBooks() {

        //optional class kullandığımız için önce isPresent kontrolü yapmalıyız.
        if (this.bookRepo.findAllByIsDeletedFalse().isPresent()) {
            return this.bookRepo.findAllByIsDeletedFalse().get();
        }
        //boş liste döndürmek için.
        return List.of();
    }

    @Override
    public Book getBookByAuthorId(String authorID) {

        return this.bookRepo.findByAuthorID(authorID).orElseThrow(() -> new NotFoundException("This book not found!"));
    }

    @Override
    public Book updateBookNameAndReleaseYear(UpdateBookNameAndReleaseYearRequest updateBookRequest) {

        Book book = this.bookRepo.findById(updateBookRequest.getId()).orElseThrow(()
                -> new NotFoundException("This book not found!"));

        book.setReleaseYear(updateBookRequest.getReleaseYear());
        book.setName(updateBookRequest.getName());
        bookRepo.save(book);

        return this.bookRepo.findById(updateBookRequest.getId()).orElseThrow(()
                -> new NotFoundException("This book not found!"));
    }
}
