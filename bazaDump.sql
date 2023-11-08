--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-11-08 09:44:37

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 214 (class 1259 OID 21083)
-- Name: igraci; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.igraci (
    igracid integer NOT NULL,
    datumrodjenja date,
    ime character varying(255),
    visina integer,
    brojdresa integer,
    prezime character varying(255),
    poenipoutakmici double precision,
    pozicija character varying(255),
    tezina integer,
    timid integer NOT NULL
);


ALTER TABLE public.igraci OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 21090)
-- Name: timovi; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.timovi (
    timid integer NOT NULL,
    grad character varying(255),
    porazi integer,
    nazivtima character varying(255),
    pobjede integer
);


ALTER TABLE public.timovi OWNER TO postgres;

--
-- TOC entry 3323 (class 0 OID 21083)
-- Dependencies: 214
-- Data for Name: igraci; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.igraci (igracid, datumrodjenja, ime, visina, brojdresa, prezime, poenipoutakmici, pozicija, tezina, timid) FROM stdin;
1	1984-12-30	LeBron	206	6	James	25	SF	113	1
2	1988-09-29	Kevin	208	7	Durant	27	SF	108	2
3	1988-03-14	Stephen	191	30	Curry	29.5	PG	85	5
4	1989-09-14	Jimmy	201	22	Butler	22	SG	104	6
5	1995-03-10	Zach	196	8	LaVine	26.7	SG	95	3
6	1998-03-03	Jayson	203	0	Tatum	24.8	SF	95	4
7	1993-03-11	Anthony	208	3	Davis	22.1	PF	115	1
8	1989-08-26	James	196	13	Harden	26.5	SG	100	2
9	1991-06-29	Kawhi	201	2	Leonard	25.7	SF	102	5
10	1992-03-23	Kyrie	190	11	Irving	24.4	PG	88	2
11	1994-12-06	Giannis	211	34	Antetokounmpo	28.1	PF	110	5
12	1995-02-19	Nikola	213	15	Jokić	26.2	C	129	5
13	1990-07-15	Damian	191	0	Lillard	28.9	PG	88	10
14	1990-05-08	Kemba	183	8	Walker	21.5	PG	84	4
15	1988-11-12	Russell	191	0	Westbrook	22.7	PG	91	7
16	1994-03-16	Joel	213	21	Embiid	26.4	C	113	11
17	1991-08-12	Khris	206	22	Middleton	20.8	SF	104	3
18	1990-05-02	Paul	206	13	George	23.6	SF	100	7
19	1996-07-20	Ben	208	25	Simmons	16.4	PG	104	11
25	1996-09-07	Donovan	185	45	Mitchell	25.6	SG	94	9
26	1996-10-30	Devin	196	1	Booker	27.5	SG	93	10
27	1999-02-28	Luka	201	77	Dončić	28.6	PG	102	11
28	1996-10-24	Jaylen	196	7	Brown	24.2	SG	102	4
29	2000-07-06	Zion	201	1	Williamson	27.8	PF	129	12
61	1999-11-06	Julius	190	17	Randle	13.9	SG	105	19
62	2001-03-12	Patty	203	23	Mills	6	PF	117	16
63	1998-05-30	Gordon	195	94	Hayward	16.4	C	109	4
64	1994-08-17	Stephen	196	7	Curry	26	PF	112	21
65	1988-09-24	Spencer	208	75	Dinwiddie	16.3	C	91	3
66	1999-10-26	Taj	200	89	Gibson	9.2	PF	88	14
67	2003-11-10	Rudy	193	14	Gobert	22.6	PG	113	2
68	1998-03-21	Tyler	203	0	Herro	10.2	C	79	28
69	1991-08-29	LaMelo	197	39	Ball	21.4	PF	80	14
70	1999-02-01	Jonas	192	33	Valančiūnas	23.1	PG	118	12
71	1991-03-23	Jaylen	206	64	Brown	23	PG	89	7
72	2003-12-16	Terry	203	56	Rozier	18.8	PF	113	6
73	1990-08-10	Danilo	201	5	Gallinari	11.4	SF	110	14
74	2002-02-16	Mason	198	76	Plumlee	7.3	SG	82	5
75	2001-04-19	Jaren	202	34	Jackson Jr.	23.2	C	108	23
76	1990-09-03	Lou	192	33	Williams	19.6	SG	77	2
77	1989-05-01	George	209	31	Hill	6.3	C	105	11
78	2000-02-13	Carmelo	203	34	Anthony	22.9	SG	99	5
79	1997-01-13	Marc	195	8	Gasol	9.1	SG	100	7
80	1990-04-09	Danny	206	28	Green	14.8	PF	87	16
81	2003-04-04	Tyrese	205	61	Haliburton	7.5	C	94	8
82	1991-08-08	James	203	64	Harden	27.9	PG	93	3
83	1990-06-08	Serge	208	53	Ibaka	13.7	PF	117	7
84	2003-04-17	RJ	199	21	Barrett	13.4	C	107	29
85	1993-01-28	Nikola	202	36	Vučević	24	SG	109	10
86	1989-01-25	Bogdan	195	7	Bogdanovic	16.1	C	104	2
87	1998-06-14	Duncan	196	92	Robinson	18.5	C	119	8
88	1989-08-15	Dillon	210	37	Brooks	11.3	SF	75	26
89	1993-10-20	Collin	206	61	Sexton	9.3	SF	83	22
90	1994-06-10	Montrezl	207	94	Harrell	29.7	SG	113	29
91	1998-11-21	Tristan	208	97	Thompson	21.9	PF	98	5
92	2003-07-23	Wesley	201	80	Matthews	25.5	C	118	11
93	1995-08-08	Jerami	194	11	Grant	13.4	PG	106	28
94	1993-12-06	Saddiq	198	87	Bey	17.6	PF	81	6
95	2003-03-20	Domantas	205	18	Sabonis	20.9	PF	107	13
96	1989-08-31	Enes	204	79	Kanter	26	SG	92	13
97	1990-09-30	Damian	201	70	Lillard	25.3	PG	117	28
98	1988-06-13	Jarrett	198	41	Allen	20.3	PF	100	30
99	2001-12-11	Ricky	199	45	Rubio	22.8	C	115	30
100	1996-02-15	Kristaps	204	6	Porzingis	12.3	SF	113	23
101	1992-12-08	Dwight	194	86	Drummond	22.3	SF	100	20
102	1991-10-04	Marcus	207	89	Smart	28.8	PF	95	18
103	1996-07-23	Marcus	197	7	Whiteside	14.7	C	114	10
104	1999-03-07	Derrick	209	63	Howard	25.4	C	85	5
105	1998-08-03	Marcus	190	81	Favors	22.1	PF	107	6
106	1999-10-01	Derrick	209	16	Howard	15.1	PF	120	20
107	1997-06-04	Kentavious	204	41	Kuzma	26.6	SG	93	4
108	2001-04-09	Lance	197	5	Stephenson	22.4	PG	87	28
109	1989-03-01	Kentavious	190	45	Caldwell-Pope	14	SG	93	7
110	2003-01-19	DeMarcus	191	40	Cousins	23.6	C	100	12
111	1998-03-29	Kentavious	208	36	Caldwell-Pope	15	SF	78	25
112	1998-02-20	Lance	194	0	Caldwell-Pope	28.7	SF	76	9
113	1990-07-02	Joakim	196	68	Whiteside	9.8	PG	115	22
114	1990-01-29	Hassan	196	43	Caldwell-Pope	23.8	PF	91	20
115	1998-01-16	Marcus	204	26	Whiteside	13.6	SF	88	25
116	1990-08-02	Hassan	209	80	Stephenson	18.5	C	114	6
117	2003-05-12	Joakim	201	12	Drummond	26.1	C	118	17
118	1989-10-07	Marcus	208	10	Drummond	17.9	PF	80	2
119	2000-09-25	Kyle	203	14	Kuzma	29.1	SF	120	4
120	1991-02-18	Hassan	210	80	Howard	9	PG	108	14
\.


--
-- TOC entry 3324 (class 0 OID 21090)
-- Dependencies: 215
-- Data for Name: timovi; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.timovi (timid, grad, porazi, nazivtima, pobjede) FROM stdin;
1	Los Angeles	27	Lakers	55
2	Brooklyn	34	Nets	48
3	Chicago	37	Bulls	45
4	Boston	32	Celtics	50
5	Golden State	24	Warriors	58
6	Miami	35	Heat	47
7	Los Angeles	34	Clippers	48
8	Houston	42	Rockets	40
9	Toronto	31	Raptors	51
10	Portland	38	Trail Blazers	44
11	Philadelphia	32	76ers	50
12	New Orleans	42	Pelicans	40
13	Atlanta	29	Hawks	53
14	Charlotte	34	Hornets	48
15	Cleveland	32	Cavaliers	50
16	Dallas	51	Mavericks	31
17	Denver	30	Nuggets	52
18	Detroit	58	Pistons	24
19	Indiana	47	Pacers	35
20	Memphis	28	Grizzlies	54
21	Milwaukee	52	Bucks	30
22	Minnesota	33	Timberwolves	49
23	New York	59	Knicks	23
24	Oklahoma City	57	Thunder	25
25	Orlando	40	Magic	42
26	Phoenix	58	Suns	24
27	Sacramento	27	Kings	55
28	San Antonio	25	Spurs	57
29	Utah	33	Jazz	49
30	Washington	61	Wizards	21
\.


--
-- TOC entry 3177 (class 2606 OID 21089)
-- Name: igraci igraci_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.igraci
    ADD CONSTRAINT igraci_pkey PRIMARY KEY (igracid);


--
-- TOC entry 3179 (class 2606 OID 21096)
-- Name: timovi timovi_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.timovi
    ADD CONSTRAINT timovi_pkey PRIMARY KEY (timid);


--
-- TOC entry 3180 (class 2606 OID 21097)
-- Name: igraci fk7lxuo05x395kikil1038rri3g; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.igraci
    ADD CONSTRAINT fk7lxuo05x395kikil1038rri3g FOREIGN KEY (timid) REFERENCES public.timovi(timid);


-- Completed on 2023-11-08 09:44:37

--
-- PostgreSQL database dump complete
--

