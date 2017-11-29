UPDATE gamesearcher.users
SET
userFirstName = 'John',
userLastName = 'Smith',
userAddress1 = '555 Concordia Street',
userAddress2 = '',
userCity = 'MONTREAL',
userState = 'QUEBEC',
userZip = 'H1H1H1',
userCountry = 'CANADA',
userCreditCardType = 'VISA',
userCreditCardNumber = '01234567890',
userCreditCardCVV = '123',
userCreditCardExpiry = '10/19',
userLastLogin = current_timestamp
WHERE `userID` = 2 AND 
`userEmail` = 'john@example.com';
