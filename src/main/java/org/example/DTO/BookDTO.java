package org.example.DTO;

import org.example.model.Book;

import java.time.Year;

public class BookDTO {
    private Integer id;
    private String name;
    private int authorId;
    private int publishingHouseId;
    private Year publishYear;
    private Year writingYear;
    private short pagesCount;
    private String isbn;

    public BookDTO(){}

    public static BookDTO fromEntity(Book book) {
        BookDTO bdto = new BookDTO();

        bdto.setId(book.getId());
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
