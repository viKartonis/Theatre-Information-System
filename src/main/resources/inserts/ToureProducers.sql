begin createTableIfNotExists('toureProducer(
     toureProducer_id NUMBER PRIMARY KEY,
     toure_id NUMBER NOT NULL REFERENCES toures(toure_id),
     producer_id NUMBER NOT NULL REFERENCES producers(producer_id)
 )'); end;