CREATE OR REPLACE TRIGGER tr_ai_toures before INSERT ON toures FOR each row
BEGIN
  SELECT sq_toures.NEXTVAL
  INTO :new.toure_id
  FROM dual;
END;