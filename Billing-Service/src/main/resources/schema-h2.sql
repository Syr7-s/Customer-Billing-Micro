CREATE TABLE BILLING (
                          BILLING_ID IDENTITY NOT NULL PRIMARY KEY,
                          BILLING_DATE VARCHAR(128) NOT NULL,
                          PAYMENT_DATE VARCHAR(128) NOT NULL,
                          CUSTOMER_ID VARCHAR(128) NOT NULL,
                          CUSTOMER_FULL_NAME VARCHAR(128)
);
