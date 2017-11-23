DROP TABLE gamesearcher.CARTS;

CREATE TABLE gamesearcher.CARTS(
	cart_entryID int unsigned not null unique auto_increment,
    userEmail varchar(255) not null,
    gameID int unsigned not null,
    qty int default 1,
    
	primary key (userEmail, gameID),
	foreign key (userEmail) references USERS (userEmail),
	foreign key (gameID) references GAMES (gameID)
);
