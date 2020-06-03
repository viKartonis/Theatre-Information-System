begin createTableIfNotExists('author(
    author_id NUMBER PRIMARY KEY,
    name VARCHAR2(256),
    country_id NUMBER NOT NULL REFERENCES countries(country_id),
    century NUMBER
)'); end;