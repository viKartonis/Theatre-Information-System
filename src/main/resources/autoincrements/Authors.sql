CREATE OR REPLACE TRIGGER tr_ai_authors before INSERT ON author FOR each row
BEGIN
  SELECT sq_authors.NEXTVAL
  INTO :new.author_id
  FROM dual;
END;