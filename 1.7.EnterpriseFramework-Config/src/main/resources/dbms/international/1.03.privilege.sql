drop table system_menus;
drop table system_menu_descriptions;
drop table system_roles;
drop table system_role_descriptions ;
drop table system_role_privileges;
--ϵͳ�˵�
create table system_menus (
  code              varchar2(30)         not null, --����������
  ucode             varchar2(30)         null        , --����������
  url               varchar2(64)         null        ,
  status            int                  default 0, --״̬
  seq               int                  default 0, --��ʾ˳��
  css               varchar2(16)         null        , --��ʽ
  lang              varchar2(5)          null        , --����
  constraint pk_system_menus primary key (code)
);


comment on table system_menus is 'ϵͳ�˵�';
comment on column system_menus.code is '����������';
comment on column system_menus.ucode is '����������';
comment on column system_menus.status is '״̬';
comment on column system_menus.seq is '��ʾ˳��';
comment on column system_menus.css is '��ʽ';
comment on column system_menus.lang is '����';



--ϵͳ�˵�����
create table system_menu_descriptions (
  code              char(8)              not null, --����
  ucode             varchar2(32)         null        , --������Ϣ
  lang              varchar2(5)          null        , --����
  title             varchar2(32)         null        , --����
  description       varchar2(256)        null        , --����
  constraint pk_menu_descriptions primary key (code)
);

comment on table system_menu_descriptions is 'ϵͳ�˵�����';
comment on column system_menu_descriptions.code is '����';
comment on column system_menu_descriptions.ucode is '������Ϣ';
comment on column system_menu_descriptions.lang is '����';
comment on column system_menu_descriptions.title is '����';
comment on column system_menu_descriptions.description is '����';

   
--ϵͳ��ɫ
create table system_roles (
  code        char(8)              not null, --����
  rank        int                  default 0, --�㼶
  rank1       varchar(8)           null        , --һ������
  rank2       varchar(8)           null        , --��������
  rank3       varchar(8)           null        , --��������
  rank4       varchar(8)           null        , --�ļ�����
  rank5       varchar(8)           null        , --�弶����
  rank6       varchar(8)           null        , --��������
  rank7       varchar(8)           null        , --�߼�����
  rank8       varchar(8)           null        , --�˼�����
  rank9       varchar(8)           null        , --�ż�����
  ucode       varchar(8)           null        , --�ϼ�����
  status      int                  default  0,--��ɫ״̬
  constraint pk_system_roles primary key (code)
);

comment on table system_roles is 'ϵͳ��ɫ';
comment on column system_roles.code is '����';
comment on column system_roles.rank is '�㼶';
comment on column system_roles.rank1 is 'һ������';
comment on column system_roles.rank2 is '��������';
comment on column system_roles.rank3 is '��������';
comment on column system_roles.rank4 is '�ļ�����';
comment on column system_roles.rank5 is '�弶����';
comment on column system_roles.rank6 is '��������';
comment on column system_roles.rank7 is '�߼�����';
comment on column system_roles.rank8 is '�˼�����';
comment on column system_roles.rank9 is '�ż�����';
comment on column system_roles.ucode is '�ϼ�����';

--��ɫ��������
create table system_role_descriptions (
  code              char(8)              not null, --����
  ucode             varchar2(16)         null        , --������Ϣ
  lang              varchar2(5)          null        , --����
  name              varchar2(32)         null        , --��ɫ����
  description       varchar2(256)        null        , --����
  constraint pk_system_role_descriptions primary key (code)
);

comment on table system_role_descriptions is '��ɫ��������';
comment on column system_role_descriptions.code is '����';
comment on column system_role_descriptions.ucode is '������Ϣ';
comment on column system_role_descriptions.lang is '����';
comment on column system_role_descriptions.name is '��ɫ����';
comment on column system_role_descriptions.description is '����';

--��ɫȨ����Ϣ
create table system_role_privileges (
  code                 char(8)              not null, --Ȩ�ޱ���
  role_code            varchar2(8)          null        , --��ɫ����
  privilege_code       varchar2(32)         null        , --Ȩ�ޱ���
  constraint pk_system_role_privileges primary key (code)
);

comment on table system_role_privileges is '��ɫȨ����Ϣ';
comment on column system_role_privileges.code is 'Ȩ�ޱ���';
comment on column system_role_privileges.role_code is '��ɫ����';
comment on column system_role_privileges.privilege_code is 'Ȩ�ޱ���';


insert into system_menus values('SYSTEM','*','',1,100,'','');
insert into system_menu_descriptions values('MENU0001','SYSTEM','zh_CN','ϵͳ����','');
insert into system_menus values('AccountManagementController','SYSTEM','../../core/account/query',1,1,'','');
insert into system_menu_descriptions values('MENU0002','AccountManagementController','zh_CN','�ʺŹ���','');

insert into system_menus values('PrivilegeQueryController','SYSTEM','../../core/privilege/query',1,2,'','');
insert into system_menu_descriptions values('MENU0003','PrivilegeQueryController','zh_CN','Ȩ�޹���','');
