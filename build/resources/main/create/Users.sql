begin createTableIfNotExists('users(
    user_id NUMBER PRIMARY KEY,
    email VARCHAR2(256),
    password VARCHAR2(256),
    user_role_id NUMBER NOT NULL
    REFERENCES user_roles(user_role_id)
)'); end;