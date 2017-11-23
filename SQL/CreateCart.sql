DROP TABLE gamesearcher.CART;

CREATE TABLE gamesearcher.CART(
	cart_entryID int unsigned not null unique auto_increment,
    userEmail varchar(255) not null,
    gameID int unsigned not null,
    
	primary key (cart_entryID),
	foreign key (userEmail) references USERS (userEmail),
	foreign key (gameID) references GAMES (gameID)
);