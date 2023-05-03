package com.tech.techCareerSpringBoot1.service;

import com.tech.techCareerSpringBoot1.data.dto.BookDto;
import com.tech.techCareerSpringBoot1.data.request.CreateBookRequest;
import com.tech.techCareerSpringBoot1.data.request.UpdateBookNameAndReleaseYearRequest;

import java.util.List;

public interface IBookService {
    BookDto createBook(CreateBookRequest createBookRequest);

    BookDto deleteBook(int id);

    BookDto  updateNameOfAuthorByBook(int id,String name);

    List<BookDto> getAllBooks();

    BookDto getBookByAuthorId(String authorID);

    BookDto updateBookNameAndReleaseYear(UpdateBookNameAndReleaseYearRequest updateBookRequest);
}
