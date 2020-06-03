CREATE OR REPLACE TRIGGER tr_ai_workers before INSERT ON workers FOR each row
BEGIN
  SELECT sq_workers.NEXTVAL
  INTO :new.worker_id
  FROM dual;
END;