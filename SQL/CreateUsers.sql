DROP TABLE gamesearcher.USERS;

CREATE TABLE gamesearcher.USERS(
	userID int unsigned not null unique auto_increment,
	userPassword varchar(255) not null,
	userFirstName varchar(255) not null,
    userLastName varchar(255) not null,
    userEmail varchar(255) unique not null,
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
    userLastLogin datetime default current_timestamp,
    userIsAdmin bool not null default false,
    userIsLocked bool not null default false,    
	primary key (userID)
);
