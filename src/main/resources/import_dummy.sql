DELETE FROM SIMPLE_USERS
INSERT INTO SIMPLE_USERS(id,create_date,modifie_date,enabled,password,role,username) VALUES (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true, '$2a$12$gZ.yvR4/mbCM6ev5L88NOeCh3VeH07K3c5kErn02NwrlsCRyX6fMi', 'ADMIN', 'admin')
INSERT INTO SIMPLE_USERS(id,create_date,modifie_date,enabled,password,role,username) VALUES (2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true, '$2a$12$gZ.yvR4/mbCM6ev5L88NOeCh3VeH07K3c5kErn02NwrlsCRyX6fMi', 'USER', 'user')
ALTER SEQUENCE simple_users_id_seq restart with 3