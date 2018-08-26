CREATE TABLE USERS (
    ID NUMBER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    FIRST_NAME VARCHAR(32) NOT NULL,
    LAST_NAME VARCHAR(32) NOT NULL,
    AGE NUMBER
);

CREATE TABLE PRODUCTS (
    ID NUMBER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(32) NOT NULL,
    PRICE NUMBER NOT NULL,
    CATEGORY VARCHAR(32) NOT NULL,
    GENDER VARCHAR(16) NOT NULL,
    COLOUR VARCHAR(32) NOT NULL,
    SIZE VARCHAR(32) NOT NULL,
    QUANTITY NUMBER NOT NULL
);

CREATE TABLE ORDERS (
    ID NUMBER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    USER_ID NUMBER NOT NULL,
    PRICE NUMBER NOT NULL,
    DATE_OF_CREATE DATE,
    STATUS VARCHAR (32) NOT NULL,
    CONSTRAINT USER FOREIGN KEY (USER_ID) REFERENCES USERS (ID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE ORDERS_PRODUCTS(
    ORDER_ID NUMBER NOT NULL,
    PRODUCTS_ID NUMBER NOT NULL,
    CONSTRAINT ORDER_FK FOREIGN KEY (ORDER_ID) REFERENCES ORDERS (ID) ON DELETE CASCADE,
    CONSTRAINT PRODUCTS_FK FOREIGN KEY (PRODUCTS_ID) REFERENCES PRODUCTS(ID) ON DELETE CASCADE
);