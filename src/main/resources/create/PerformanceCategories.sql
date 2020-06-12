begin createTableIfNotExists('performance_categories(
    performance_category_id NUMBER PRIMARY KEY,
    name VARCHAR2(256),
    CONSTRAINT performance_category_unique UNIQUE (name)
)'); end;