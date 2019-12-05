DROP TABLE IF EXISTS UserHistoryHandler;


CREATE TABLE UserHistoryHandler (
    Id INT AUTO_INCREMENT,
    UserId INT NOT NULL,
    ProfessionId INT,
    OrganisationId INT,
    AddressId INT,
    StartedDate INT,
    LastDate DATE,
    StillIn DATE,
    Flag INT,
    CONSTRAINT fk_UserId_userInfo_Id FOREIGN KEY (UserId) REFERENCES userInfo(Id),
    PRIMARY KEY(Id)
);