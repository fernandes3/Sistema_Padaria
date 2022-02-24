-- SQL SERVER
CREATE DATABASE Bakehouse;

CREATE TABLE UnitsOfMeasurement(
    Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    Description NVARCHAR(100) NOT NULL
);

CREATE TABLE Categories(
    Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    Description NVARCHAR(100) NOT NULL
);

CREATE TABLE Products(
    Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    BarCode NVARCHAR(50) NULL UNIQUE,
    Description VARCHAR(100) NOT NULL,
    Quantity DECIMAL(10,2) NOT NULL,
    ValueUnitary DECIMAL(10,2) NOT NULL,
    MinQuantity INT NOT NULL,
    UnitOfMeasurementId INT NOT NULL,
    FOREIGN KEY(UnitOfMeasurementId) REFERENCES UnitsOfMeasurement(Id),
    CategoryId INT NOT NULL,
    FOREIGN KEY(CategoryId) REFERENCES Categories(Id)
);

CREATE TABLE Roles(
    Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    Description NVARCHAR(100) NOT NULL
);

CREATE TABLE Users(
    Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    Username NVARCHAR(100) NOT NULL UNIQUE,
    HashPassword NVARCHAR(150) NOT NULL,
    Status BIT NOT NULL,
    RoleId INT NOT NULL,
    FOREIGN KEY(RoleId) REFERENCES Roles(Id)
);

CREATE TABLE OrderPad(
    Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    DateHour DATETIME NOT NULL,
    UserId INT NOT NULL,
    FOREIGN KEY(UserId) REFERENCES Users(Id)
);

CREATE TABLE OrderPadItem(
    Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    Quantity INT NOT NULL,
    ValueUnitary DECIMAL(10,2) NOT NULL,
    ProductId INT NOT NULL,
    FOREIGN KEY(ProductId) REFERENCES Products(Id),
    OrderPadId INT NOT NULL,
    FOREIGN KEY(OrderPadId) REFERENCES OrderPad(Id)
);

CREATE TABLE Movement(
    Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    DateHour DATETIME NOT NULL,
    TotalValue DECIMAL(10,2) NOT NULL,
    Type CHAR(1) NOT NULL,
    Description NVARCHAR(300) NULL,
    UserId INT NOT NULL,
    FOREIGN KEY(UserId) REFERENCES Users(Id)
);