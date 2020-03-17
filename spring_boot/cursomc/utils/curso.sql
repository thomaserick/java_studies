PGDMP     )                    x            curso_spring    9.5.2    9.5.2 W    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           1262    131497    curso_spring    DATABASE     �   CREATE DATABASE curso_spring WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE curso_spring;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    6            �           0    0    public    ACL     �   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                  postgres    false    6                        3079    12355    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            �           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    131655 	   categoria    TABLE     U   CREATE TABLE categoria (
    id integer NOT NULL,
    name character varying(255)
);
    DROP TABLE public.categoria;
       public         postgres    false    6            �            1259    131653    categoria_id_seq    SEQUENCE     r   CREATE SEQUENCE categoria_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.categoria_id_seq;
       public       postgres    false    182    6            �           0    0    categoria_id_seq    SEQUENCE OWNED BY     7   ALTER SEQUENCE categoria_id_seq OWNED BY categoria.id;
            public       postgres    false    181            �            1259    131663    cidade    TABLE     i   CREATE TABLE cidade (
    id integer NOT NULL,
    name character varying(255),
    estado_id integer
);
    DROP TABLE public.cidade;
       public         postgres    false    6            �            1259    131661    cidade_id_seq    SEQUENCE     o   CREATE SEQUENCE cidade_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.cidade_id_seq;
       public       postgres    false    184    6            �           0    0    cidade_id_seq    SEQUENCE OWNED BY     1   ALTER SEQUENCE cidade_id_seq OWNED BY cidade.id;
            public       postgres    false    183            �            1259    131671    cliente    TABLE     �   CREATE TABLE cliente (
    id integer NOT NULL,
    cpf_cnpj character varying(255),
    email character varying(255),
    name character varying(255),
    tipo integer
);
    DROP TABLE public.cliente;
       public         postgres    false    6            �            1259    131669    cliente_id_seq    SEQUENCE     p   CREATE SEQUENCE cliente_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.cliente_id_seq;
       public       postgres    false    186    6            �           0    0    cliente_id_seq    SEQUENCE OWNED BY     3   ALTER SEQUENCE cliente_id_seq OWNED BY cliente.id;
            public       postgres    false    185            �            1259    131682    endereco    TABLE       CREATE TABLE endereco (
    id integer NOT NULL,
    bairro character varying(255),
    cep character varying(255),
    complemento character varying(255),
    logradouro character varying(255),
    numend character varying(255),
    cidade_id integer,
    cliente_id integer
);
    DROP TABLE public.endereco;
       public         postgres    false    6            �            1259    131680    endereco_id_seq    SEQUENCE     q   CREATE SEQUENCE endereco_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.endereco_id_seq;
       public       postgres    false    6    188            �           0    0    endereco_id_seq    SEQUENCE OWNED BY     5   ALTER SEQUENCE endereco_id_seq OWNED BY endereco.id;
            public       postgres    false    187            �            1259    131693    estado    TABLE     R   CREATE TABLE estado (
    id integer NOT NULL,
    name character varying(255)
);
    DROP TABLE public.estado;
       public         postgres    false    6            �            1259    131691    estado_id_seq    SEQUENCE     o   CREATE SEQUENCE estado_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.estado_id_seq;
       public       postgres    false    190    6            �           0    0    estado_id_seq    SEQUENCE OWNED BY     1   ALTER SEQUENCE estado_id_seq OWNED BY estado.id;
            public       postgres    false    189            �            1259    131699    item_pedido    TABLE     �   CREATE TABLE item_pedido (
    desconto double precision,
    preco double precision,
    quantidade integer,
    pedido_id integer NOT NULL,
    produto_id integer NOT NULL
);
    DROP TABLE public.item_pedido;
       public         postgres    false    6            �            1259    131704 	   pagamento    TABLE     O   CREATE TABLE pagamento (
    pedido_id integer NOT NULL,
    estado integer
);
    DROP TABLE public.pagamento;
       public         postgres    false    6            �            1259    131709    pagamento_com_boleto    TABLE     �   CREATE TABLE pagamento_com_boleto (
    data_pagamento timestamp without time zone,
    data_vencimento timestamp without time zone,
    pedido_id integer NOT NULL
);
 (   DROP TABLE public.pagamento_com_boleto;
       public         postgres    false    6            �            1259    131714    pagamento_com_cartao    TABLE     `   CREATE TABLE pagamento_com_cartao (
    num_parcelas integer,
    pedido_id integer NOT NULL
);
 (   DROP TABLE public.pagamento_com_cartao;
       public         postgres    false    6            �            1259    131721    pedido    TABLE     �   CREATE TABLE pedido (
    id integer NOT NULL,
    instanse timestamp without time zone,
    cliente_id integer,
    endereco_entrega_id integer
);
    DROP TABLE public.pedido;
       public         postgres    false    6            �            1259    131719    pedido_id_seq    SEQUENCE     o   CREATE SEQUENCE pedido_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.pedido_id_seq;
       public       postgres    false    196    6            �           0    0    pedido_id_seq    SEQUENCE OWNED BY     1   ALTER SEQUENCE pedido_id_seq OWNED BY pedido.id;
            public       postgres    false    195            �            1259    131729    produto    TABLE     o   CREATE TABLE produto (
    id integer NOT NULL,
    name character varying(255),
    preco double precision
);
    DROP TABLE public.produto;
       public         postgres    false    6            �            1259    131735    produto_categoria    TABLE     g   CREATE TABLE produto_categoria (
    produto_id integer NOT NULL,
    categoria_id integer NOT NULL
);
 %   DROP TABLE public.produto_categoria;
       public         postgres    false    6            �            1259    131727    produto_id_seq    SEQUENCE     p   CREATE SEQUENCE produto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.produto_id_seq;
       public       postgres    false    6    198            �           0    0    produto_id_seq    SEQUENCE OWNED BY     3   ALTER SEQUENCE produto_id_seq OWNED BY produto.id;
            public       postgres    false    197            �            1259    131738    telefone    TABLE     a   CREATE TABLE telefone (
    cliente_id integer NOT NULL,
    telefones character varying(255)
);
    DROP TABLE public.telefone;
       public         postgres    false    6            �           2604    131658    id    DEFAULT     ^   ALTER TABLE ONLY categoria ALTER COLUMN id SET DEFAULT nextval('categoria_id_seq'::regclass);
 ;   ALTER TABLE public.categoria ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    182    181    182            �           2604    131666    id    DEFAULT     X   ALTER TABLE ONLY cidade ALTER COLUMN id SET DEFAULT nextval('cidade_id_seq'::regclass);
 8   ALTER TABLE public.cidade ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    184    183    184            �           2604    131674    id    DEFAULT     Z   ALTER TABLE ONLY cliente ALTER COLUMN id SET DEFAULT nextval('cliente_id_seq'::regclass);
 9   ALTER TABLE public.cliente ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    185    186    186            �           2604    131685    id    DEFAULT     \   ALTER TABLE ONLY endereco ALTER COLUMN id SET DEFAULT nextval('endereco_id_seq'::regclass);
 :   ALTER TABLE public.endereco ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    187    188    188            �           2604    131696    id    DEFAULT     X   ALTER TABLE ONLY estado ALTER COLUMN id SET DEFAULT nextval('estado_id_seq'::regclass);
 8   ALTER TABLE public.estado ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    189    190    190                        2604    131724    id    DEFAULT     X   ALTER TABLE ONLY pedido ALTER COLUMN id SET DEFAULT nextval('pedido_id_seq'::regclass);
 8   ALTER TABLE public.pedido ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    195    196    196                       2604    131732    id    DEFAULT     Z   ALTER TABLE ONLY produto ALTER COLUMN id SET DEFAULT nextval('produto_id_seq'::regclass);
 9   ALTER TABLE public.produto ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    198    197    198            �          0    131655 	   categoria 
   TABLE DATA                     public       postgres    false    182   vY       �           0    0    categoria_id_seq    SEQUENCE SET     7   SELECT pg_catalog.setval('categoria_id_seq', 7, true);
            public       postgres    false    181            �          0    131663    cidade 
   TABLE DATA                     public       postgres    false    184   -Z       �           0    0    cidade_id_seq    SEQUENCE SET     4   SELECT pg_catalog.setval('cidade_id_seq', 4, true);
            public       postgres    false    183            �          0    131671    cliente 
   TABLE DATA                     public       postgres    false    186   �Z       �           0    0    cliente_id_seq    SEQUENCE SET     5   SELECT pg_catalog.setval('cliente_id_seq', 1, true);
            public       postgres    false    185            �          0    131682    endereco 
   TABLE DATA                     public       postgres    false    188   C[       �           0    0    endereco_id_seq    SEQUENCE SET     6   SELECT pg_catalog.setval('endereco_id_seq', 2, true);
            public       postgres    false    187            �          0    131693    estado 
   TABLE DATA                     public       postgres    false    190   \       �           0    0    estado_id_seq    SEQUENCE SET     4   SELECT pg_catalog.setval('estado_id_seq', 3, true);
            public       postgres    false    189            �          0    131699    item_pedido 
   TABLE DATA                     public       postgres    false    191   �\       �          0    131704 	   pagamento 
   TABLE DATA                     public       postgres    false    192   ]       �          0    131709    pagamento_com_boleto 
   TABLE DATA                     public       postgres    false    193   m]       �          0    131714    pagamento_com_cartao 
   TABLE DATA                     public       postgres    false    194   �]       �          0    131721    pedido 
   TABLE DATA                     public       postgres    false    196   O^       �           0    0    pedido_id_seq    SEQUENCE SET     4   SELECT pg_catalog.setval('pedido_id_seq', 2, true);
            public       postgres    false    195            �          0    131729    produto 
   TABLE DATA                     public       postgres    false    198   �^       �          0    131735    produto_categoria 
   TABLE DATA                     public       postgres    false    199   �_       �           0    0    produto_id_seq    SEQUENCE SET     6   SELECT pg_catalog.setval('produto_id_seq', 11, true);
            public       postgres    false    197            �          0    131738    telefone 
   TABLE DATA                     public       postgres    false    200   [`                  2606    131660    categoria_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY categoria
    ADD CONSTRAINT categoria_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.categoria DROP CONSTRAINT categoria_pkey;
       public         postgres    false    182    182                       2606    131668    cidade_pkey 
   CONSTRAINT     I   ALTER TABLE ONLY cidade
    ADD CONSTRAINT cidade_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.cidade DROP CONSTRAINT cidade_pkey;
       public         postgres    false    184    184                       2606    131679    cliente_pkey 
   CONSTRAINT     K   ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public         postgres    false    186    186                       2606    131690    endereco_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.endereco DROP CONSTRAINT endereco_pkey;
       public         postgres    false    188    188                       2606    131698    estado_pkey 
   CONSTRAINT     I   ALTER TABLE ONLY estado
    ADD CONSTRAINT estado_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.estado DROP CONSTRAINT estado_pkey;
       public         postgres    false    190    190                       2606    131703    item_pedido_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY item_pedido
    ADD CONSTRAINT item_pedido_pkey PRIMARY KEY (pedido_id, produto_id);
 F   ALTER TABLE ONLY public.item_pedido DROP CONSTRAINT item_pedido_pkey;
       public         postgres    false    191    191    191                       2606    131713    pagamento_com_boleto_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY pagamento_com_boleto
    ADD CONSTRAINT pagamento_com_boleto_pkey PRIMARY KEY (pedido_id);
 X   ALTER TABLE ONLY public.pagamento_com_boleto DROP CONSTRAINT pagamento_com_boleto_pkey;
       public         postgres    false    193    193                       2606    131718    pagamento_com_cartao_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY pagamento_com_cartao
    ADD CONSTRAINT pagamento_com_cartao_pkey PRIMARY KEY (pedido_id);
 X   ALTER TABLE ONLY public.pagamento_com_cartao DROP CONSTRAINT pagamento_com_cartao_pkey;
       public         postgres    false    194    194                       2606    131708    pagamento_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY pagamento
    ADD CONSTRAINT pagamento_pkey PRIMARY KEY (pedido_id);
 B   ALTER TABLE ONLY public.pagamento DROP CONSTRAINT pagamento_pkey;
       public         postgres    false    192    192                       2606    131726    pedido_pkey 
   CONSTRAINT     I   ALTER TABLE ONLY pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.pedido DROP CONSTRAINT pedido_pkey;
       public         postgres    false    196    196                       2606    131734    produto_pkey 
   CONSTRAINT     K   ALTER TABLE ONLY produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_pkey;
       public         postgres    false    198    198            	           2606    131742    uk_cmxo70m08n43599l3h0h07cc6 
   CONSTRAINT     Y   ALTER TABLE ONLY cliente
    ADD CONSTRAINT uk_cmxo70m08n43599l3h0h07cc6 UNIQUE (email);
 N   ALTER TABLE ONLY public.cliente DROP CONSTRAINT uk_cmxo70m08n43599l3h0h07cc6;
       public         postgres    false    186    186            %           2606    131798    fk1c0y58d3n6x3m6euv2j3h64vt    FK CONSTRAINT     �   ALTER TABLE ONLY produto_categoria
    ADD CONSTRAINT fk1c0y58d3n6x3m6euv2j3h64vt FOREIGN KEY (produto_id) REFERENCES produto(id);
 W   ALTER TABLE ONLY public.produto_categoria DROP CONSTRAINT fk1c0y58d3n6x3m6euv2j3h64vt;
       public       postgres    false    2073    199    198            "           2606    131783    fk30s8j2ktpay6of18lbyqn3632    FK CONSTRAINT     x   ALTER TABLE ONLY pedido
    ADD CONSTRAINT fk30s8j2ktpay6of18lbyqn3632 FOREIGN KEY (cliente_id) REFERENCES cliente(id);
 L   ALTER TABLE ONLY public.pedido DROP CONSTRAINT fk30s8j2ktpay6of18lbyqn3632;
       public       postgres    false    186    2055    196                       2606    131758    fk60ym08cfoysa17wrn1swyiuda    FK CONSTRAINT     {   ALTER TABLE ONLY item_pedido
    ADD CONSTRAINT fk60ym08cfoysa17wrn1swyiuda FOREIGN KEY (pedido_id) REFERENCES pedido(id);
 Q   ALTER TABLE ONLY public.item_pedido DROP CONSTRAINT fk60ym08cfoysa17wrn1swyiuda;
       public       postgres    false    191    196    2071            &           2606    131803    fk8aafha0njkoyoe3kvrwsy3g8u    FK CONSTRAINT     z   ALTER TABLE ONLY telefone
    ADD CONSTRAINT fk8aafha0njkoyoe3kvrwsy3g8u FOREIGN KEY (cliente_id) REFERENCES cliente(id);
 N   ALTER TABLE ONLY public.telefone DROP CONSTRAINT fk8aafha0njkoyoe3kvrwsy3g8u;
       public       postgres    false    200    2055    186                       2606    131748    fk8b1kcb3wucapb8dejshyn5fsx    FK CONSTRAINT     x   ALTER TABLE ONLY endereco
    ADD CONSTRAINT fk8b1kcb3wucapb8dejshyn5fsx FOREIGN KEY (cidade_id) REFERENCES cidade(id);
 N   ALTER TABLE ONLY public.endereco DROP CONSTRAINT fk8b1kcb3wucapb8dejshyn5fsx;
       public       postgres    false    188    184    2053                       2606    131753    fk8s7ivtl4foyhrfam9xqom73n9    FK CONSTRAINT     z   ALTER TABLE ONLY endereco
    ADD CONSTRAINT fk8s7ivtl4foyhrfam9xqom73n9 FOREIGN KEY (cliente_id) REFERENCES cliente(id);
 N   ALTER TABLE ONLY public.endereco DROP CONSTRAINT fk8s7ivtl4foyhrfam9xqom73n9;
       public       postgres    false    188    186    2055                        2606    131773    fkcr74vrxf8nfph0knq2bho8doo    FK CONSTRAINT     �   ALTER TABLE ONLY pagamento_com_boleto
    ADD CONSTRAINT fkcr74vrxf8nfph0knq2bho8doo FOREIGN KEY (pedido_id) REFERENCES pagamento(pedido_id);
 Z   ALTER TABLE ONLY public.pagamento_com_boleto DROP CONSTRAINT fkcr74vrxf8nfph0knq2bho8doo;
       public       postgres    false    193    192    2065            #           2606    131788    fkcrxxe5rpllxbh0sfi4a6rwphb    FK CONSTRAINT     �   ALTER TABLE ONLY pedido
    ADD CONSTRAINT fkcrxxe5rpllxbh0sfi4a6rwphb FOREIGN KEY (endereco_entrega_id) REFERENCES endereco(id);
 L   ALTER TABLE ONLY public.pedido DROP CONSTRAINT fkcrxxe5rpllxbh0sfi4a6rwphb;
       public       postgres    false    2059    196    188                       2606    131743    fkkworrwk40xj58kevvh3evi500    FK CONSTRAINT     v   ALTER TABLE ONLY cidade
    ADD CONSTRAINT fkkworrwk40xj58kevvh3evi500 FOREIGN KEY (estado_id) REFERENCES estado(id);
 L   ALTER TABLE ONLY public.cidade DROP CONSTRAINT fkkworrwk40xj58kevvh3evi500;
       public       postgres    false    184    2061    190            $           2606    131793    fkq3g33tp7xk2juh53fbw6y4y57    FK CONSTRAINT     �   ALTER TABLE ONLY produto_categoria
    ADD CONSTRAINT fkq3g33tp7xk2juh53fbw6y4y57 FOREIGN KEY (categoria_id) REFERENCES categoria(id);
 W   ALTER TABLE ONLY public.produto_categoria DROP CONSTRAINT fkq3g33tp7xk2juh53fbw6y4y57;
       public       postgres    false    199    2051    182            !           2606    131778    fkta3cdnuuxclwfh52t4qi432ow    FK CONSTRAINT     �   ALTER TABLE ONLY pagamento_com_cartao
    ADD CONSTRAINT fkta3cdnuuxclwfh52t4qi432ow FOREIGN KEY (pedido_id) REFERENCES pagamento(pedido_id);
 Z   ALTER TABLE ONLY public.pagamento_com_cartao DROP CONSTRAINT fkta3cdnuuxclwfh52t4qi432ow;
       public       postgres    false    2065    192    194                       2606    131768    fkthad9tkw4188hb3qo1lm5ueb0    FK CONSTRAINT     y   ALTER TABLE ONLY pagamento
    ADD CONSTRAINT fkthad9tkw4188hb3qo1lm5ueb0 FOREIGN KEY (pedido_id) REFERENCES pedido(id);
 O   ALTER TABLE ONLY public.pagamento DROP CONSTRAINT fkthad9tkw4188hb3qo1lm5ueb0;
       public       postgres    false    192    196    2071                       2606    131763    fktk55mn6d6bvl5h0no5uagi3sf    FK CONSTRAINT     }   ALTER TABLE ONLY item_pedido
    ADD CONSTRAINT fktk55mn6d6bvl5h0no5uagi3sf FOREIGN KEY (produto_id) REFERENCES produto(id);
 Q   ALTER TABLE ONLY public.item_pedido DROP CONSTRAINT fktk55mn6d6bvl5h0no5uagi3sf;
       public       postgres    false    191    198    2073            �   �   x���;�0�>��.���A� �
����Kؖ6�@���|1�p?ofDU��D��A��޲B�T[�AM9�W�SYC6* �����)�i�LĿxp9HVοY�(;	v�AӀ@pAs�k���o����v�³��ȭ2ؓ���@7$-��g��E���1$~4I�����      �   �   x���v
Q���WH�LILIU��L�Q�K�M�QH-.ILɏ�L�Ts�	uV�0�QPMJ-�I�K�LT�Q0Դ��$�#�)���+$���M1"�c�)^��ye�99�@C��1�h�sbnAf^b1�!\\ ��R      �   q   x���v
Q���WH��L�+IU��L�QH.H�O�+��QH�M���Q�K�M�Q(�,��Ts�	uV�0�QP7636��44267Wrs�2�Az���sAB� ! �PӚ�� �8 s      �   �   x����
�0��>En*xh��N286�v��P�t��_��K���O�Wu[6Tuw:�-DZ%��9�@�;LgR�};����B"�{��§_�&����^��³tJ!Q���t繘f)c��E��X��յ����CP�'���GR��rfYƸ��J#!�r_�\���lOMlI��C1d�      �   h   x���v
Q���WH-.IL�W��L�Q�K�M�Ts�	uV�0�QP���K,VpO-J�,V״��$J�Pg����
��9���3�K�+ITpN,I,���� �3O      �   z   x���v
Q���W�,I͍/HM�L�W�HI-N��+��Q((JMR���y%�)�)�@!�����l~Ji	��������a��`d` $!HӚ˓F�X���bL+[��@���h rx`�      �   L   x���v
Q���W(HLO�M�+�W�(HM�Lɏ�L�QH-.IL��Ts�	uV�0�Q0Ҵ��$Y����!P# M="�      �   n   x���v
Q���W(HLO�M�+ɏO�ύO��I-�W�HI,I��K�(��e�yəP��Ԕ̔���M�0G�P�`�Pu#Cs]C]#+0R�Q0Ҵ��� ��$�      �   T   x���v
Q���W(HLO�M�+ɏO�ύON,*I�W��+͍/H,JN�I,�Q(HM�Lɏ�L�Ts�	uV�0�Q0Դ��� �-H      �   �   x���v
Q���W(HM�L�W��L�Q��+.I�+N�QH��L�+I���楤�&��E�R����
a�>���
�:
�F�����
�V�FV�:
@CMk.O��e��� �-��M�v��� g�>e      �   �   x���A�0E���; aAA�$��}�M�P�P�Jċ9���$��o��E��5ɋ�J�	�2q:I��H4��Gz�gq�G��q����H���{��M� -�ġR01���%X�X���N�B������X�jA��߯�7+8� o�id@�H���0.�oHP�>�}	� �Qqì{�ER}�U����D,���ѽ      �   �   x���v
Q���W((�O)-ɏON,IM�/�LTЀ	e��(���<M�0G�P�`CCMk.O*�cBs����9FT2�*�2������*�����15�1����uL�a����5̱��9�:
�@��� f�Jr      �   U   x���v
Q���W(I�IM��KU�H��L�+I��Lс�k*�9���+h�(��XZ��kZsyRd����� ç)�     