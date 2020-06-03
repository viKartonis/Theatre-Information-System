CREATE OR REPLACE TRIGGER tr_ai_toureActor before INSERT ON toureActor FOR each row
BEGIN
  SELECT sq_toureActors.NEXTVAL
  INTO :new.toureActor_id
  FROM dual;
END;