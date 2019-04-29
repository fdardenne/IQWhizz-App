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
create table Friendships
(
  sender            text       not null references Users(username),
  receiver          text       not null references Users(username),
  request_date      integer    not null default current_timestamp,
  acceptance_date   integer    not null default 0,
  isAccepted        integer    not null default 0,
  unique (sender, receiver)
);
create table Tests
(
  testID    integer     primary key,
  type      text        not null
);
create table TestExecutions
(
  executionID       integer     primary key,
  testID            integer     not null references Tests,
  username          text        not null references Users,
  execution_date    integer     not null,
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
  executionID     integer       not null,
  testID          integer       not null,
  questionID      integer       not null,
  answerID        integer       not null,
  time            integer       not null,
  unique (executionID, testID, questionID),
  foreign key (executionID) references TestExecutions,
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
  sender  text         not null references Users,
  receiver  text         not null references Users,
  testID integer      not null references Tests,
  done   integer      not null default 0,
  primary key (user1, user2, testID, done)
);