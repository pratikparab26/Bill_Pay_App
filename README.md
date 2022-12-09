# Bill_Pay_App

# Assumption
1. Billers are already present in system 
2. Every biller has a wallet assocoated with it
3. customer to biller transaction always happen from wallet to wallet

# How it works.

# Registration
1. Registration of new user
 URL: localhost:8080/users/
 Method: POST
 Request body:
 {
    "emailID": "xyz@gmail.com"
}
Response: Registration Complete!!

2. Trying to register already registered user
 URL: localhost:8080/users/
 Method: POST
 Request body:
 {
    "emailID": "xyz@gmail.com"
}
Response: User is already registered!!

3. Registering new user wilth initial wallet ammount
URL: localhost:8080/users/
 Method: POST
 Request body:
{
    "emailID": "test@gmail.com",
    "amount": 30.0
}
Response: Registration Complete!!

# Bill Viewing

1. Get pending Billers for user
URL: localhost:8080/users/{USER}/pending/billers
e.g. localhost:8080/users/jks@gmail.com/pending/billers
Method: GET

Response:
[
    {
        "id": "3",
        "name": "Biller3"
    }
]

2. Get pending Bill for user and a biller 
URL: localhost:8080/users/{USER}/pending/Billers/3
e.g. llocalhost:8080/users/jks@gmail.com/pending/Billers/3
Method: GET

Response:
[
    {
        "id": "3",
        "billerID": "3",
        "userID": "jks@gmail.com",
        "amount": 40.0,
        "paid": false
    }
]


# Paying Bills

1. paying bill with sufficient balance in wallet
URL: localhost:8080/users/paybills
Method: POST

Request:
{
        "billId": "3",
        "billerID": "3",
        "userID": "jks@gmail.com",
        "amount": 400.0
}

Response:
Bill Paid Successfully!! Your new Balance is: 0.0


2. paying bill with insufficient balance in wallet
URL: localhost:8080/users/paybills
Method: POST

Request:
{
        "billId": "3",
        "billerID": "3",
        "userID": "jks@gmail.com",
        "amount": 400.0
}

Response:
Insufficient balance, Kindly recharge youe wallet!!

# Recharging Wallet


1. Add money to wallet
URL: localhost:8080/users/addMoney
Method: PUT

Request:
{
    "userID": "jks@gmail.com",
    "rechargeAmount": 200.00
}

Response:
Recharge successful!! new Balance is: 200.0

# View Balance

URL: localhost:8080/users/{userID}/balances
e.g.: localhost:8080/users/jks@gmail.com/balances
Method: GET

Response:
Your Current Balance is: 200.0


NOTE:
1. Jococo plugin is added and you can find the report in target/site folder as html, csv etc.
2. Junits are added
3. data.sql takes care of initial setup

