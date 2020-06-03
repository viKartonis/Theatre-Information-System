CREATE OR REPLACE TRIGGER tr_ai_toureProducers before INSERT ON toureProducer FOR each row
BEGIN
  SELECT sq_toureProducers.NEXTVAL
  INTO :new.toureProducer_id
  FROM dual;
END;