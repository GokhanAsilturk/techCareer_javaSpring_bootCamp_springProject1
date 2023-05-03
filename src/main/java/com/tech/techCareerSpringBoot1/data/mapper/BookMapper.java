package com.tech.techCareerSpringBoot1.data.mapper;

import com.tech.techCareerSpringBoot1.data.dto.BookDto;
import com.tech.techCareerSpringBoot1.data.request.CreateBookRequest;
import com.tech.techCareerSpringBoot1.data.request.UpdateBookNameAndReleaseYearRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tech.techCareerSpringBoot1.data.entity.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper BOOK_MAPPER = Mappers.getMapper(BookMapper.class);

    BookDto convertToBookDto(Book book);

    Book createBook(CreateBookRequest createBookRequest);

    BookDto updateBookRequestToBookDto(UpdateBookNameAndReleaseYearRequest updateBookRequest);
}
