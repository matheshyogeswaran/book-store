package com.mathesh.book_store.service;

import com.mathesh.book_store.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    public BookDto getBook(String bookId);

    public List<BookDto> getAllBooks();

    public BookDto createBook(BookDto bookDto);

    public BookDto updateBookName(BookDto bookDto);

    void deleteBookByBookId(String bookId);
}
