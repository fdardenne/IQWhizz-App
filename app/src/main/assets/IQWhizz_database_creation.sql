PRAGMA foreign_keys = ON;
create table Users
(
  username         char(25)  not null primary key,
  password         char(255) not null,
  language         char(2)   not null default 'en',
  birth_date       int       not null,
  mail             char(255) not null unique,
  registration_date int       not null,
  last_connection int not null default current_timestamp,
  profile_picture  char(255) -- normalement c'est un blob
);

create table Friendship
(
  sender char(25) not null references Users(username),
  receiver char(25) not null references Users(username),
  request_date int not null default current_timestamp,
  unique (sender, receiver)
);

create table Tests
(
  testID int      not null primary key,
  type   char(64) not null
);

create table TestExecutions
(
  testExecutionID int not null unique,
  testID          int not null references Tests,
  username          char(25) not null references Users,
  executionDate   int not null,
  primary key (testExecutionID, testID),
  unique (testID, username),
  unique (testExecutionID, username)
);

create table TestQuestions
(
  testID          int not null references Tests,
  questionID      int not null references Questions,
  primary key (testID, questionID)
);

create table SelectedAnswers
(
  testExecutionID int not null,
  testID          int not null,
  questionID      int not null,
  answerID        int not null,
  time            int not null,
  unique (testExecutionID, testID, questionID),
  foreign key (testExecutionID, testID) references TestExecutions,
  foreign key (testID, questionID) references TestQuestions,
  foreign key (answerID, questionID) references PossibleAnswers
);
-- unicite implique le fait q'une question ne peut etre posee qu'une seule pose par execution d'un test
-- la 1ere foreign key impose l'existence de cette execution avec ce test
-- la 2eme foreign key impose l'existence (et donc aussi l'unicite) de la paire question-test
-- la 3eme foreign key impose l'existence de la paire question reponse

create table Questions
(
  questionID int primary key,
  difficulty int       not null,
  category   char(64)  not null,
  image      blob,
  text       char(255) not null
);

create table PossibleAnswers
(
  answerID   int       not null,
  questionID int       not null references Questions,
  score      int       not null default 0,
  image      blob,
  text       char(255) not null,
  primary key (answerID, questionID)
);

create table Challenges
(
  user1  char(25) not null references Users,
  user2  char(25) not null references Users,
  testID int      not null references Tests,
  done   int      not null default 0,
  primary key (user1, user2, testID, done)
);
