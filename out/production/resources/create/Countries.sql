begin createTableIfNotExists('countries(
    country_id NUMBER PRIMARY KEY,
    name VARCHAR2(256),
    CONSTRAINT countries_unique UNIQUE (name)
)'); end;