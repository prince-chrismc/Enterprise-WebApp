CREATE TABLE USERS(
	userID int unsigned not null unique auto_increment,
	userPassword varchar(255) not null,
	userFirstName varchar(255) not null,
    userLaststName varchar(255) not null,
    userEmail varchar(255),
	userAddress1 varchar(255),
	userAddress2 varchar(255),
	userCity varchar(255),
	userState varchar(255),
	userZip varchar(255),
	userCountry varchar(255),
    userCreditCardType ENUM('VISA', 'MASTERCARD'),
    userCreditCardNumber varchar(255),
    userCreditCardCVV varchar(255),
    userCreditCardExpiry varchar(255),
    userLastLogin varchar(255),
	primary key (userID)
);