begin createTableIfNotExists('author(
    author_id NUMBER PRIMARY KEY,
    name VARCHAR2(256),
    country_id NUMBER NOT NULL REFERENCES countries(country_id),
    century NUMBER,
    CONSTRAINT author_unique UNIQUE (name, country_id, century)
)'); end;