CREATE OR REPLACE TRIGGER tr_ai_roles before INSERT ON roles FOR each row
BEGIN
  SELECT sq_roles.NEXTVAL
  INTO :new.role_id
  FROM dual;
END;