package com.tech.techCareerSpringBoot1.service;

import com.tech.techCareerSpringBoot1.data.dto.BookDto;
import com.tech.techCareerSpringBoot1.data.entity.Book;
import com.tech.techCareerSpringBoot1.data.request.UpdateBookNameAndReleaseYearRequest;


import java.util.List;

public interface IBookEntityService {

    Book save(Book book);

    Book deleteBook(int id);

    Book updateNameOfAuthorByBook(int id, String name);

    List<Book> getAllBooks();

    Book getBookByAuthorId(String authorID);

    Book updateBookNameAndReleaseYear(UpdateBookNameAndReleaseYearRequest updateBookRequest);
}
