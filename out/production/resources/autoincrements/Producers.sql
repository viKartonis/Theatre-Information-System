CREATE OR REPLACE TRIGGER tr_ai_producers before INSERT ON producers FOR each row
BEGIN
  SELECT sq_producers.NEXTVAL
  INTO :new.producer_id
  FROM dual;
END;