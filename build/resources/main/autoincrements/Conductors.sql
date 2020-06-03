CREATE OR REPLACE TRIGGER tr_ai_conductors before INSERT ON conductors FOR each row
BEGIN
  SELECT sq_conductors.NEXTVAL
  INTO :new.conductor_id
  FROM dual;
END;