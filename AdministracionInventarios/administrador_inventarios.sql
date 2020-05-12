--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2020-05-12 04:10:33

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
-- TOC entry 2835 (class 1262 OID 24576)
-- Name: administracion_inventarios; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE administracion_inventarios WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';


ALTER DATABASE administracion_inventarios OWNER TO postgres;

\connect administracion_inventarios

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
-- TOC entry 2828 (class 0 OID 24597)
-- Dependencies: 204
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.roles (id, nombre, descripcion) VALUES (1, 'Administrador', NULL);
INSERT INTO public.roles (id, nombre, descripcion) VALUES (2, 'Gestion Inventario', NULL);


--
-- TOC entry 2826 (class 0 OID 24577)
-- Dependencies: 202
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.usuarios (id, nombre, apellido, fecha_nacimiento, nick, contrasena, direccion, telefono, email, rol, cedula) VALUES (1, 'Diego Alejandro', 'Delgado Otalora', '1996-07-05', 'ddelgado09', 'ZGllZ28xMjM0LjA=', 'calle 8 sur # 201-13', 3127525731, 'ddelgado09@uan.edu.co', 1, 1144089509);


--
-- TOC entry 2836 (class 0 OID 0)
-- Dependencies: 205
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.roles_id_seq', 2, true);


--
-- TOC entry 2837 (class 0 OID 0)
-- Dependencies: 203
-- Name: usuarios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuarios_id_seq', 1, true);


-- Completed on 2020-05-12 04:10:33

--
-- PostgreSQL database dump complete
--

