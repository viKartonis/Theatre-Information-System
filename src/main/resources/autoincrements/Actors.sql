CREATE OR REPLACE TRIGGER tr_ai_actors before INSERT ON actors FOR each row
BEGIN
  SELECT sq_actors.NEXTVAL
  INTO :new.actor_id
  FROM dual;
END;