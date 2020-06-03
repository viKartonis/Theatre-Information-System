CREATE OR REPLACE TRIGGER tr_ai_user_roles before INSERT ON user_roles FOR each row
BEGIN
  SELECT sq_user_roles.NEXTVAL
  INTO :new.user_role_id
  FROM dual;
END;