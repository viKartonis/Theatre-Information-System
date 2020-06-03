begin createTableIfNotExists('rewards(
                reward_id NUMBER PRIMARY KEY,
                name VARCHAR2(250) NOT NULL,
                date_b DATE)'); end;