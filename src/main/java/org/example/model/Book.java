package org.example.model;

import java.time.Year;

public class Book {

    private Integer id;
    private String name;
    private int authorId;
    private int publishingHouseId;
    private Year publishYear;
    private Year writingYear;
    private short pagesCount;
    private String isbn;

    private Book(Integer id,
                 String name,
                 int authorId,
                 int publishingHouseId,
                 Year publishYear,
                 Year writingYear,
                 short pagesCount,
                 String isbn) {
        this.id = id;
        this.name = name;
        this.authorId = authorId;
        this.publishingHouseId = publishingHouseId;
        this.publishYear = publishYear;
        this.writingYear = writingYear;
        this.pagesCount = pagesCount;
        this.isbn = isbn;
    }

    public static Book newBook(String name,
                               int authorId,
                               int publishingHouseId,
                               Year publishYear,
                               Year writingYear,
                               short pagesCount,
                               String isbn) {
        return new Book(null, name, authorId, publishingHouseId, publishYear, writingYear, pagesCount, isbn);
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
