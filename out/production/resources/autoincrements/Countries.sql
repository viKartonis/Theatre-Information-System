CREATE OR REPLACE TRIGGER tr_ai_countries before INSERT ON countries FOR each row
BEGIN
  SELECT sq_countries.NEXTVAL
  INTO :new.country_id
  FROM dual;
END;