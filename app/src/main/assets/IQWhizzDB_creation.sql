PRAGMA foreign_keys = ON;
create table Users
(
  username              text        not null primary key,
  password              text        not null,
  language              text        not null default 'en',
  birth_date            integer     not null,
  mail                  text        not null unique,
  registration_date     integer     not null,
  last_connection       integer     not null default current_timestamp,
  profile_picture       blob
);
create table Friendship
(
  sender            text       not null references Users(username),
  receiver          text       not null references Users(username),
  request_date      integer    not null default current_timestamp,
  unique (sender, receiver)
);
create table Tests
(
  testID    integer     primary key,
  type      text        not null
);
create table TestExecutions
(
  testExecutionID   integer     primary key,
  testID            integer     not null references Tests,
  username          text        not null references Users,
  executionDate     integer     not null,
  unique (testID, username)
);
create table TestQuestions
(
  testID          integer       not null references Tests,
  questionID      integer       not null references Questions,
  primary key (testID, questionID)
);
create table SelectedAnswers
(
  testExecutionID integer       not null,
  testID          integer       not null,
  questionID      integer       not null,
  answerID        integer       not null,
  time            integer       not null,
  unique (testExecutionID, testID, questionID),
  foreign key (testExecutionID) references TestExecutions,
  foreign key (testID, questionID) references TestQuestions,
  foreign key (answerID) references PossibleAnswers
);
create table Questions
(
  questionID integer       primary key,
  difficulty integer       not null,
  category   text          not null,
  image      blob,
  text       text          not null
);
create table PossibleAnswers
(
  answerID   integer       primary key,
  questionID integer       not null references Questions,
  score      integer       not null default 0,
  image      blob,
  text       text          not null
);
create table Challenges
(
  user1  text         not null references Users,
  user2  text         not null references Users,
  testID integer      not null references Tests,
  done   integer      not null default 0,
  primary key (user1, user2, testID, done)
);