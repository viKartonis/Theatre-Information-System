BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE PRODUCTOR_DESIGNERS';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;