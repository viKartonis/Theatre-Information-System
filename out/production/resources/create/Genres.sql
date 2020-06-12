begin createTableIfNotExists('genres(
    genres_id NUMBER PRIMARY KEY,
    name VARCHAR2(256),
    CONSTRAINT genres_unique UNIQUE (name)
)'); end;