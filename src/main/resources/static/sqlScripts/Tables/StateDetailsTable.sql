DROP TABLE IF EXISTS StateDetails;


CREATE TABLE StateDetails (
	Id INT AUTO_INCREMENT,
    CountryId INT NOT NULL,
    StateName VARCHAR(30) NOT NULL,
    StateCode VARCHAR(30),
    Flag INT,
    About VARCHAR(256),
    CONSTRAINT fk_CountryId_CountryDetails_Id FOREIGN KEY (CountryId) REFERENCES CountryDetails(Id),
    PRIMARY KEY(Id)
);