DROP TABLE IF EXISTS UserParent;


CREATE TABLE UserParent (
	Id INT AUTO_INCREMENT,
    UserId INT NOT NULL,
	ParentId INT NOT NULL,
    ParentType INT NOT NULL,
	Flag INT,
    CONSTRAINT fk_UserId_userInfo_Id FOREIGN KEY (UserId) REFERENCES userInfo(Id),
    CONSTRAINT fk_ParentId_userInfo_Id FOREIGN KEY (ParentId) REFERENCES userInfo(Id),
    PRIMARY KEY(Id)
);