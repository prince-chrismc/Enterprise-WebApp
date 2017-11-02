INSERT INTO gamesearcher.games (gameName, gameDesc, gameConsoles, gamePlayers, gameCoop, gameGenres, gameReleaseDate, gameDeveloper, gamePublisher,
gameFrontArtUrl, gameBackArtUrl, gameLogoArtUrl, gameDevLogoArtUrl, gamePrice, gameDiscount) VALUES
(
'007: The World is not Enough', '', 'PS;', 1, false, 'Shooter;', STR_TO_DATE('11/08/2000', '%m/%d/%Y'), 'Black Ops Entertainment', /*https://stackoverflow.com/a/9907257/8480874*/
'Electronic Arts', 'http://thegamesdb.net/banners/boxart/original/front/11554-1.jpg', 'http://thegamesdb.net/banners/boxart/original/back/11554-1.jpg', 
'http://thegamesdb.net/banners/clearlogo/11554.png', '', 5.99, 0.30
);
