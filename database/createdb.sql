create table User(
        UserID INT NOT NULL AUTO_INCREMENT,
        FirstName VARCHAR(100) NOT NULL,
        LastName VARCHAR(100) NOT NULL,
        CompanyName VARCHAR(100),
        PRIMARY KEY (UserID)
);


create table Email(
        EmailID INT NOT NULL AUTO_INCREMENT,
        UserID INT NOT NULL AUTO_INCREMENT,
        EmailAddress VARCHAR(100) NOT NULL,
        PRIMARY KEY (EmailID),
        FOREIGN KEY (UserID) REFERENCES 
        User (UserID)
);


create table Address(
        AddressID INT NOT NULL AUTO_INCREMENT,
        UserID INT NOT NULL AUTO_INCREMENT,
        Address1 VARCHAR(100) NOT NULL,
        Address2 VARCHAR(100) NOT NULL,
        City VARCHAR(40) NOT NULL,
        State VARCHAR(40) NOT NULL,
        Zip INT,
        Country VARCHAR(40) NOT NULL,
        PRIMARY KEY (AddressID),
        FOREIGN KEY (UserID) REFERENCES User (UserID)
);


create table Invoice(
        InvoiceID INT NOT NULL AUTO_INCREMENT,
        UserID INT NOT NULL AUTO_INCREMENT,
        InvoiceDate DATE NOT NULL,
        TotalAmount INT NOT NULL,
        IsProcessed VARCHAR(40) NOT NULL,
        PRIMARY KEY (InvoiceID),
        FOREIGN KEY (UserID) REFERENCES User ( UserID )
);


create LineItem(
        LineItemID INT NOT NULL AUTO_INCREMENT,
        InvoiceID INT NOT NULL AUTO_INCREMENT,
        BookID INT NOT NULL AUTO_INCREMENT,
        Quantity INT NOT NULL,
        PRIMARY KEY (LineItemID),
        FOREIGN KEY (InvoiceID) REFERENCES Invoice (InvoiceID),
        FOREIGN KEY (BookID) REFERENCES Book (BookID)
);


create table Author(
        AuthorID INT NOT NULL AUTO_INCREMENT,
        AuthorFirst VARCHAR(40) NOT NULL,
        AuthorLast VARCHAR(40) NOT NULL,
        PRIMARY Key (AuthorID)
);


create table Book(
        BookID INT NOT NULL AUTO_INCREMENT,
        ISBN INT NOT NULL,
        Title VARCHAR(100) NOT NULL,
        Editor VARCHAR(100) NOT NULL,
        Edition INT,
        Year INT NOT NULL,
        AuthorID INT NOT NULL AUTO_INCREMENT,
        PRIMARY KEY (BookID),
        FOREIGN KEY (AuthorID) REFERENCES Author (AuthorID)
);