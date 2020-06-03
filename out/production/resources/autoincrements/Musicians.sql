CREATE OR REPLACE TRIGGER tr_ai_musicians before INSERT ON musician FOR each row
BEGIN
  SELECT sq_musicians.NEXTVAL
  INTO :new.musician_id
  FROM dual;
END;