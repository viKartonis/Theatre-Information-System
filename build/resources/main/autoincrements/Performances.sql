CREATE OR REPLACE TRIGGER tr_ai_performances before INSERT ON performances FOR each row
BEGIN
  SELECT sq_performances.NEXTVAL
  INTO :new.performance_id
  FROM dual;
END;