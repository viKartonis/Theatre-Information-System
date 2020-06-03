CREATE OR REPLACE TRIGGER tr_ai_users before INSERT ON users FOR each row
BEGIN
  SELECT sq_users.NEXTVAL
  INTO :new.user_id
  FROM dual;
END;