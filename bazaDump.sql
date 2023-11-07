--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-11-07 14:54:05

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'WIN1250';
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
12	1995-02-19	Nikola	213	15	Jokiæ	26.2	C	129	5
13	1990-07-15	Damian	191	0	Lillard	28.9	PG	88	10
14	1990-05-08	Kemba	183	8	Walker	21.5	PG	84	4
15	1988-11-12	Russell	191	0	Westbrook	22.7	PG	91	7
16	1994-03-16	Joel	213	21	Embiid	26.4	C	113	11
17	1991-08-12	Khris	206	22	Middleton	20.8	SF	104	3
18	1990-05-02	Paul	206	13	George	23.6	SF	100	7
19	1996-07-20	Ben	208	25	Simmons	16.4	PG	104	11
20	1988-11-12	Russell	191	0	Westbrook	22.7	PG	91	7
21	1994-03-16	Joel	213	21	Embiid	26.4	C	113	11
22	1991-08-12	Khris	206	22	Middleton	20.8	SF	104	3
23	1990-05-02	Paul	206	13	George	23.6	SF	100	7
24	1996-07-20	Ben	208	25	Simmons	16.4	PG	104	11
25	1996-09-07	Donovan	185	45	Mitchell	25.6	SG	94	9
26	1996-10-30	Devin	196	1	Booker	27.5	SG	93	10
27	1999-02-28	Luka	201	77	Donèiæ	28.6	PG	102	11
28	1996-10-24	Jaylen	196	7	Brown	24.2	SG	102	4
29	2000-07-06	Zion	201	1	Williamson	27.8	PF	129	12
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


-- Completed on 2023-11-07 14:54:06

--
-- PostgreSQL database dump complete
--

