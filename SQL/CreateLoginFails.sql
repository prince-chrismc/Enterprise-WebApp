DROP TABLE gamesearcher.LOGINFAILS;

CREATE TABLE gamesearcher.LOGINFAILS(
	attemptID int unsigned not null unique auto_increment,
    userEmail varchar(255) not null unique,
    qty int default 1 not null,
    attemptDate datetime default current_timestamp, /* https://stackoverflow.com/a/39808770/8480874 */
    
	primary key (attemptID, userEmail),
	foreign key (userEmail) references USERS (userEmail)
);