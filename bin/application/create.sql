-----------Create Table-----------
CREATE TABLE dbo.Spieler (
    SpielerNr int NOT NULL PRIMARY KEY,
    Name varchar(255),
    Vorname varchar(255),
    EloZahl int
)

CREATE TABLE dbo.Gruppen (
    GruppenID int NOT NULL PRIMARY KEY,
    GruppenName varchar(255),
	MinEloZahl int,
	MaxEloZahl int
)

-----------Insert-----------
Insert into dbo.Gruppen(GruppenID, GruppenName, MinEloZahl, MaxEloZahl)
values (1, 'A', 2400, 4000)
Insert into dbo.Gruppen(GruppenID, GruppenName, MinEloZahl, MaxEloZahl)
values (2, 'B', 1800, 2399)
Insert into dbo.Gruppen(GruppenID, GruppenName, MinEloZahl, MaxEloZahl)
values (3, 'C', 1200, 1799)
Insert into dbo.Gruppen(GruppenID, GruppenName, MinEloZahl, MaxEloZahl)
values (4, 'D', 0, 1199)