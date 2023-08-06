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
-- Name: asignacion_curso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.asignacion_curso (
    id_asignacion_curso integer NOT NULL,
    id_beneficiario integer,
    id_curso integer
);


ALTER TABLE public.asignacion_curso OWNER TO postgres;

--
-- Name: asignacion_curso_id_asignacion_curso_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.asignacion_curso_id_asignacion_curso_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.asignacion_curso_id_asignacion_curso_seq OWNER TO postgres;

--
-- Name: asignacion_curso_id_asignacion_curso_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.asignacion_curso_id_asignacion_curso_seq OWNED BY public.asignacion_curso.id_asignacion_curso;


--
-- Name: asistencias; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.asistencias (
    id_asistencia integer NOT NULL,
    id_asignacion_curso integer,
    fecha_asistencia date NOT NULL,
    asistencia boolean DEFAULT false NOT NULL
);


ALTER TABLE public.asistencias OWNER TO postgres;

--
-- Name: asistencia_id_asistencia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.asistencia_id_asistencia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.asistencia_id_asistencia_seq OWNER TO postgres;

--
-- Name: asistencia_id_asistencia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.asistencia_id_asistencia_seq OWNED BY public.asistencias.id_asistencia;


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
-- Name: curso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.curso (
    nombre_curso character varying(50),
    id_curso integer NOT NULL,
    tipo_beneficiario character varying(50)
);


ALTER TABLE public.curso OWNER TO postgres;

--
-- Name: cursos_id_curso_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cursos_id_curso_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cursos_id_curso_seq OWNER TO postgres;

--
-- Name: cursos_id_curso_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cursos_id_curso_seq OWNED BY public.curso.id_curso;


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
-- Name: asignacion_curso id_asignacion_curso; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asignacion_curso ALTER COLUMN id_asignacion_curso SET DEFAULT nextval('public.asignacion_curso_id_asignacion_curso_seq'::regclass);


--
-- Name: asistencias id_asistencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asistencias ALTER COLUMN id_asistencia SET DEFAULT nextval('public.asistencia_id_asistencia_seq'::regclass);


--
-- Name: beneficiario id_beneficiario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.beneficiario ALTER COLUMN id_beneficiario SET DEFAULT nextval('public.beneficiario_id_beneficiario_seq'::regclass);


--
-- Name: curso id_curso; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curso ALTER COLUMN id_curso SET DEFAULT nextval('public.cursos_id_curso_seq'::regclass);


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
-- Data for Name: asignacion_curso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.asignacion_curso (id_asignacion_curso, id_beneficiario, id_curso) FROM stdin;
1	13	6
5	13	3
8	35	2
9	35	5
10	37	3
11	37	6
12	35	4
13	36	6
\.


--
-- Data for Name: asistencias; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.asistencias (id_asistencia, id_asignacion_curso, fecha_asistencia, asistencia) FROM stdin;
174	1	2023-08-05	t
175	10	2023-08-05	t
176	13	2023-08-05	t
\.


--
-- Data for Name: beneficiario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.beneficiario (id_beneficiario, id_persona, id_representantes) FROM stdin;
13	18	\N
35	63	1
36	44	\N
37	64	\N
\.


--
-- Data for Name: curso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.curso (nombre_curso, id_curso, tipo_beneficiario) FROM stdin;
Redes sociales	1	Hijo
Buenas Prácticas	2	Hijo
Seguridad en Internet	3	Representante
Sitema Operativo	4	Hijo
Progamación	5	Hijo
Navegadores	6	Representante
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
9	59
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
10	47
11	64
\.


--
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.persona (id_persona, nombre, apellido, fecha_nacimiento, telefono, cedula, direccion, email, tipo) FROM stdin;
59	Lisa	Herrera	\N	\N	9876546548	\N	\N	\N
61	\N	\N	\N		\N			
19	Gustavo	Zambrano	1950-11-02	0123465974	0904986569	vergeles	Gzambrano@gmail.com	Padre
21	Carlos	Herrera	2000-06-14	5461329780	0123456987	sauces	carlosh@gmail.com	Hijo
23	Maria	Teran	\N	\N	2134557980	\N	\N	\N
24	Juan	Herrera	\N	\N	6431529780	\N	\N	\N
32	Gabriela	Chilan	\N	\N	2654319870	\N	\N	\N
33	Jorge	Granizo	\N	\N	3246159807	\N	\N	\N
35	Alfredo	Lopez	2001-08-17	3164259784	2134659132	la joya	Alfreditoz11@gmail.com	Hijo
36	Paul	Hernandez	0200-08-14	2461352457	9457683124	vergeles	paul@gmail.com	Hijo
39	Ramiro	Granizo	\N	\N	3126459780	\N	\N	\N
41	Jane	Martinez	\N	\N	1236549870	\N	\N	\N
42	Jose	Garcia	2001-07-11	65494562575	63256498710	orquideas	jose@gmail.com	Padre
47	Alarcon	Francisco	\N	\N	85225897643	\N	\N	\N
49	Alberto	Granizo	2001-09-12	789987789666	96336985200	guasmo	Albretito@gmail.com	Hijo
50	Alberto	Granizo	2001-09-12	789987789666	96336985200	guasmo	Albretito@gmail.com	Hijo
54	Raul	Cardenas	2005-09-09	4564566548	1233214568	los Geranios	Raul@gmail.com	Hijo
55	sfgasd	gasdfasdf	2023-07-01	asdfas	adfgad	dfas	dfasdf	Hijo
56	asdfasdf	asdfas	2023-07-07	asdfasd	adgfasd	fasd	fasdf	Hijo
57	asdfasdf	asdfasdf	2023-07-08	dASFASDFasd	asdfasdf	ASASDF	SDFASDF	Hijo
62	\N	\N	\N		\N			
18	Maryuri	Montoya	1968-05-08	0113264578	0911571701	Guasmo	mayi@gmail.com	Madre
63	Paul	Zambrano	2003-03-13	4566546231	7894566548	vergeles	PaullZ@gmail.com	Hijo
44	Daniela	Messi	1985-10-17	6546544562	6547891230	socio vivienda	DaniMessi@gmail.com	Madre
64	Mario	Ortiz	1979-07-11	7899879874	4564566543	Floresta	MarioBros@gmail.com	Padre
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
9	10	\N
10	\N	9
\.


--
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuarios (id, nombres, apellidos, username, contrasena) FROM stdin;
32	pual	zambrano	paulin	123
35	Jonathan	Zambrano	c	2
34	alfredo	zambrano	b	1
33	derian	zambrano	a	1
\.


--
-- Name: alumnos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.alumnos_id_seq', 35, true);


--
-- Name: asignacion_curso_id_asignacion_curso_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.asignacion_curso_id_asignacion_curso_seq', 13, true);


--
-- Name: asistencia_id_asistencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.asistencia_id_asistencia_seq', 176, true);


--
-- Name: beneficiario_id_beneficiario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.beneficiario_id_beneficiario_seq', 37, true);


--
-- Name: cursos_id_curso_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cursos_id_curso_seq', 6, true);


--
-- Name: madre_id_madre_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.madre_id_madre_seq', 9, true);


--
-- Name: padre_id_padre_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.padre_id_padre_seq', 11, true);


--
-- Name: persona_id_persona_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.persona_id_persona_seq', 64, true);


--
-- Name: representantes_id_representantes_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.representantes_id_representantes_seq', 11, true);


--
-- Name: asignacion_curso asignacion_curso_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asignacion_curso
    ADD CONSTRAINT asignacion_curso_pkey PRIMARY KEY (id_asignacion_curso);


--
-- Name: asistencias asistencia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asistencias
    ADD CONSTRAINT asistencia_pkey PRIMARY KEY (id_asistencia);


--
-- Name: beneficiario beneficiario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.beneficiario
    ADD CONSTRAINT beneficiario_pkey PRIMARY KEY (id_beneficiario);


--
-- Name: curso cursos_nombre_curso_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curso
    ADD CONSTRAINT cursos_nombre_curso_key UNIQUE (nombre_curso);


--
-- Name: curso cursos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curso
    ADD CONSTRAINT cursos_pkey PRIMARY KEY (id_curso);


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
-- Name: asignacion_curso asignacion_curso_id_curso_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asignacion_curso
    ADD CONSTRAINT asignacion_curso_id_curso_fkey FOREIGN KEY (id_curso) REFERENCES public.curso(id_curso);


--
-- Name: asistencias asistencia_id_asignacion_curso_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asistencias
    ADD CONSTRAINT asistencia_id_asignacion_curso_fkey FOREIGN KEY (id_asignacion_curso) REFERENCES public.asignacion_curso(id_asignacion_curso) ON DELETE CASCADE;


--
-- Name: beneficiario beneficiario_id_representantes_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.beneficiario
    ADD CONSTRAINT beneficiario_id_representantes_fkey FOREIGN KEY (id_representantes) REFERENCES public.representantes(id_representantes);


--
-- Name: asignacion_curso fk_asignacion_curso_id_beneficiario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asignacion_curso
    ADD CONSTRAINT fk_asignacion_curso_id_beneficiario FOREIGN KEY (id_beneficiario) REFERENCES public.beneficiario(id_beneficiario) ON DELETE CASCADE;


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

