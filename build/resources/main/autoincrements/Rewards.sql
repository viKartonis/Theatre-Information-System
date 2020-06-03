CREATE OR REPLACE TRIGGER tr_ai_rewards before INSERT ON rewards FOR each row
BEGIN
  SELECT sq_rewards.NEXTVAL
  INTO :new.reward_id
  FROM dual;
END;