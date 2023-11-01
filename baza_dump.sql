--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-11-01 07:53:23

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
-- TOC entry 215 (class 1259 OID 17453)
-- Name: igraci; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.igraci (
    igracid integer NOT NULL,
    ime character varying(255),
    prezime character varying(255),
    pozicija character varying(50),
    datumrodjenja date,
    visina integer,
    tezina integer,
    brojdresa integer,
    timid integer,
    poenipoutakmici numeric(5,2)
);


ALTER TABLE public.igraci OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 17446)
-- Name: timovi; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.timovi (
    timid integer NOT NULL,
    nazivtima character varying(255),
    grad character varying(255),
    pobjede integer,
    porazi integer
);


ALTER TABLE public.timovi OWNER TO postgres;

--
-- TOC entry 3324 (class 0 OID 17453)
-- Dependencies: 215
-- Data for Name: igraci; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.igraci (igracid, ime, prezime, pozicija, datumrodjenja, visina, tezina, brojdresa, timid, poenipoutakmici) FROM stdin;
1	LeBron	James	SF	1984-12-30	206	113	6	1	25.00
2	Kevin	Durant	SF	1988-09-29	208	108	7	2	27.00
3	Stephen	Curry	PG	1988-03-14	191	85	30	5	29.50
4	Jimmy	Butler	SG	1989-09-14	201	104	22	6	22.00
5	Zach	LaVine	SG	1995-03-10	196	95	8	3	26.70
6	Jayson	Tatum	SF	1998-03-03	203	95	0	4	24.80
7	Anthony	Davis	PF	1993-03-11	208	115	3	1	22.10
8	James	Harden	SG	1989-08-26	196	100	13	2	26.50
9	Kawhi	Leonard	SF	1991-06-29	201	102	2	5	25.70
10	Kyrie	Irving	PG	1992-03-23	190	88	11	2	24.40
11	Giannis	Antetokounmpo	PF	1994-12-06	211	110	34	5	28.10
12	Nikola	Jokić	C	1995-02-19	213	129	15	5	26.20
\.


--
-- TOC entry 3323 (class 0 OID 17446)
-- Dependencies: 214
-- Data for Name: timovi; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.timovi (timid, nazivtima, grad, pobjede, porazi) FROM stdin;
1	Lakers	Los Angeles	55	27
2	Nets	Brooklyn	48	34
3	Bulls	Chicago	45	37
4	Celtics	Boston	50	32
5	Warriors	Golden State	58	24
6	Heat	Miami	47	35
\.


--
-- TOC entry 3179 (class 2606 OID 17459)
-- Name: igraci igraci_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.igraci
    ADD CONSTRAINT igraci_pkey PRIMARY KEY (igracid);


--
-- TOC entry 3177 (class 2606 OID 17452)
-- Name: timovi timovi_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.timovi
    ADD CONSTRAINT timovi_pkey PRIMARY KEY (timid);


--
-- TOC entry 3180 (class 2606 OID 17460)
-- Name: igraci igraci_timid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.igraci
    ADD CONSTRAINT igraci_timid_fkey FOREIGN KEY (timid) REFERENCES public.timovi(timid);


-- Completed on 2023-11-01 07:53:24

--
-- PostgreSQL database dump complete
--

