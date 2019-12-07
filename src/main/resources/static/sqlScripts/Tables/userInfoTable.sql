-- DROP TABLE IF EXISTS userInfo;


CREATE TABLE userInfo (
    Id INT AUTO_INCREMENT,
    Username VARCHAR(30) NOT NULL UNIQUE,
    FirstName VARCHAR(30) NOT NULL,
    LastName VARCHAR(30),
    NickName VARCHAR(30),
    Email VARCHAR(30),
    Phone VARCHAR(20),
    DateOfBirth DATE NOT NULL,
    Gender INT,
    Passphrase VARCHAR(30),
    -- ProfileImage VARCHAR(30), profle image namw will be same same as ID.jpg (no need to store)
    UserAddressDetailsId INT,
    SubcasteReligion INT,
    Flag INT,
    Created LONG,
    Updated LONG,
    About VARCHAR(256),
    
    PRIMARY KEY(Id)
);