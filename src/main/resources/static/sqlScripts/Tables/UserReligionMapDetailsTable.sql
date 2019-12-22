DROP TABLE IF EXISTS UserReligionMapDetails;


CREATE TABLE UserReligionMapDetails (
	  Id INT AUTO_INCREMENT,
	  UserId INT NOT NULL,
    ReligionId INT,
    CasteId INT,
    SubCasteId INT,
	  Flag INT,
    PRIMARY KEY(Id)
);