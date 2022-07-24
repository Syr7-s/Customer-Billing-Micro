CREATE TABLE CUSTOMER (
                      CUSTOMER_ID IDENTITY NOT NULL PRIMARY KEY,
                      FIRST_NAME VARCHAR(128) NOT NULL,
                      LAST_NAME VARCHAR(128) NOT NULL,
                      PHONE VARCHAR(128) NOT NULL,
                      EMAIL VARCHAR(128) NOT NULL
);
