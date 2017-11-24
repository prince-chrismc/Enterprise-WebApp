DROP TABLE gamesearcher.ORDERS;

CREATE TABLE gamesearcher.ORDERS(
	orderID int unsigned not null unique auto_increment,
    userEmail varchar(255) not null,
    gameID int unsigned not null,
    qty int default 1 not null,
    purchaseDate datetime default current_timestamp, /* https://stackoverflow.com/a/39808770/8480874 */
    
	primary key (orderID),
	foreign key (userEmail) references USERS (userEmail),
	foreign key (gameID) references GAMES (gameID)
);
