DROP TABLE IF EXISTS UserSubcaste;


CREATE TABLE UserSubcaste (
	  Id INT AUTO_INCREMENT,
    UserSubcasteName VARCHAR(50),
    UserCasteId INT,
    About VARCHAR(256),
	  Flag INT,
    CONSTRAINT fk_UserCasteId_UserCaste_Id FOREIGN KEY (UserCasteId) REFERENCES UserCaste(Id),
    PRIMARY KEY(Id)
);