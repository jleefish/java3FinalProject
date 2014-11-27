create table CarType ( Id int primary key not null auto_increment, 
            ShortName char(12) UNIQUE NOT NULL,
            WeekdayRate decimal(9,2) DEFAULT '0.00' NOT NULL,
            WeekendRate decimal(9,2) DEFAULT '0.00' NOT NULL,
            WeeklyRate decimal(9,2) DEFAULT '0.00' not NULL
         ); 

insert into CarType (ShortName,WeekdayRate,WeekendRate,WeeklyRate)
          values ('economy',35.00,30.00,25);

insert into CarType (ShortName,WeekdayRate,WeekendRate,WeeklyRate)
          values ('standard',40.00,35,30);

insert into CarType (ShortName,WeekdayRate,WeekendRate,WeeklyRate)
          values ('luxury',60,50,40);

insert into CarType (ShortName,WeekdayRate,WeekendRate,WeeklyRate)
          values ('minivan',45.00,38,32);

insert into CarType (ShortName,WeekdayRate,WeekendRate,WeeklyRate)
          values ('hybrid',40.00,37,31);

create table Customer(
CustomerId      varchar(3),
LastName  varchar(20),
Firstname varchar(20)
);

insert into Customer(CustomerId,LastName,FirstName)
      values ('104','Pascal','Marie');

insert into Customer(CustomerId,LastName,FirstName)
      values ('106','Curie','Marie');

insert into Customer(CustomerId,LastName,FirstName)
      values ('108','Einstein','Albert');

insert into Customer(CustomerId,LastName,FirstName)
      values ('109','Newton','Isaac');

insert into Customer(CustomerId,LastName,FirstName)
      values ('131','Gassendi','Pierre');

insert into Customer(CustomerId,LastName,FirstName)
      values ('132','Ohm','George');

insert into Customer(CustomerId,LastName,FirstName)
      values ('133','Fleming','Alexander');

insert into Customer(CustomerId,LastName,FirstName)
      values ('181','Franklin','Rosalind');

create table Employee(
UserName     varchar(16),
Status       varchar(16)
);

insert into Employee(UserName,Status)
      values ('Joe','manager');

insert into Employee(UserName,Status)
      values ('Joan','manager');

insert into Employee(UserName,Status)
      values ('Freda','clerk');

insert into Employee(UserName,Status)
      values ('Johnson','clerk');

create table Discount(
CarType     varchar(16),
Amount decimal(5,2) DEFAULT '0.0' not NULL 
);
