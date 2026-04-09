# Описание
Приложение работает с данными о книгах. 
- Модель данных книги лежит в ```src/main/java/org/example/model/Book.java```. 
- Для общения с пользователем используется аналогичная модель без id ```src/main/java/org/example/DTO/BookDTO.java```.
- Для хранения данных реализовано простое in-memory DAO ```src/main/java/org/example/DAO/BookInMemoryDAO.java```
# Endpoints
Реализовано 5 эндпоинтов в классе ```BookResource```:
- ```/book/all``` получение всех сохраненных книг
- ```/book/{id}``` получение книги по id
- ```/book/new``` сохранение новой книги
- ```/update/{id}``` обновление уже существующей книги
- ```/delete/{id}``` удаление уже существующей книги
## Примеры тела запроса для тестов
#### Для ```/book/new```:

```
{
    "name": "Война и мир",
    "authorId": 1,
    "publishingHouseId": 1,
    "publishYear": 1867,
    "writingYear": 1865,
    "pagesCount": 1225,
    "isbn": "978-5-17-123456-7"
}
```
```
{
    "name": "Преступление и наказание",
    "authorId": 2,
    "publishingHouseId": 1,
    "publishYear": 1867,
    "writingYear": 1866,
    "pagesCount": 1225,
    "isbn": "978-5-17-123456-7"
}
```
#### Для ```/update/{id}```
- id указывается в пути, а в теле передаётся аналогичный для добавления BookDTO
```
{
    "name": "Идиот",
    "authorId": 1,
    "publishingHouseId": 1,
    "publishYear": 1900,
    "writingYear": 1869,
    "pagesCount": 1225,
    "isbn": "978-5-17-123456-7"
}
```

# Логирование
Логи пишутся интерсептором ```LoggingInterceptor``` в консоль в формате:
```
------------------------------<Logging time>------------------------------
Request mediaType: <MediaType>
Request body: <RequestBody>
```
Пример:
```
------------------------------2026-04-06T16:17:33.365470300------------------------------
Request mediaType: application/json
Request body: {
  "name": "Преступление и наказание",
  "authorId": 2,
  "publishingHouseId": 1,
  "publishYear": 1867,
  "writingYear": 1866,
  "pagesCount": 1225,
  "isbn": "978-5-17-123456-7"
}
```
