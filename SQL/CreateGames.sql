DROP TABLE gamesearcher.GAMES;

CREATE TABLE gamesearcher.GAMES(
	gameID int unsigned not null unique auto_increment,
    gameName varchar(255) not null unique,
    gameDesc varchar(1023) default '',
    gameConsoles varchar(255) not null,
    gamePlayers int default 1,
    gameCoop bool default false,
    gameGenres varchar(255),
    gameReleaseDate date,
    gameDeveloper varchar(255),
    gamePublisher varchar(255),
    gameFrontArtUrl varchar(255),
    gameBackArtUrl varchar(255),
    gameLogoArtUrl varchar(255),
    gameDevLogoArtUrl varchar(255),
    gamePrice double not null default 0.00,
    gameDiscount double default 0.00
);
