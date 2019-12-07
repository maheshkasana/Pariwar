DROP TABLE IF EXISTS UserCaste;


CREATE TABLE UserCaste (
	  Id INT AUTO_INCREMENT,
    UserCasteName VARCHAR(50),
    UserReligionId INT,
    About VARCHAR(256),
	  Flag INT,
    CONSTRAINT fk_UserReligionId_UserReligion_Id FOREIGN KEY (UserReligionId) REFERENCES UserReligion(Id),
    PRIMARY KEY(Id)
);