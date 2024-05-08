//https://www.baeldung.com/java-dbunit

CREATE TABLE IF NOT EXISTS AUTHOR_TEST
(
    'author_id' int AUTO_INCREMENET NOT NULL,
    'author_name' character varying 100 NOT NULL,
    'date_of_birth'character varying 100 NOT NULL,
    'written_books'character varying 2000 NOT NULL,
);