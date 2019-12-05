DROP TABLE IF EXISTS UserAddressDetails;


CREATE TABLE UserAddressDetails (
	userId INT NOT NULL,
    firstAddress VARCHAR(256),
    LocalAreaId INT NOT NULL,
    Created LONG,
    Updated LONG,
	Flag INT,
    CONSTRAINT fk_userId_userInfos_Id FOREIGN KEY (userId) REFERENCES userInfo(Id),
    CONSTRAINT fk_LocalAreaId_VillageTownLocalAreaDetails_Id FOREIGN KEY (LocalAreaId) REFERENCES VillageTownLocalAreaDetails(Id),
    PRIMARY KEY(Id)
);