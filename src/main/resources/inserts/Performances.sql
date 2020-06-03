begin createTableIfNotExists('performances(
     performance_id NUMBER PRIMARY KEY,
      name VARCHAR2(256),
      producer_id NUMBER NOT NULL REFERENCES  producers(producer_id),
      productor_designer_id NUMBER NOT NULL REFERENCES  productor_designers(productor_designer_id),
      performance_category_id NUMBER NOT NULL REFERENCES  performance_categories(performance_category_id),
      coast NUMBER(10,3),
      conductor_id NUMBER NOT NULL REFERENCES conductors(conductor_id),
      sales NUMBER,
      author_id NUMBER NOT NULL REFERENCES authors(author_id),
      is_premier NUMBER(1),
      performance_date DATE,
      genre_id NUMBER NOT NULL REFERENCES genres(genre_id)
      )'); end;