--
-- PostgreSQL database dump
--

-- Dumped from database version 10.23
-- Dumped by pg_dump version 10.23

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
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuarios (
    id integer NOT NULL,
    nombres character varying(50) NOT NULL,
    apellidos character varying(50) NOT NULL,
    username character varying(500),
    contrasena character varying(50)
);


ALTER TABLE public.usuarios OWNER TO postgres;

--
-- Name: alumnos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.alumnos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.alumnos_id_seq OWNER TO postgres;

--
-- Name: alumnos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.alumnos_id_seq OWNED BY public.usuarios.id;


--
-- Name: beneficiario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.beneficiario (
    id_beneficiario integer NOT NULL,
    id_persona integer NOT NULL,
    id_representantes integer
);


ALTER TABLE public.beneficiario OWNER TO postgres;

--
-- Name: beneficiario_id_beneficiario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.beneficiario_id_beneficiario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.beneficiario_id_beneficiario_seq OWNER TO postgres;

--
-- Name: beneficiario_id_beneficiario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.beneficiario_id_beneficiario_seq OWNED BY public.beneficiario.id_beneficiario;


--
-- Name: cursos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cursos (
);


ALTER TABLE public.cursos OWNER TO postgres;

--
-- Name: madre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.madre (
    id_madre integer NOT NULL,
    id_persona integer
);


ALTER TABLE public.madre OWNER TO postgres;

--
-- Name: madre_id_madre_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.madre_id_madre_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.madre_id_madre_seq OWNER TO postgres;

--
-- Name: madre_id_madre_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.madre_id_madre_seq OWNED BY public.madre.id_madre;


--
-- Name: padre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.padre (
    id_padre integer NOT NULL,
    id_persona integer NOT NULL
);


ALTER TABLE public.padre OWNER TO postgres;

--
-- Name: padre_id_padre_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.padre_id_padre_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.padre_id_padre_seq OWNER TO postgres;

--
-- Name: padre_id_padre_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.padre_id_padre_seq OWNED BY public.padre.id_padre;


--
-- Name: persona; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.persona (
    id_persona integer NOT NULL,
    nombre character varying(50),
    apellido character varying(50),
    fecha_nacimiento date,
    telefono character varying(15),
    cedula character varying(11),
    direccion character varying(100),
    email character varying(50),
    tipo character varying(50)
);


ALTER TABLE public.persona OWNER TO postgres;

--
-- Name: persona_id_persona_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.persona_id_persona_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.persona_id_persona_seq OWNER TO postgres;

--
-- Name: persona_id_persona_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.persona_id_persona_seq OWNED BY public.persona.id_persona;


--
-- Name: representantes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.representantes (
    id_representantes integer NOT NULL,
    id_padre integer,
    id_madre integer
);


ALTER TABLE public.representantes OWNER TO postgres;

--
-- Name: representantes_id_representantes_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.representantes_id_representantes_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.representantes_id_representantes_seq OWNER TO postgres;

--
-- Name: representantes_id_representantes_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.representantes_id_representantes_seq OWNED BY public.representantes.id_representantes;


--
-- Name: beneficiario id_beneficiario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.beneficiario ALTER COLUMN id_beneficiario SET DEFAULT nextval('public.beneficiario_id_beneficiario_seq'::regclass);


--
-- Name: madre id_madre; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.madre ALTER COLUMN id_madre SET DEFAULT nextval('public.madre_id_madre_seq'::regclass);


--
-- Name: padre id_padre; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.padre ALTER COLUMN id_padre SET DEFAULT nextval('public.padre_id_padre_seq'::regclass);


--
-- Name: persona id_persona; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona ALTER COLUMN id_persona SET DEFAULT nextval('public.persona_id_persona_seq'::regclass);


--
-- Name: representantes id_representantes; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.representantes ALTER COLUMN id_representantes SET DEFAULT nextval('public.representantes_id_representantes_seq'::regclass);


--
-- Name: usuarios id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios ALTER COLUMN id SET DEFAULT nextval('public.alumnos_id_seq'::regclass);


--
-- Data for Name: beneficiario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.beneficiario (id_beneficiario, id_persona, id_representantes) FROM stdin;
11	17	\N
13	18	\N
14	19	\N
15	22	\N
16	31	4
19	37	\N
21	40	6
22	43	7
23	42	\N
24	45	8
\.


--
-- Data for Name: cursos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cursos  FROM stdin;
\.


--
-- Data for Name: madre; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.madre (id_madre, id_persona) FROM stdin;
1	18
2	23
5	32
6	41
7	44
8	46
\.


--
-- Data for Name: padre; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.padre (id_padre, id_persona) FROM stdin;
3	19
4	24
7	33
8	39
9	42
\.


--
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.persona (id_persona, nombre, apellido, fecha_nacimiento, telefono, cedula, direccion, email, tipo) FROM stdin;
17	Derian	Zambrano	2001-04-25	0987786332	0953501277	vergeles	Derianzambranom@gmail.com	hijo
18	Maryuri	Montoya	1968-05-08	0113264578	0911571701	vergeles	mayi@gmail.com	Madre
19	Gustavo	Zambrano	1950-11-02	0123465974	0904986569	vergeles	Gzambrano@gmail.com	Padre
21	Carlos	Herrera	2000-06-14	5461329780	0123456987	sauces	carlosh@gmail.com	Hijo
22	Carlos	Herrare	2000-06-22	5461629780	6451329780	alborada	carlosh@gmail.com	Hijo
23	Maria	Teran	\N	\N	2134557980	\N	\N	\N
24	Juan	Herrera	\N	\N	6431529780	\N	\N	\N
31	Jeremy	Granizo	2004-08-11	6531249780	3465128097	guasmo	jeremyG@gmail.com	Hijo
32	Gabriela	Chilan	\N	\N	2654319870	\N	\N	\N
33	Jorge	Granizo	\N	\N	3246159807	\N	\N	\N
35	Alfredo	Lopez	2001-08-17	3164259784	2134659132	la joya	Alfreditoz11@gmail.com	Hijo
36	Paul	Hernandez	0200-08-14	2461352457	9457683124	vergeles	paul@gmail.com	Hijo
37	Jhoel	Gonzales	2004-08-12	3698521470	753412896	ceibos	Jhoelito1000@gmail.com	Hijo
39	Ramiro	Granizo	\N	\N	3126459780	\N	\N	\N
40	Emanuel	Garcia	2002-09-13	1235698740	7946123582	sauces	emanuel12@gmail.com	Hijo
41	Jane	Martinez	\N	\N	1236549870	\N	\N	\N
43	jonathan	zambrano	2001-07-11	6549732114	9632587419	orquideas	jonathan@gmail.com	Hijo
44	Daniela	Messi	\N	\N	6547891230	\N	\N	\N
42	Jose	Garcia	2001-07-11	65494562575	63256498710	orquideas	jose@gmail.com	Padre
45	Jose	Garcia	2001-07-11	65494562575	12345678634	orquideas	jose@gmail.com	Hijo
46	Daniela	Messi	\N	\N	6547891230	\N	\N	\N
\.


--
-- Data for Name: representantes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.representantes (id_representantes, id_padre, id_madre) FROM stdin;
1	3	1
4	7	5
5	8	\N
6	9	6
7	\N	7
8	\N	8
\.


--
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuarios (id, nombres, apellidos, username, contrasena) FROM stdin;
32	pual	zambrano	paulin	123
33	derian	zambrano	a	1
34	alfredo	zambrano	b	1
35	Jonathan	Zambrano	c	2
\.


--
-- Name: alumnos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.alumnos_id_seq', 35, true);


--
-- Name: beneficiario_id_beneficiario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.beneficiario_id_beneficiario_seq', 24, true);


--
-- Name: madre_id_madre_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.madre_id_madre_seq', 8, true);


--
-- Name: padre_id_padre_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.padre_id_padre_seq', 9, true);


--
-- Name: persona_id_persona_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.persona_id_persona_seq', 46, true);


--
-- Name: representantes_id_representantes_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.representantes_id_representantes_seq', 8, true);


--
-- Name: beneficiario beneficiario_id_representantes_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.beneficiario
    ADD CONSTRAINT beneficiario_id_representantes_key UNIQUE (id_representantes);


--
-- Name: beneficiario beneficiario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.beneficiario
    ADD CONSTRAINT beneficiario_pkey PRIMARY KEY (id_beneficiario);


--
-- Name: madre madre_id_persona_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.madre
    ADD CONSTRAINT madre_id_persona_key UNIQUE (id_persona);


--
-- Name: madre madre_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.madre
    ADD CONSTRAINT madre_pkey PRIMARY KEY (id_madre);


--
-- Name: padre padre_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.padre
    ADD CONSTRAINT padre_pkey PRIMARY KEY (id_padre);


--
-- Name: persona persona_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (id_persona);


--
-- Name: representantes representantes_id_madre_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.representantes
    ADD CONSTRAINT representantes_id_madre_key UNIQUE (id_madre);


--
-- Name: representantes representantes_id_padre_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.representantes
    ADD CONSTRAINT representantes_id_padre_key UNIQUE (id_padre);


--
-- Name: representantes representantes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.representantes
    ADD CONSTRAINT representantes_pkey PRIMARY KEY (id_representantes);


--
-- Name: persona uk_id_persona; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona
    ADD CONSTRAINT uk_id_persona UNIQUE (id_persona);


--
-- Name: beneficiario uk_id_persona_beneficiario; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.beneficiario
    ADD CONSTRAINT uk_id_persona_beneficiario UNIQUE (id_persona);


--
-- Name: padre uk_id_persona_padre; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.padre
    ADD CONSTRAINT uk_id_persona_padre UNIQUE (id_persona);


--
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);


--
-- Name: beneficiario beneficiario_id_representantes_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.beneficiario
    ADD CONSTRAINT beneficiario_id_representantes_fkey FOREIGN KEY (id_representantes) REFERENCES public.representantes(id_representantes);


--
-- Name: beneficiario fk_id_persona; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.beneficiario
    ADD CONSTRAINT fk_id_persona FOREIGN KEY (id_persona) REFERENCES public.persona(id_persona) ON DELETE CASCADE;


--
-- Name: padre fk_id_persona; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.padre
    ADD CONSTRAINT fk_id_persona FOREIGN KEY (id_persona) REFERENCES public.persona(id_persona) ON DELETE CASCADE;


--
-- Name: madre fk_id_persona; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.madre
    ADD CONSTRAINT fk_id_persona FOREIGN KEY (id_persona) REFERENCES public.persona(id_persona) ON DELETE CASCADE;


--
-- Name: representantes representantes_id_madre_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.representantes
    ADD CONSTRAINT representantes_id_madre_fkey FOREIGN KEY (id_madre) REFERENCES public.madre(id_madre);


--
-- Name: representantes representantes_id_padre_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.representantes
    ADD CONSTRAINT representantes_id_padre_fkey FOREIGN KEY (id_padre) REFERENCES public.padre(id_padre);


--
-- PostgreSQL database dump complete
--

