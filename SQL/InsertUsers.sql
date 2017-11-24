INSERT INTO gamesearcher.users(userPassword, userFirstName, userLastName, userEmail) VALUES
('root', 'admin', 'root', 'admin@example.com');

INSERT INTO gamesearcher.users
(`userPassword`,`userFirstName`,`userLastName`,`userEmail`,
`userCreditCardNumber`,`userCreditCardCVV`,`userCreditCardExpiry`)
VALUES
('rich', 'john', 'smith', 'john@example.com',
'01234567890', '555', '10/25');
