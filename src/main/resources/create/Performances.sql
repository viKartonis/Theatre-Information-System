begin createTableIfNotExists('performances(
     performance_id NUMBER PRIMARY KEY,
      name VARCHAR2(256),
      producer_id NUMBER NOT NULL REFERENCES  producers(producer_id),
      productor_designer_id NUMBER NOT NULL REFERENCES  productor_designers(productor_designers_id),
      performance_category_id NUMBER NOT NULL REFERENCES  performance_categories(performance_category_id),
      coast NUMBER(10,3),
      conductor_id NUMBER NOT NULL REFERENCES conductors(conductor_id),
      sales NUMBER,
      author_id NUMBER NOT NULL REFERENCES author(author_id),
      is_premier NUMBER(1),
      performance_date DATE,
      genre_id NUMBER NOT NULL REFERENCES genres(genres_id),
      CONSTRAINT performance_unique UNIQUE (name, producer_id, productor_designer_id, performance_category_id, coast, conductor_id, sales, author_id, is_premier, performance_date, genre_id)
)'); end;