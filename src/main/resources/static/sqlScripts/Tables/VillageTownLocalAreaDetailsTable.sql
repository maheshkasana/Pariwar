DROP TABLE IF EXISTS VillageTownLocalAreaDetails;


CREATE TABLE VillageTownLocalAreaDetails (
	  Id INT AUTO_INCREMENT,
    TehsilId INT NOT NULL,
    VillageTownLocalAreaName VARCHAR(100) NOT NULL,
    VillageTownLocalAreaCode VARCHAR(100) NOT NULL,
    PinCode INT,
	  Flag INT,
    About VARCHAR(256),
    CONSTRAINT fk_TehsilId_TehsilDetails_Id FOREIGN KEY (TehsilId) REFERENCES TehsilDetails(Id),
    PRIMARY KEY(Id)
);