/*DROP TABLE gamesearcher.USERS;*/

CREATE TABLE gamesearcher.GAMES(
	gameID int unsigned not null unique auto_increment,
    gameName varchar(255) not null,
    gameDesc varchar(255) default '',
    gameConsoles varchar(255) not null,
    gamePlayers int default 0,
    gameCoop bool default false,
    gameGenres varchar(255),
    gameFrontArtUrl varchar(255),
    gameBackArtUrl varchar(255),
    gameLogoArtUrl varchar(255),
    gameDevLogoArtUrl varchar(255),
    gamePrice double not null default 0.00,
    gameDiscount double default 0.00
);
