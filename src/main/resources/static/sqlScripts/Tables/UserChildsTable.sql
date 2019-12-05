DROP TABLE IF EXISTS UserChild;


CREATE TABLE UserChild (
	Id INT AUTO_INCREMENT,
    UserId INT NOT NULL,
	ChildId INT NOT NULL,
    ChildType INT NOT NULL,
	Flag INT,
    CONSTRAINT fk_UserId_userInfo_Id FOREIGN KEY (UserId) REFERENCES userInfo(Id),
    CONSTRAINT fk_ChildId_userInfo_Id FOREIGN KEY (SpouseId) REFERENCES userInfo(Id),
    PRIMARY KEY(Id)
);