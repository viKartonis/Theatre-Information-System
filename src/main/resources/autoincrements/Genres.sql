CREATE OR REPLACE TRIGGER tr_ai_genres before INSERT ON genres FOR each row
BEGIN
  SELECT sq_genres.NEXTVAL
  INTO :new.genres_id
  FROM dual;
END;