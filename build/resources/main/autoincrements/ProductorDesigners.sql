CREATE OR REPLACE TRIGGER tr_ai_productor_designers before INSERT ON productor_designers FOR each row
BEGIN
  SELECT sq_productor_designers.NEXTVAL
  INTO :new.productor_designers_id
  FROM dual;
END;