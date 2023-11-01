PGDMP                     	    {            OR    15.2    15.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                        0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    17445    OR    DATABASE     z   CREATE DATABASE "OR" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Croatian_Croatia.1250';
    DROP DATABASE "OR";
                postgres    false            �            1259    17453    igraci    TABLE     1  CREATE TABLE public.igraci (
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
    DROP TABLE public.igraci;
       public         heap    postgres    false            �            1259    17446    timovi    TABLE     �   CREATE TABLE public.timovi (
    timid integer NOT NULL,
    nazivtima character varying(255),
    grad character varying(255),
    pobjede integer,
    porazi integer
);
    DROP TABLE public.timovi;
       public         heap    postgres    false            �          0    17453    igraci 
   TABLE DATA           �   COPY public.igraci (igracid, ime, prezime, pozicija, datumrodjenja, visina, tezina, brojdresa, timid, poenipoutakmici) FROM stdin;
    public          postgres    false    215   �       �          0    17446    timovi 
   TABLE DATA           I   COPY public.timovi (timid, nazivtima, grad, pobjede, porazi) FROM stdin;
    public          postgres    false    214   n       k           2606    17459    igraci igraci_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.igraci
    ADD CONSTRAINT igraci_pkey PRIMARY KEY (igracid);
 <   ALTER TABLE ONLY public.igraci DROP CONSTRAINT igraci_pkey;
       public            postgres    false    215            i           2606    17452    timovi timovi_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.timovi
    ADD CONSTRAINT timovi_pkey PRIMARY KEY (timid);
 <   ALTER TABLE ONLY public.timovi DROP CONSTRAINT timovi_pkey;
       public            postgres    false    214            l           2606    17460    igraci igraci_timid_fkey    FK CONSTRAINT     y   ALTER TABLE ONLY public.igraci
    ADD CONSTRAINT igraci_timid_fkey FOREIGN KEY (timid) REFERENCES public.timovi(timid);
 B   ALTER TABLE ONLY public.igraci DROP CONSTRAINT igraci_timid_fkey;
       public          postgres    false    214    3177    215            �   x  x�=��n�0�������{�$jڙ��4UU6Vku�	&b O���P�,��;f<Żq�8�>�p����X�� ԁ���!�&2�S|O���]E��q�� �J��y�o��q?����=�T��+�Y�,�זL�c��w��G�׸/�b�ק(�H��~\������k;�ko��@��@�S�妪_�4��_YH#zi���m���!O�!/x���5ެ弩���e�f2n_�S��tWI��0)SS�銪�)��$���Ɏ�u۔�U�e[��贌)���k��K���W�J[��g<�����H���0��m�E�#��ͱv7m��+&,����k�q���p��*+�:���-*B�6���C�      �   �   x�̱� �����N��:TR/��p�����;`
���Ikwʋ$�`��dp�V1�5�2\��b��T1���cXO���km��{XC�G(%���5�$w���{GG\$4\c�D8����5�(b     