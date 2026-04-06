package org.example.DTO;

import org.example.model.Book;

import java.time.Year;

public class BookDTO {
    String name;
    int authorId;
    int publishingHouseId;
    Year publishYear;
    Year writingYear;
    short pagesCount;
    String isbn;

    public BookDTO(){}

    public static BookDTO fromEntity(Book book) {
        BookDTO bdto = new BookDTO();

        bdto.name = book.getName();
        bdto.authorId = book.getAuthorId();
        bdto.publishingHouseId = book.getPublishingHouseId();
        bdto.publishYear = book.getPublishYear();
        bdto.writingYear = book.getWritingYear();
        bdto.pagesCount = book.getPagesCount();
        bdto.isbn = book.getIsbn();

        return bdto;
    }

    public Book toEntity() {
        return Book.newBook(
                this.name,
                this.authorId,
                this.publishingHouseId,
                this.publishYear,
                this.writingYear,
                this.pagesCount,
                this.isbn
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getPublishingHouseId() {
        return publishingHouseId;
    }

    public void setPublishingHouseId(int publishingHouseId) {
        this.publishingHouseId = publishingHouseId;
    }

    public Year getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Year publishYear) {
        this.publishYear = publishYear;
    }

    public Year getWritingYear() {
        return writingYear;
    }

    public void setWritingYear(Year writingYear) {
        this.writingYear = writingYear;
    }

    public short getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(short pagesCount) {
        this.pagesCount = pagesCount;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
