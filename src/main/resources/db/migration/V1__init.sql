CREATE TABLE quest_base
(
    quest_baseid    BIGINT NOT NULL,
    disciplineid    BIGINT NOT NULL,
    quest_base_name TEXT   NOT NULL,
    CONSTRAINT pk_questbase PRIMARY KEY (quest_baseid)
);

CREATE TABLE quest_group
(
    quest_groupid    BIGINT NOT NULL,
    quest_baseid     BIGINT NOT NULL,
    quest_group_name TEXT   NOT NULL,
    CONSTRAINT pk_questgroup PRIMARY KEY (quest_groupid)
);

CREATE TABLE quest_type
(
    quest_typeid    BIGINT NOT NULL,
    quest_type_name TEXT   NOT NULL,
    CONSTRAINT pk_questtype PRIMARY KEY (quest_typeid)
);

CREATE TABLE students_group
(
    students_groupid    BIGINT NOT NULL,
    students_group_name TEXT   NOT NULL,
    CONSTRAINT pk_studentsgroup PRIMARY KEY (students_groupid)
);

CREATE TABLE test_quests
(
    test_questsid BIGINT NOT NULL,
    questionid    BIGINT NOT NULL,
    testid        BIGINT NOT NULL,
    CONSTRAINT pk_testquests PRIMARY KEY (test_questsid)
);

CREATE TABLE test_result
(
    test_resultid             BIGINT NOT NULL,
    correct_percent           TEXT,
    skipped_percent           TEXT,
    testid                    BIGINT NOT NULL,
    userid                    BIGINT NOT NULL,
    test_result_user_answerid BIGINT NOT NULL,
    CONSTRAINT pk_testresult PRIMARY KEY (test_resultid)
);

CREATE TABLE test_result_user_answer
(
    test_result_user_answerid BIGINT NOT NULL,
    user_answerid             BIGINT NOT NULL,
    test_resultid             BIGINT NOT NULL,
    CONSTRAINT pk_testresultuseranswer PRIMARY KEY (test_result_user_answerid)
);

CREATE TABLE user_answer
(
    user_answerid BIGINT  NOT NULL,
    questionid    BIGINT  NOT NULL,
    answerid      BIGINT  NOT NULL,
    user_answer   TEXT,
    timestamp     TIMESTAMP WITHOUT TIME ZONE,
    is_skipped    BOOLEAN NOT NULL,
    is_correct    BOOLEAN NOT NULL,
    CONSTRAINT pk_useranswer PRIMARY KEY (user_answerid)
);

ALTER TABLE answer
    ADD answer_value TEXT;

ALTER TABLE answer
    ADD is_right BOOLEAN;

ALTER TABLE answer
    ALTER COLUMN answer_value SET NOT NULL;

ALTER TABLE question
    ADD correct_comment TEXT;

ALTER TABLE question
    ADD incorrect_comment TEXT;

ALTER TABLE question
    ADD is_count BOOLEAN;

ALTER TABLE question
    ADD is_shuffle_answers BOOLEAN;

ALTER TABLE question
    ADD quest_groupid BIGINT;

ALTER TABLE question
    ADD quest_typeid BIGINT;

ALTER TABLE question
    ADD question_text TEXT;

ALTER TABLE discipline
    ADD discipline_name TEXT;

ALTER TABLE discipline
    ALTER COLUMN discipline_name SET NOT NULL;

ALTER TABLE "user"
    ADD full_name TEXT;

ALTER TABLE "user"
    ADD password_salt TEXT;

ALTER TABLE "user"
    ADD phone_number TEXT;

ALTER TABLE "user"
    ADD students_groupid BIGINT;

ALTER TABLE "user"
    ADD telegram_login TEXT;

ALTER TABLE "user"
    ALTER COLUMN full_name SET NOT NULL;

ALTER TABLE question
    ALTER COLUMN is_count SET NOT NULL;

ALTER TABLE answer
    ALTER COLUMN is_right SET NOT NULL;

ALTER TABLE question
    ALTER COLUMN is_shuffle_answers SET NOT NULL;

ALTER TABLE test
    ADD is_shuffle_questions BOOLEAN;

ALTER TABLE test
    ALTER COLUMN is_shuffle_questions SET NOT NULL;

ALTER TABLE question
    ALTER COLUMN quest_groupid SET NOT NULL;

ALTER TABLE question
    ALTER COLUMN quest_typeid SET NOT NULL;

ALTER TABLE question
    ALTER COLUMN question_text SET NOT NULL;

ALTER TABLE role
    ADD role_name TEXT;

ALTER TABLE role
    ALTER COLUMN role_name SET NOT NULL;

ALTER TABLE university
    ADD university_name TEXT;

ALTER TABLE university
    ALTER COLUMN university_name SET NOT NULL;

ALTER TABLE quest_base
    ADD CONSTRAINT FK_QUESTBASE_ON_DISCIPLINEID FOREIGN KEY (disciplineid) REFERENCES discipline (disciplineid);

ALTER TABLE quest_group
    ADD CONSTRAINT FK_QUESTGROUP_ON_QUESTBASEID FOREIGN KEY (quest_baseid) REFERENCES quest_base (quest_baseid);

ALTER TABLE question
    ADD CONSTRAINT FK_QUESTION_ON_QUESTGROUPID FOREIGN KEY (quest_groupid) REFERENCES quest_group (quest_groupid);

ALTER TABLE question
    ADD CONSTRAINT FK_QUESTION_ON_QUESTTYPEID FOREIGN KEY (quest_typeid) REFERENCES quest_type (quest_typeid);

ALTER TABLE test_quests
    ADD CONSTRAINT FK_TESTQUESTS_ON_QUESTIONID FOREIGN KEY (questionid) REFERENCES question (questionid);

ALTER TABLE test_quests
    ADD CONSTRAINT FK_TESTQUESTS_ON_TESTID FOREIGN KEY (testid) REFERENCES test (testid);

ALTER TABLE test_result_user_answer
    ADD CONSTRAINT FK_TESTRESULTUSERANSWER_ON_TESTRESULTID FOREIGN KEY (test_resultid) REFERENCES test_result (test_resultid);

ALTER TABLE test_result_user_answer
    ADD CONSTRAINT FK_TESTRESULTUSERANSWER_ON_USERANSWERID FOREIGN KEY (user_answerid) REFERENCES user_answer (user_answerid);

ALTER TABLE test_result
    ADD CONSTRAINT FK_TESTRESULT_ON_TESTID FOREIGN KEY (testid) REFERENCES test (testid);

ALTER TABLE test_result
    ADD CONSTRAINT FK_TESTRESULT_ON_TESTRESULTUSERANSWERID FOREIGN KEY (test_result_user_answerid) REFERENCES test_result_user_answer (test_result_user_answerid);

ALTER TABLE test_result
    ADD CONSTRAINT FK_TESTRESULT_ON_USERID FOREIGN KEY (userid) REFERENCES "user" (userid);

ALTER TABLE user_answer
    ADD CONSTRAINT FK_USERANSWER_ON_ANSWERID FOREIGN KEY (answerid) REFERENCES answer (answerid);

ALTER TABLE user_answer
    ADD CONSTRAINT FK_USERANSWER_ON_QUESTIONID FOREIGN KEY (questionid) REFERENCES question (questionid);

ALTER TABLE "user"
    ADD CONSTRAINT FK_USER_ON_STUDENTSGROUPID FOREIGN KEY (students_groupid) REFERENCES students_group (students_groupid);

ALTER TABLE UserAnswer
DROP
CONSTRAINT AnswerID;

ALTER TABLE QuestBase
DROP
CONSTRAINT DisciplineID;

ALTER TABLE QuestGroup
DROP
CONSTRAINT QuestBaseID;

ALTER TABLE Question
DROP
CONSTRAINT QuestGroupID;

ALTER TABLE Question
DROP
CONSTRAINT QuestTypeID;

ALTER TABLE UserAnswer
DROP
CONSTRAINT QuestionID;

ALTER TABLE UserAnswer
DROP
CONSTRAINT QuestionID;

ALTER TABLE "User"
DROP
CONSTRAINT StudentsGroupID;

ALTER TABLE TestResult
DROP
CONSTRAINT TestID;

ALTER TABLE TestResult
DROP
CONSTRAINT TestID;

ALTER TABLE TestResultUserAnswer
DROP
CONSTRAINT TestResultID;

ALTER TABLE TestResult
DROP
CONSTRAINT TestResultUserAnswerID;

ALTER TABLE TestResultUserAnswer
DROP
CONSTRAINT UserAnswerID;

ALTER TABLE TestResult
DROP
CONSTRAINT UserID;

DROP TABLE QuestBase CASCADE;

DROP TABLE QuestGroup CASCADE;

DROP TABLE QuestType CASCADE;

DROP TABLE StudentsGroup CASCADE;

DROP TABLE TestQuests CASCADE;

DROP TABLE TestResult CASCADE;

DROP TABLE TestResultUserAnswer CASCADE;

DROP TABLE UserAnswer CASCADE;

ALTER TABLE Answer
DROP
COLUMN AnswerValue;

ALTER TABLE Answer
DROP
COLUMN IsRight;

ALTER TABLE Question
DROP
COLUMN CorrectComment;

ALTER TABLE Question
DROP
COLUMN IncorrectComment;

ALTER TABLE Question
DROP
COLUMN IsCount;

ALTER TABLE Question
DROP
COLUMN IsShuffleAnswers;

ALTER TABLE Question
DROP
COLUMN QuestGroupID;

ALTER TABLE Question
DROP
COLUMN QuestTypeID;

ALTER TABLE Question
DROP
COLUMN QuestionText;

ALTER TABLE Discipline
DROP
COLUMN DisciplineName;

ALTER TABLE "User"
DROP
COLUMN FullName;

ALTER TABLE "User"
DROP
COLUMN PasswordSalt;

ALTER TABLE "User"
DROP
COLUMN PhoneNumber;

ALTER TABLE "User"
DROP
COLUMN StudentsGroupID;

ALTER TABLE "User"
DROP
COLUMN TelegramLogin;

ALTER TABLE Test
DROP
COLUMN IsShuffleQuestions;

ALTER TABLE Role
DROP
COLUMN RoleName;

ALTER TABLE University
DROP
COLUMN UniversityName;