PGDMP     *    9                w            neomind    9.5.2    9.5.2     7           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            8           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            9           1262    65566    neomind    DATABASE     �   CREATE DATABASE neomind WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE neomind;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            :           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    6            ;           0    0    public    ACL     �   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                  postgres    false    6                        3079    12355    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            <           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    65567    fornecedorseq    SEQUENCE     o   CREATE SEQUENCE fornecedorseq
    START WITH 5
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.fornecedorseq;
       public       postgres    false    6            �            1259    73770 
   fornecedor    TABLE     �  CREATE TABLE fornecedor (
    id bigint DEFAULT nextval('fornecedorseq'::regclass) NOT NULL,
    razsoc character varying,
    email character varying(100),
    cnpj character varying(20),
    endereco character varying(100),
    endnum character varying(20),
    bairro character varying(100),
    cidade character varying(100),
    uf character varying(2),
    cep character varying(10)
);
    DROP TABLE public.fornecedor;
       public         postgres    false    181    6            4          0    73770 
   fornecedor 
   TABLE DATA               a   COPY fornecedor (id, razsoc, email, cnpj, endereco, endnum, bairro, cidade, uf, cep) FROM stdin;
    public       postgres    false    182   �       =           0    0    fornecedorseq    SEQUENCE SET     4   SELECT pg_catalog.setval('fornecedorseq', 2, true);
            public       postgres    false    181            �           2606    73778    id_pk 
   CONSTRAINT     G   ALTER TABLE ONLY fornecedor
    ADD CONSTRAINT id_pk PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.fornecedor DROP CONSTRAINT id_pk;
       public         postgres    false    182    182            4   m   x�3����M,Vp-�L��,I-.IuH�M���K���44�3�`} 6�54�t���,J�+IUpJ,*�/��463�t�=�hB"�W~f^YfNN*g�3��������W� �     