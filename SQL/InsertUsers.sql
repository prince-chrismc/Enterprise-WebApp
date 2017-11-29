INSERT INTO gamesearcher.users(userPassword, userFirstName, userLastName, userEmail, userIsAdmin) VALUES
('root', 'admin', 'root', 'admin@example.com', true);

INSERT INTO gamesearcher.users
(`userPassword`,`userFirstName`,`userLastName`,`userEmail`,
`userCreditCardNumber`,`userCreditCardCVV`,`userCreditCardExpiry`)
VALUES
('rich', 'john', 'smith', 'john@example.com',
'01234567890', '555', '10/25');
