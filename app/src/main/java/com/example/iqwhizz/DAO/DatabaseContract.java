package com.example.iqwhizz.DAO;

import android.provider.BaseColumns;

public final class DatabaseContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private DatabaseContract() {
    }

    /* Inner class that defines the table contents */
    public static class Users implements BaseColumns {
        public static final String TABLE_NAME = "Users";
        public static final String username = "username";
    }

    public static class Friendship implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }

    public static class Tests implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }

    public static class TestExecutions implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }

    public static class TestQuestions implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }

    public static class SelectedAnswers implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }

    public static class Questions implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }

    public static class PossibleAnswers implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }
    public static class Challenges implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }
    public static String getSQLfile(int i) {
        String[] SQLfiles = {
                "PRAGMA foreign_keys = ON;\n" +
                        "create table Users \n" +
                        "(\n" +
                        "  username              text        not null primary key,\n" +
                        "  password              text        not null,\n" +
                        "  language              text        not null default 'en',\n" +
                        "  birth_date            integer     not null,\n" +
                        "  mail                  text        not null unique,\n" +
                        "  registration_date     integer     not null,\n" +
                        "  last_connection       integer     not null default current_timestamp,\n" +
                        "  profile_picture       blob\n" +
                        ");\n" +
                        "create table Friendship \n" +
                        "(\n" +
                        "  sender            text       not null references Users(username),\n" +
                        "  receiver          text       not null references Users(username),\n" +
                        "  request_date      integer    not null default current_timestamp,\n" +
                        "  unique (sender, receiver)\n" +
                        ");\n" +
                        "create table Tests \n" +
                        "(\n" +
                        "  testID    integer     primary key,\n" +
                        "  type      text        not null\n" +
                        ");\n" +
                        "create table TestExecutions \n" +
                        "(\n" +
                        "  testExecutionID   integer     primary key,\n" +
                        "  testID            integer     not null references Tests,\n" +
                        "  username          text        not null references Users,\n" +
                        "  executionDate     integer     not null,\n" +
                        "  unique (testID, username)\n" +
                        ");\n" +
                        "create table TestQuestions \n" +
                        "(\n" +
                        "  testID          integer       not null references Tests,\n" +
                        "  questionID      integer       not null references Questions,\n" +
                        "  primary key (testID, questionID)\n" +
                        ");\n" +
                        "create table SelectedAnswers \n" +
                        "(\n" +
                        "  testExecutionID integer       not null,\n" +
                        "  testID          integer       not null,\n" +
                        "  questionID      integer       not null,\n" +
                        "  answerID        integer       not null,\n" +
                        "  time            integer       not null,\n" +
                        "  unique (testExecutionID, testID, questionID),\n" +
                        "  foreign key (testExecutionID) references TestExecutions,\n" +
                        "  foreign key (testID, questionID) references TestQuestions,\n" +
                        "  foreign key (answerID) references PossibleAnswers\n" +
                        ");\n" +
                        "create table Questions \n" +
                        "(\n" +
                        "  questionID integer       primary key,\n" +
                        "  difficulty integer       not null,\n" +
                        "  category   text          not null,\n" +
                        "  image      blob,\n" +
                        "  text       text          not null\n" +
                        ");\n" +
                        "create table PossibleAnswers\n" +
                        "(\n" +
                        "  answerID   integer       primary key,\n" +
                        "  questionID integer       not null references Questions,\n" +
                        "  score      integer       not null default 0,\n" +
                        "  image      blob,\n" +
                        "  text       text          not null\n" +
                        ");\n" +
                        "create table Challenges\n" +
                        "(\n" +
                        "  user1  text         not null references Users,\n" +
                        "  user2  text         not null references Users,\n" +
                        "  testID integer      not null references Tests,\n" +
                        "  done   integer      not null default 0,\n" +
                        "  primary key (user1, user2, testID, done)\n" +
                        ");",
                "insert into Users values ('Arthur', 'password', 'fr', strftime('%s','1999-01-01'),\n" +
                        "'mail@mail.be',strftime('%s','2019-02-18'),strftime('%s','now'), 'image.png');\n" +
                        "\n" +
                        "insert into Users values ('Arnaud', '1234', 'ch', strftime('%s','1998-01-01'),\n" +
                        "'arnaudleheros@jesuisleplusfort.be',strftime('%s','2019-02-18'), strftime('%s','now'),'achanger.png');\n" +
                        "\n" +
                        "insert into Users values ('Hadrien', 'lutinPlop', 'fr', strftime('%s','1999-08-16'),\n" +
                        "'hl@uclouvain.be',strftime('%s','2019-02-25'), strftime('%s','now'),'hadrien.png');\n" +
                        "\n" +
                        "insert into Users values ('Simon', 'machin3654', 'fr', strftime('%s','1999-05-03'),\n" +
                        "'Simonleplusfort@gmail.be',strftime('%s','2019-02-25'), strftime('%s','now'),'simon.png');\n" +
                        "\n" +
                        "insert into Users values ('Maxime', 'vache', 'nl', strftime('%s','1999-06-08'),\n" +
                        "'maxime@hotmail.com',strftime('%s','2019-02-25'), strftime('%s','now'),'maxime.png');\n" +
                        "\n" +
                        "insert into Users values ('Florent', 'Coucou', 'fr', strftime('%s','1999-01-01'),\n" +
                        "'florent@telenet.be',strftime('%s','2019-02-25'), strftime('%s','now'),'florent.png');\n" +
                        "\n" +
                        "\n" +
                        "insert into Tests values (1, 'court');\n" +
                        "insert into Tests values (2, 'court');\n" +
                        "insert into Tests values (3, 'standard');\n" +
                        "insert into Tests values (4, 'court');\n" +
                        "insert into Tests values (5, 'standard');\n" +
                        "insert into Tests values (6, 'court');\n" +
                        "\n" +
                        "insert into Questions values (1, 1, 'Logique', 'img1.png', 'testez ...');\n" +
                        "insert into Questions values (2, 1, 'Logique', 'img2.png', 'trouvez ...');\n" +
                        "insert into Questions values (3, 1, 'Logique', 'img3.png', 'choisir ...');\n" +
                        "insert into Questions values (4, 3, 'Reflexion', 'img4.png', 'priez ...');\n" +
                        "insert into Questions values (5, 2, 'Reflexion', 'img5.png', 'trouvez ...');\n" +
                        "insert into Questions values (6, 3, 'Calcul mental', 'img6.png', 'choisir ...');\n" +
                        "insert into Questions(difficulty, category, image, text) values (4,'Reflexion','img7.png', 'bla bla bla');\n" +
                        "insert into Questions(difficulty, category, image, text) values (2,'Logique','img8.png', 'bla bla bla');\n" +
                        "insert into Questions(difficulty, category, image, text) values (1,'Calcul mental','img9.png', 'bla bla bla');\n" +
                        "insert into Questions(difficulty, category, image, text) values (3,'Logique','img10.png', 'bla bla bla');\n" +
                        "insert into Questions(difficulty, category, image, text) values (2,'Logique','img11.png', 'bla bla bla');\n" +
                        "insert into Questions(difficulty, category, image, text) values (1,'Reflexion','img12.png', 'bla bla bla');\n" +
                        "insert into Questions(difficulty, category, image, text) values (3,'Reflexion','img13.png', 'bla bla bla');\n" +
                        "\n" +
                        "\n" +
                        "insert into PossibleAnswers values (1, 1, 100, 'img1.png', 'Rép a');\n" +
                        "insert into PossibleAnswers values (2, 1, 0, 'img2.png', 'Rép b');\n" +
                        "insert into PossibleAnswers values (3, 1, 0, 'img3.png', 'Rép c');\n" +
                        "insert into PossibleAnswers values (4, 2, 0, 'img4.png', 'A');\n" +
                        "insert into PossibleAnswers values (5, 2, 100, 'img5.png', 'B');\n" +
                        "insert into PossibleAnswers values (6, 3, 0, NULL, '12');\n" +
                        "insert into PossibleAnswers values (7, 5, 0, NULL, '12');\n" +
                        "\n" +
                        "insert into PossibleAnswers values (8, 3, 0, NULL, '12');\n" +
                        "insert into PossibleAnswers values (9, 4, 0, NULL, '12');\n" +
                        "\n" +
                        "\n" +
                        "insert into TestQuestions values (1, 1);\n" +
                        "insert into TestQuestions values (1, 2);\n" +
                        "insert into TestQuestions values (1, 3);\n" +
                        "insert into TestQuestions values (1, 4);\n" +
                        "insert into TestQuestions values (1, 5);\n" +
                        "\n" +
                        "insert into TestQuestions values (2, 1);\n" +
                        "insert into TestQuestions values (3, 3);\n" +
                        "insert into TestQuestions values (2, 3);\n" +
                        "insert into TestQuestions values (4, 5);\n" +
                        "insert into TestQuestions values (2, 5);\n" +
                        "\n" +
                        "insert into TestExecutions values (1, 1, 'Hadrien', strftime('%s', '2019-02-28'));\n" +
                        "insert into TestExecutions values (2, 1,'Florent', strftime('%s', '2019-02-28'));\n" +
                        "insert into TestExecutions values (3, 2, 'Arthur', strftime('%s', '2019-02-18'));\n" +
                        "insert into TestExecutions values (4, 3, 'Arthur', strftime('%s', '2019-02-18'));\n" +
                        "insert into TestExecutions values (5, 4, 'Simon', strftime('%s', '2019-02-08'));\n" +
                        "insert into TestExecutions values (6, 5, 'Hadrien', strftime('%s', '2019-03-01'));\n" +
                        "\n" +
                        "insert into Challenges values ('Hadrien', 'Arthur', 1, 0);\n" +
                        "insert into Challenges values ('Florent', 'Arthur', 3, 0);\n" +
                        "insert into Challenges values ('Simon', 'Hadrien', 2, 0);\n" +
                        "insert into Challenges values ('Hadrien', 'Simon', 6, 1);\n" +
                        "insert into Challenges values ('Arnaud', 'Maxime', 5, 0);\n" +
                        "insert into Challenges values ('Maxime', 'Simon', 1, 1);\n" +
                        "\n" +
                        "insert into Friendship values ('Hadrien', 'Arthur', strftime('%s','now'));\n" +
                        "insert into Friendship values ('Florent', 'Arthur', strftime('%s','now'));\n" +
                        "insert into Friendship values ('Hadrien', 'Florent', strftime('%s','now'));\n" +
                        "insert into Friendship values ('Simon', 'Arthur', strftime('%s','now'));\n" +
                        "insert into Friendship values ('Hadrien', 'Arnaud', strftime('%s','now'));\n" +
                        "insert into Friendship values ('Arnaud', 'Florent', strftime('%s','now'));\n" +
                        "\n" +
                        "insert into SelectedAnswers values (1, 1, 1, 3, 120);\n" +
                        "insert into SelectedAnswers values (1, 1, 2, 5, 60);\n" +
                        "insert into SelectedAnswers values (1, 1, 3, 8, 120);\n" +
                        "insert into SelectedAnswers values (1, 1, 4, 9, 60);\n" +
                        "\n" +
                        "insert into SelectedAnswers values (2, 1, 2, 5, 30);\n" +
                        "insert into SelectedAnswers values (4, 3, 3, 6, 20);\n" +
                        "insert into SelectedAnswers values (5, 4, 5, 7, 20);\n" +
                        "insert into SelectedAnswers values (3, 2, 1, 2, 5);\n",
                "DROP TABLE IF EXISTS SelectedAnswers;\n" +
                        "\n" +
                        "\n" +
                        "DROP TABLE IF EXISTS Friendship;\n" +
                        "\n" +
                        "DROP TABLE IF EXISTS TestExecutions;\n" +
                        "\n" +
                        "DROP TABLE IF EXISTS TestQuestions;\n" +
                        "\n" +
                        "DROP TABLE IF EXISTS PossibleAnswers;\n" +
                        "\n" +
                        "DROP TABLE IF EXISTS Challenges\n" +
                        "\n" +
                        "\n" +
                        "DROP TABLE IF EXISTS Questions;\n" +
                        "\n" +
                        "DROP TABLE IF EXISTS Tests;\n" +
                        "\n" +
                        "DROP TABLE IF EXISTS Users;"
        };
        return SQLfiles[i];
    }
}
