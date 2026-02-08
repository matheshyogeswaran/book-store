package com.mathesh.book_store.mapper;

import com.mathesh.book_store.dto.BookDto;
import com.mathesh.book_store.entity.Book;

public class BookMapper {

    public static BookDto toDto(Book book)
    {
        BookDto bookDto = new BookDto(book.bookId(), book.name(), book.price(), book.author());
        return bookDto;
    }

    public static Book toEntity(BookDto bookDto)
    {
        Book book = new Book(bookDto.bookId(), bookDto.name(), bookDto.price(), bookDto.author());
        return book;
    }
}
