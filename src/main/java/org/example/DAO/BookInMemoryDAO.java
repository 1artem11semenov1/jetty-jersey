package org.example.DAO;

import org.example.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookInMemoryDAO {
    private HashMap<Integer, Book> data;
    private Integer lastId;

    public BookInMemoryDAO() {
        this.data = new HashMap<>();
        this.lastId = -1;
    }

    public List<Book> getAll() {
        List<Book> result = new ArrayList<>();
        for (Map.Entry<Integer, Book> entry : data.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public Book getById(Integer id) {
        if (id != null) {
            return data.getOrDefault(id, null);
        }
        return null;
    }

    public Book create(Book book) {
        if (book.getId() != null) {
            throw new IllegalArgumentException("Book already exists.");
        }

        book.setId(++lastId);
        data.put(lastId, book);

        return book;
    }

    public Book update(Book book) {
        Integer id = book.getId();
        if (id == null || data.getOrDefault(id, null) == null) {
            return null;
        }

        data.put(id, book);
        return book;
    }

    public boolean delete(Integer id) {
        if (id == null || data.getOrDefault(id, null) == null) {
            return false;
        }

        data.remove(id);
        return true;
    }
}
