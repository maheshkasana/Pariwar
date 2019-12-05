DROP TABLE IF EXISTS UserSpouse;


CREATE TABLE UserSpouse (
	Id INT AUTO_INCREMENT,
    UserId INT NOT NULL,
	SpouseId INT NOT NULL,
    SpouseType INT NOT NULL,
	Flag INT,
    CONSTRAINT fk_UserId_userInfo_Id FOREIGN KEY (UserId) REFERENCES userInfo(Id),
    CONSTRAINT fk_SpouseId_userInfo_Id FOREIGN KEY (SpouseId) REFERENCES userInfo(Id),
    PRIMARY KEY(Id)
);