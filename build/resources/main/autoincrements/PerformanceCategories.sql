CREATE OR REPLACE TRIGGER tr_ai_performance_categories before INSERT ON performance_categories FOR each row
BEGIN
  SELECT sq_performance_category.NEXTVAL
  INTO :new.performance_category_id
  FROM dual;
END;