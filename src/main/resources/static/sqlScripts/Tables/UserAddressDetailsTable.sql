DROP TABLE IF EXISTS UserAddressDetails;


CREATE TABLE UserAddressDetails (
	  Id INT AUTO_INCREMENT,
    firstAddress VARCHAR(256),
    LocalAreaId INT NOT NULL,
	  Flag INT,
    CONSTRAINT fk_LocalAreaId_VillageTownLocalAreaDetails_Id FOREIGN KEY (LocalAreaId) REFERENCES VillageTownLocalAreaDetails(Id),
    PRIMARY KEY(Id)
);