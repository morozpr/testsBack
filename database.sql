--
-- PostgreSQL database dump
--

-- Dumped from database version 14.9
-- Dumped by pg_dump version 15.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

-- *not* creating schema, since initdb creates it


ALTER SCHEMA public OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: answer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.answer (
    "AnswerID" bigint NOT NULL,
    "AnswerValue" text NOT NULL,
    "IsRight" boolean NOT NULL,
    "QuestionID" bigint NOT NULL
);


ALTER TABLE public.answer OWNER TO postgres;

--
-- Name: answer_AnswerID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."answer_AnswerID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."answer_AnswerID_seq" OWNER TO postgres;

--
-- Name: answer_AnswerID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."answer_AnswerID_seq" OWNED BY public.answer."AnswerID";


--
-- Name: discipline; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.discipline (
    "DisciplineID" bigint NOT NULL,
    "DisciplineName" text NOT NULL
);


ALTER TABLE public.discipline OWNER TO postgres;

--
-- Name: discipline_DisciplineID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."discipline_DisciplineID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."discipline_DisciplineID_seq" OWNER TO postgres;

--
-- Name: discipline_DisciplineID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."discipline_DisciplineID_seq" OWNED BY public.discipline."DisciplineID";


--
-- Name: flyway_schema_history; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.flyway_schema_history (
    installed_rank integer NOT NULL,
    version character varying(50),
    description character varying(200) NOT NULL,
    type character varying(20) NOT NULL,
    script character varying(1000) NOT NULL,
    checksum integer,
    installed_by character varying(100) NOT NULL,
    installed_on timestamp without time zone DEFAULT now() NOT NULL,
    execution_time integer NOT NULL,
    success boolean NOT NULL
);


ALTER TABLE public.flyway_schema_history OWNER TO postgres;

--
-- Name: questBaseService; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."questBaseService" (
    "QuestBaseID" bigint NOT NULL,
    "QuestBaseName" text NOT NULL,
    "DisciplineID" bigint NOT NULL
);


ALTER TABLE public."questBaseService" OWNER TO postgres;

--
-- Name: questBaseService_QuestBaseID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."questBaseService_QuestBaseID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."questBaseService_QuestBaseID_seq" OWNER TO postgres;

--
-- Name: questBaseService_QuestBaseID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."questBaseService_QuestBaseID_seq" OWNED BY public."questBaseService"."QuestBaseID";


--
-- Name: questGroup; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."questGroup" (
    "QuestGroupID" bigint NOT NULL,
    "QuestGroupName" text NOT NULL,
    "QuestBaseID" bigint NOT NULL
);


ALTER TABLE public."questGroup" OWNER TO postgres;

--
-- Name: questGroup_QuestGroupID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."questGroup_QuestGroupID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."questGroup_QuestGroupID_seq" OWNER TO postgres;

--
-- Name: questGroup_QuestGroupID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."questGroup_QuestGroupID_seq" OWNED BY public."questGroup"."QuestGroupID";


--
-- Name: questType; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."questType" (
    "QuestTypeID" bigint NOT NULL,
    "QuestTypeName" text NOT NULL
);


ALTER TABLE public."questType" OWNER TO postgres;

--
-- Name: questType_QuestTypeID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."questType_QuestTypeID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."questType_QuestTypeID_seq" OWNER TO postgres;

--
-- Name: questType_QuestTypeID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."questType_QuestTypeID_seq" OWNED BY public."questType"."QuestTypeID";


--
-- Name: question; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.question (
    "QuestionID" bigint NOT NULL,
    "CorrectComment" text,
    "IncorrectComment" text,
    "IsCount" boolean NOT NULL,
    "IsShuffleAnswers" boolean NOT NULL,
    "QuestionText" text NOT NULL,
    "Score" real NOT NULL,
    "QuestGroupID" bigint NOT NULL,
    "QuestTypeID" bigint NOT NULL
);


ALTER TABLE public.question OWNER TO postgres;

--
-- Name: question_QuestionID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."question_QuestionID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."question_QuestionID_seq" OWNER TO postgres;

--
-- Name: question_QuestionID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."question_QuestionID_seq" OWNED BY public.question."QuestionID";


--
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    "RoleID" bigint NOT NULL,
    "RoleName" text NOT NULL
);


ALTER TABLE public.role OWNER TO postgres;

--
-- Name: role_RoleID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."role_RoleID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."role_RoleID_seq" OWNER TO postgres;

--
-- Name: role_RoleID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."role_RoleID_seq" OWNED BY public.role."RoleID";


--
-- Name: studentsGroup; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."studentsGroup" (
    "StudentsGroupID" bigint NOT NULL,
    "StudentsGroupName" text NOT NULL
);


ALTER TABLE public."studentsGroup" OWNER TO postgres;

--
-- Name: studentsGroup_StudentsGroupID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."studentsGroup_StudentsGroupID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."studentsGroup_StudentsGroupID_seq" OWNER TO postgres;

--
-- Name: studentsGroup_StudentsGroupID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."studentsGroup_StudentsGroupID_seq" OWNED BY public."studentsGroup"."StudentsGroupID";


--
-- Name: test; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.test (
    "TestID" bigint NOT NULL,
    "Description" text,
    "IsShuffleQuestions" boolean NOT NULL,
    "Link" text,
    "Name" text NOT NULL,
    "DisciplineID" bigint
);


ALTER TABLE public.test OWNER TO postgres;

--
-- Name: testQuests; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."testQuests" (
    "TestQuestsID" bigint NOT NULL,
    "QuestionID" bigint NOT NULL,
    "TestID" bigint NOT NULL
);


ALTER TABLE public."testQuests" OWNER TO postgres;

--
-- Name: testQuests_TestQuestsID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."testQuests_TestQuestsID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."testQuests_TestQuestsID_seq" OWNER TO postgres;

--
-- Name: testQuests_TestQuestsID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."testQuests_TestQuestsID_seq" OWNED BY public."testQuests"."TestQuestsID";


--
-- Name: testResult; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."testResult" (
    "TestResultID" bigint NOT NULL,
    "CorrectPercent" text,
    "SkippedPercent" text,
    "TestID" bigint NOT NULL,
    "UserID" bigint NOT NULL
);


ALTER TABLE public."testResult" OWNER TO postgres;

--
-- Name: testResultUserAnswerService; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."testResultUserAnswerService" (
    "TestResultUserAnswerID" bigint NOT NULL,
    "TestResultID" bigint NOT NULL,
    "UserAnswerID" bigint NOT NULL
);


ALTER TABLE public."testResultUserAnswerService" OWNER TO postgres;

--
-- Name: testResultUserAnswerService_TestResultUserAnswerID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."testResultUserAnswerService_TestResultUserAnswerID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."testResultUserAnswerService_TestResultUserAnswerID_seq" OWNER TO postgres;

--
-- Name: testResultUserAnswerService_TestResultUserAnswerID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."testResultUserAnswerService_TestResultUserAnswerID_seq" OWNED BY public."testResultUserAnswerService"."TestResultUserAnswerID";


--
-- Name: testResult_TestResultID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."testResult_TestResultID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."testResult_TestResultID_seq" OWNER TO postgres;

--
-- Name: testResult_TestResultID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."testResult_TestResultID_seq" OWNED BY public."testResult"."TestResultID";


--
-- Name: test_TestID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."test_TestID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."test_TestID_seq" OWNER TO postgres;

--
-- Name: test_TestID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."test_TestID_seq" OWNED BY public.test."TestID";


--
-- Name: university; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.university (
    "UniversityID" bigint NOT NULL,
    "UniversityName" text NOT NULL
);


ALTER TABLE public.university OWNER TO postgres;

--
-- Name: university_UniversityID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."university_UniversityID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."university_UniversityID_seq" OWNER TO postgres;

--
-- Name: university_UniversityID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."university_UniversityID_seq" OWNED BY public.university."UniversityID";


--
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
    "UserID" bigint NOT NULL,
    "Email" text,
    "FullName" text NOT NULL,
    "Password" text,
    "PasswordSalt" text,
    "PhoneNumber" text,
    "TelegramID" text,
    "TelegramLogin" text,
    "RoleID" bigint NOT NULL,
    "StudentsGroupID" bigint,
    "UniversityID" bigint
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- Name: userAnswer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."userAnswer" (
    "UserAnswerID" bigint NOT NULL,
    "IsCorrect" boolean NOT NULL,
    "IsSkipped" boolean NOT NULL,
    "Timestamp" timestamp(6) with time zone,
    "UserAnswer" text,
    "AnswerID" bigint NOT NULL,
    "QuestionID" bigint NOT NULL
);


ALTER TABLE public."userAnswer" OWNER TO postgres;

--
-- Name: userAnswer_UserAnswerID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."userAnswer_UserAnswerID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."userAnswer_UserAnswerID_seq" OWNER TO postgres;

--
-- Name: userAnswer_UserAnswerID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."userAnswer_UserAnswerID_seq" OWNED BY public."userAnswer"."UserAnswerID";


--
-- Name: user_UserID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."user_UserID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."user_UserID_seq" OWNER TO postgres;

--
-- Name: user_UserID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."user_UserID_seq" OWNED BY public."user"."UserID";


--
-- Name: answer AnswerID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.answer ALTER COLUMN "AnswerID" SET DEFAULT nextval('public."answer_AnswerID_seq"'::regclass);


--
-- Name: discipline DisciplineID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline ALTER COLUMN "DisciplineID" SET DEFAULT nextval('public."discipline_DisciplineID_seq"'::regclass);


--
-- Name: questBaseService QuestBaseID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."questBaseService" ALTER COLUMN "QuestBaseID" SET DEFAULT nextval('public."questBaseService_QuestBaseID_seq"'::regclass);


--
-- Name: questGroup QuestGroupID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."questGroup" ALTER COLUMN "QuestGroupID" SET DEFAULT nextval('public."questGroup_QuestGroupID_seq"'::regclass);


--
-- Name: questType QuestTypeID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."questType" ALTER COLUMN "QuestTypeID" SET DEFAULT nextval('public."questType_QuestTypeID_seq"'::regclass);


--
-- Name: question QuestionID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question ALTER COLUMN "QuestionID" SET DEFAULT nextval('public."question_QuestionID_seq"'::regclass);


--
-- Name: role RoleID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role ALTER COLUMN "RoleID" SET DEFAULT nextval('public."role_RoleID_seq"'::regclass);


--
-- Name: studentsGroup StudentsGroupID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."studentsGroup" ALTER COLUMN "StudentsGroupID" SET DEFAULT nextval('public."studentsGroup_StudentsGroupID_seq"'::regclass);


--
-- Name: test TestID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.test ALTER COLUMN "TestID" SET DEFAULT nextval('public."test_TestID_seq"'::regclass);


--
-- Name: testQuests TestQuestsID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."testQuests" ALTER COLUMN "TestQuestsID" SET DEFAULT nextval('public."testQuests_TestQuestsID_seq"'::regclass);


--
-- Name: testResult TestResultID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."testResult" ALTER COLUMN "TestResultID" SET DEFAULT nextval('public."testResult_TestResultID_seq"'::regclass);


--
-- Name: testResultUserAnswerService TestResultUserAnswerID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."testResultUserAnswerService" ALTER COLUMN "TestResultUserAnswerID" SET DEFAULT nextval('public."testResultUserAnswerService_TestResultUserAnswerID_seq"'::regclass);


--
-- Name: university UniversityID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.university ALTER COLUMN "UniversityID" SET DEFAULT nextval('public."university_UniversityID_seq"'::regclass);


--
-- Name: user UserID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user" ALTER COLUMN "UserID" SET DEFAULT nextval('public."user_UserID_seq"'::regclass);


--
-- Name: userAnswer UserAnswerID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."userAnswer" ALTER COLUMN "UserAnswerID" SET DEFAULT nextval('public."userAnswer_UserAnswerID_seq"'::regclass);


--
-- Data for Name: answer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.answer ("AnswerID", "AnswerValue", "IsRight", "QuestionID") FROM stdin;
1	1	t	1
\.


--
-- Data for Name: discipline; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.discipline ("DisciplineID", "DisciplineName") FROM stdin;
1	string
\.


--
-- Data for Name: flyway_schema_history; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) FROM stdin;
1	1	<< Flyway Baseline >>	BASELINE	<< Flyway Baseline >>	\N	postgres	2023-11-18 20:35:01.262094	0	t
\.


--
-- Data for Name: questBaseService; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."questBaseService" ("QuestBaseID", "QuestBaseName", "DisciplineID") FROM stdin;
1	test	1
\.


--
-- Data for Name: questGroup; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."questGroup" ("QuestGroupID", "QuestGroupName", "QuestBaseID") FROM stdin;
1	test	1
\.


--
-- Data for Name: questType; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."questType" ("QuestTypeID", "QuestTypeName") FROM stdin;
1	test
\.


--
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.question ("QuestionID", "CorrectComment", "IncorrectComment", "IsCount", "IsShuffleAnswers", "QuestionText", "Score", "QuestGroupID", "QuestTypeID") FROM stdin;
1	test	test	t	f	test	1.9	1	1
\.


--
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.role ("RoleID", "RoleName") FROM stdin;
1	ROLE_ADMIN
3	ROLE_SADMIN
4	ROLE_USER
\.


--
-- Data for Name: studentsGroup; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."studentsGroup" ("StudentsGroupID", "StudentsGroupName") FROM stdin;
1	test
\.


--
-- Data for Name: test; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.test ("TestID", "Description", "IsShuffleQuestions", "Link", "Name", "DisciplineID") FROM stdin;
1	testdesc	t	www.google.com	test	1
\.


--
-- Data for Name: testQuests; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."testQuests" ("TestQuestsID", "QuestionID", "TestID") FROM stdin;
1	1	1
\.


--
-- Data for Name: testResult; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."testResult" ("TestResultID", "CorrectPercent", "SkippedPercent", "TestID", "UserID") FROM stdin;
3	12	23	1	1
\.


--
-- Data for Name: testResultUserAnswerService; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."testResultUserAnswerService" ("TestResultUserAnswerID", "TestResultID", "UserAnswerID") FROM stdin;
5	3	1
\.


--
-- Data for Name: university; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.university ("UniversityID", "UniversityName") FROM stdin;
1	test
2	del
\.


--
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."user" ("UserID", "Email", "FullName", "Password", "PasswordSalt", "PhoneNumber", "TelegramID", "TelegramLogin", "RoleID", "StudentsGroupID", "UniversityID") FROM stdin;
3	admin@mail.com	da	{bcrypt}$2a$10$BEQLPKoaGppGTv2QBoPB/ewH42Wv9fBtvt93y.Kxu3hA3GSnskA8K	\N	\N	\N	\N	3	\N	\N
1	sadmin@mail.com	super admin	{bcrypt}$2a$12$4GMA7J5ET2zjnSa95nJGFu3JtIYFfoMqsutHcTBd4UceyrwqjBii2	s	\N	\N	\N	3	\N	\N
4	asdasd@bk.ru	asdasd	aa	$2a$10$.Jpxa/.AMp.t5Fs8h9moq.	\N	\N	\N	3	\N	\N
\.


--
-- Data for Name: userAnswer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."userAnswer" ("UserAnswerID", "IsCorrect", "IsSkipped", "Timestamp", "UserAnswer", "AnswerID", "QuestionID") FROM stdin;
1	t	f	\N	1	1	1
\.


--
-- Name: answer_AnswerID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."answer_AnswerID_seq"', 1, true);


--
-- Name: discipline_DisciplineID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."discipline_DisciplineID_seq"', 1, true);


--
-- Name: questBaseService_QuestBaseID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."questBaseService_QuestBaseID_seq"', 1, true);


--
-- Name: questGroup_QuestGroupID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."questGroup_QuestGroupID_seq"', 1, true);


--
-- Name: questType_QuestTypeID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."questType_QuestTypeID_seq"', 1, true);


--
-- Name: question_QuestionID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."question_QuestionID_seq"', 1, true);


--
-- Name: role_RoleID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."role_RoleID_seq"', 4, true);


--
-- Name: studentsGroup_StudentsGroupID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."studentsGroup_StudentsGroupID_seq"', 1, true);


--
-- Name: testQuests_TestQuestsID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."testQuests_TestQuestsID_seq"', 1, true);


--
-- Name: testResultUserAnswerService_TestResultUserAnswerID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."testResultUserAnswerService_TestResultUserAnswerID_seq"', 5, true);


--
-- Name: testResult_TestResultID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."testResult_TestResultID_seq"', 3, true);


--
-- Name: test_TestID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."test_TestID_seq"', 1, true);


--
-- Name: university_UniversityID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."university_UniversityID_seq"', 2, true);


--
-- Name: userAnswer_UserAnswerID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."userAnswer_UserAnswerID_seq"', 1, true);


--
-- Name: user_UserID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."user_UserID_seq"', 4, true);


--
-- Name: answer answer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.answer
    ADD CONSTRAINT answer_pkey PRIMARY KEY ("AnswerID");


--
-- Name: discipline discipline_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline
    ADD CONSTRAINT discipline_pkey PRIMARY KEY ("DisciplineID");


--
-- Name: flyway_schema_history flyway_schema_history_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.flyway_schema_history
    ADD CONSTRAINT flyway_schema_history_pk PRIMARY KEY (installed_rank);


--
-- Name: questBaseService questBaseService_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."questBaseService"
    ADD CONSTRAINT "questBaseService_pkey" PRIMARY KEY ("QuestBaseID");


--
-- Name: questGroup questGroup_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."questGroup"
    ADD CONSTRAINT "questGroup_pkey" PRIMARY KEY ("QuestGroupID");


--
-- Name: questType questType_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."questType"
    ADD CONSTRAINT "questType_pkey" PRIMARY KEY ("QuestTypeID");


--
-- Name: question question_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT question_pkey PRIMARY KEY ("QuestionID");


--
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY ("RoleID");


--
-- Name: studentsGroup studentsGroup_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."studentsGroup"
    ADD CONSTRAINT "studentsGroup_pkey" PRIMARY KEY ("StudentsGroupID");


--
-- Name: testQuests testQuests_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."testQuests"
    ADD CONSTRAINT "testQuests_pkey" PRIMARY KEY ("TestQuestsID");


--
-- Name: testResultUserAnswerService testResultUserAnswerService_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."testResultUserAnswerService"
    ADD CONSTRAINT "testResultUserAnswerService_pkey" PRIMARY KEY ("TestResultUserAnswerID");


--
-- Name: testResult testResult_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."testResult"
    ADD CONSTRAINT "testResult_pkey" PRIMARY KEY ("TestResultID");


--
-- Name: test test_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.test
    ADD CONSTRAINT test_pkey PRIMARY KEY ("TestID");


--
-- Name: university university_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.university
    ADD CONSTRAINT university_pkey PRIMARY KEY ("UniversityID");


--
-- Name: userAnswer userAnswer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."userAnswer"
    ADD CONSTRAINT "userAnswer_pkey" PRIMARY KEY ("UserAnswerID");


--
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY ("UserID");


--
-- Name: flyway_schema_history_s_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX flyway_schema_history_s_idx ON public.flyway_schema_history USING btree (success);


--
-- Name: testQuests fk1kvfuhjtyr5qj5967bhcj307v; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."testQuests"
    ADD CONSTRAINT fk1kvfuhjtyr5qj5967bhcj307v FOREIGN KEY ("TestID") REFERENCES public.test("TestID");


--
-- Name: questGroup fk1tukr7g3gsqfq3j5i3p700y62; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."questGroup"
    ADD CONSTRAINT fk1tukr7g3gsqfq3j5i3p700y62 FOREIGN KEY ("QuestBaseID") REFERENCES public."questBaseService"("QuestBaseID");


--
-- Name: userAnswer fk4vajtdee4uvqaya9uj76hajqf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."userAnswer"
    ADD CONSTRAINT fk4vajtdee4uvqaya9uj76hajqf FOREIGN KEY ("AnswerID") REFERENCES public.answer("AnswerID");


--
-- Name: userAnswer fk692xfyw72ge4076hc253xke9n; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."userAnswer"
    ADD CONSTRAINT fk692xfyw72ge4076hc253xke9n FOREIGN KEY ("QuestionID") REFERENCES public.question("QuestionID");


--
-- Name: question fk75bq1idh4c78i18231i5eycab; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT fk75bq1idh4c78i18231i5eycab FOREIGN KEY ("QuestGroupID") REFERENCES public."questGroup"("QuestGroupID");


--
-- Name: answer fk8aohnhrvn39ku8ytqwbmt79o1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.answer
    ADD CONSTRAINT fk8aohnhrvn39ku8ytqwbmt79o1 FOREIGN KEY ("QuestionID") REFERENCES public.question("QuestionID");


--
-- Name: testResultUserAnswerService fkc5gf14f8aujvrf5wcq2pc709j; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."testResultUserAnswerService"
    ADD CONSTRAINT fkc5gf14f8aujvrf5wcq2pc709j FOREIGN KEY ("UserAnswerID") REFERENCES public."userAnswer"("UserAnswerID");


--
-- Name: testResult fkcntsuu7c03fvcfh24ufqew2se; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."testResult"
    ADD CONSTRAINT fkcntsuu7c03fvcfh24ufqew2se FOREIGN KEY ("UserID") REFERENCES public."user"("UserID");


--
-- Name: user fkex6fcc1uranhmyrygecp2b5fw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT fkex6fcc1uranhmyrygecp2b5fw FOREIGN KEY ("RoleID") REFERENCES public.role("RoleID");


--
-- Name: testQuests fkfk9f1443aq7yotrgagw7wv59a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."testQuests"
    ADD CONSTRAINT fkfk9f1443aq7yotrgagw7wv59a FOREIGN KEY ("QuestionID") REFERENCES public.question("QuestionID");


--
-- Name: questBaseService fkh9tn3ks4rhwg1o7mrjbon2vvb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."questBaseService"
    ADD CONSTRAINT fkh9tn3ks4rhwg1o7mrjbon2vvb FOREIGN KEY ("DisciplineID") REFERENCES public.discipline("DisciplineID");


--
-- Name: question fkjd96qdo6aasu42iuyakuaxjgq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT fkjd96qdo6aasu42iuyakuaxjgq FOREIGN KEY ("QuestTypeID") REFERENCES public."questType"("QuestTypeID");


--
-- Name: user fkkrjvmwo4ny68nmyqd0jblr222; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT fkkrjvmwo4ny68nmyqd0jblr222 FOREIGN KEY ("StudentsGroupID") REFERENCES public."studentsGroup"("StudentsGroupID");


--
-- Name: user fklf176gqoddf39vedjlex6k6tp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT fklf176gqoddf39vedjlex6k6tp FOREIGN KEY ("UniversityID") REFERENCES public.university("UniversityID");


--
-- Name: testResult fkmqs39c5e3h0g9f10ecga5sjbs; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."testResult"
    ADD CONSTRAINT fkmqs39c5e3h0g9f10ecga5sjbs FOREIGN KEY ("TestID") REFERENCES public.test("TestID");


--
-- Name: testResultUserAnswerService fkpdxuh4gssjna3th8by3fs7hu2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."testResultUserAnswerService"
    ADD CONSTRAINT fkpdxuh4gssjna3th8by3fs7hu2 FOREIGN KEY ("TestResultID") REFERENCES public."testResult"("TestResultID");


--
-- Name: test fksor8x91wn8c24k4a7a795bcn1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.test
    ADD CONSTRAINT fksor8x91wn8c24k4a7a795bcn1 FOREIGN KEY ("DisciplineID") REFERENCES public.discipline("DisciplineID");


--
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

