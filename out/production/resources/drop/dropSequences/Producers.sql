BEGIN
  EXECUTE IMMEDIATE 'DROP SEQUENCE SQ_PRODUCERS';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -2289 THEN
      RAISE;
    END IF;
END;