--liquibase formatted sql
--changeset sa:1

CREATE TABLE Author (
    id BIGINT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(400) NOT NULL
);

CREATE TABLE Book (
    id BIGINT AUTO_INCREMENT  PRIMARY KEY,
    authorId BIGINT NOT NULL,
    name VARCHAR(400) NOT NULL
);

CREATE TABLE Quotation (
    id BIGINT AUTO_INCREMENT  PRIMARY KEY,
    bookId BIGINT NOT NULL,
    quotation VARCHAR(1000) NOT NULL
);

ALTER TABLE Quotation
    ADD CONSTRAINT quotation_book_id
    FOREIGN KEY (bookId) REFERENCES Book(id);

ALTER TABLE Book
    ADD CONSTRAINT book_author_id
    FOREIGN KEY (authorId) REFERENCES Author(id);


INSERT INTO Author(id, name) VALUES (1, 'Stanisław Jerzy Lec');
INSERT INTO Author(id, name) VALUES (2, 'Oscar Wilde');
INSERT INTO Author(id, name) VALUES (3, 'Zbigniew Herbert');
INSERT INTO Author(id, name) VALUES (4, 'Adam Mickiewicz');

INSERT INTO Book(id, authorId, name) VALUES (1, 1, 'Myśli nieuczesane');
INSERT INTO Book(id, authorId, name) VALUES (2, 2, 'Portret Doriana Graya');
INSERT INTO Book(id, authorId, name) VALUES (3, 2, 'Intentions');

INSERT INTO Book(id, authorId, name) VALUES (4, 3, 'Przesłanie Pana Cogito');

INSERT INTO Book(id, authorId, name) VALUES (5, 4, 'Pan Tadeusz');
INSERT INTO Book(id, authorId, name) VALUES (6, 4, 'Dziady');

INSERT INTO Quotation(id, bookId, quotation) VALUES (1, 1, 'Bezmyślność zabija. Innych.');
INSERT INTO Quotation(id, bookId, quotation) VALUES (2, 1, 'Gdyby jeszcze kozła ofiarnego można było doić!');
INSERT INTO Quotation(id, bookId, quotation) VALUES (3, 1, 'Bądź altruistą. Szanuj egoizm drugich.');
INSERT INTO Quotation(id, bookId, quotation) VALUES (4, 1, 'Błoto stwarza czasem pozory głębi.');
INSERT INTO Quotation(id, bookId, quotation) VALUES (5, 1, 'By dojść do źródła, trzeba płynąć pod prąd.');
INSERT INTO Quotation(id, bookId, quotation) VALUES (6, 1, 'Chcesz ukryć twarz – wyjdź nago.');
INSERT INTO Quotation(id, bookId, quotation) VALUES (7, 1, 'Błoto stwarza czasem pozory głębi.');
INSERT INTO Quotation(id, bookId, quotation) VALUES (8, 1, 'Człowiek we własnym życiu gra zaledwie mały epizod.');

INSERT INTO Quotation(id, bookId, quotation) VALUES (9, 2, 'Ale młodość uśmiecha się bez powodu. To właśnie stanowi główny jej urok.');
INSERT INTO Quotation(id, bookId, quotation) VALUES (10, 2, 'Uczucia tych, których przestaliśmy kochać, są zawsze śmieszne.');
INSERT INTO Quotation(id, bookId, quotation) VALUES (11, 2, 'Jaka jest różnica między kaprysem a dozgonną miłością? Ta, że kaprys trwa trochę dłużej.');

INSERT INTO Quotation(id, bookId, quotation) VALUES (12, 3, 'Każdy, kto nie potrafi sam się uczyć, uczy innych.');

INSERT INTO Quotation(id, bookId, quotation) VALUES (13, 4, 'Bądź wierny Idź');

INSERT INTO Quotation(id, bookId, quotation) VALUES (14, 5, 'Hajże na Soplicę!');
INSERT INTO Quotation(id, bookId, quotation) VALUES (15, 5, 'Jam jest Jacek Soplica…');
INSERT INTO Quotation(id, bookId, quotation) VALUES (16, 5, 'Poloneza czas zacząć');
INSERT INTO Quotation(id, bookId, quotation) VALUES (17, 5, 'Taki miał koniec zajazd ostatni na Litwie.');

INSERT INTO Quotation(id, bookId, quotation) VALUES (18, 6, 'Gustaw umarł 1823, 1 listopada. Tu narodził się Konrad 1823, 1 listopada');
INSERT INTO Quotation(id, bookId, quotation) VALUES (19, 6, 'Mrok tajemnic nas otacza, Pieśń i wiara przewodniczy.');


