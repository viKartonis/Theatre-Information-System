CREATE OR REPLACE TRIGGER tr_ai_characteristics before INSERT ON characteristics FOR each row
BEGIN
  SELECT sq_characteristics.NEXTVAL
  INTO :new.characteristic_id
  FROM dual;
END;