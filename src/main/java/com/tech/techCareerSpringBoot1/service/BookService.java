package com.tech.techCareerSpringBoot1.service;

import com.tech.techCareerSpringBoot1.data.dto.BookDto;
import com.tech.techCareerSpringBoot1.data.request.CreateBookRequest;
import com.tech.techCareerSpringBoot1.data.request.UpdateBookNameAndReleaseYearRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.tech.techCareerSpringBoot1.data.entity.Book;



import java.util.List;
import java.util.stream.Collectors;

import static com.tech.techCareerSpringBoot1.data.mapper.BookMapper.BOOK_MAPPER;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService {
    private final BookEntityService bookEntityService;

    @Override
    public BookDto createBook(CreateBookRequest createBookRequest) {
        Book book = BOOK_MAPPER.createBook(createBookRequest);
        book = bookEntityService.save(book);
        return BOOK_MAPPER.convertToBookDto(book);
    }

    @Override
    public BookDto deleteBook(int id) {
        bookEntityService.deleteBook(id);
        return null;
    }

    @Override
    public BookDto updateNameOfAuthorByBook(int id, String authorName) {
        Book book = this.bookEntityService.updateNameOfAuthorByBook(id, authorName);
        return BOOK_MAPPER.convertToBookDto(book);
    }

    @Override
    public List<BookDto> getAllBooks() {

        return this.bookEntityService.getAllBooks().stream()
                .map(BOOK_MAPPER::convertToBookDto).collect(Collectors.toList());
    }

    @Override
    public BookDto getBookByAuthorId(String authorID) {

        return BOOK_MAPPER.convertToBookDto(this.bookEntityService.getBookByAuthorId(authorID));
    }

    @Override
    public BookDto updateBookNameAndReleaseYear(UpdateBookNameAndReleaseYearRequest updateBookNameAndReleaseYearRequest) {

        return BOOK_MAPPER.convertToBookDto
                (this.bookEntityService.updateBookNameAndReleaseYear(updateBookNameAndReleaseYearRequest));
    }
}
