# BankClientApplication

Simple bank client application with DB connection

For use you need database with 2 tables:

-useraccouts with columns ID(INT, Auto_Increment), Usernamme(VARCHAR), Password(VARCHAR), Balance(FLOAT)

-currencies with columns Name(VARCHAR), ExRate(FLOAT)

In useraccounts table, will be your user`s accounts

In currencies you need to create USD with its ExRate, and EUR with its ExRate

For connection you need mysql-driver
