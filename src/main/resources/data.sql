INSERT INTO Users VALUES ('abc@gmail.com');
INSERT INTO Users VALUES ('jks@gmail.com');
--INSERT INTO Users VALUES ('test@gmail.com');

INSERT INTO BILLER VALUES ('1','Biller1');
INSERT INTO BILLER VALUES ('2','Biller2');
INSERT INTO BILLER VALUES ('3','Biller3');

INSERT INTO BILL (billerID,userID,amount,is_Paid) VALUES ('1','abc@gmail.com',20.00,FALSE);
INSERT INTO BILL (billerID,userID,amount,is_Paid) VALUES ('2','abc@gmail.com',30.00,FALSE);
INSERT INTO BILL (billerID,userID,amount,is_Paid)  VALUES ('3','jks@gmail.com',40.00,FALSE);

INSERT INTO WALLET VALUES ('abc@gmail.com',200.00);
INSERT INTO WALLET VALUES ('jks@gmail.com',400.00);
INSERT INTO WALLET VALUES ('1',1000.00);
INSERT INTO WALLET VALUES ('2',5000.00);
INSERT INTO WALLET VALUES ('3',1000.00);