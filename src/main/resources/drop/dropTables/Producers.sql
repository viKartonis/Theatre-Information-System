BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE PRODUCERS';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;