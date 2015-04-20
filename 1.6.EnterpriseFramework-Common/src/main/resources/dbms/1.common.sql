drop table system_sequences;
drop table system_messages;
drop table system_languages;
--��Ϣ��Դ��Ϣ
create table system_messages (
  code              char(8)              not null, --��Ϣ����
  name              varchar2(30)         null        , --��Ϣ����
  lang              varchar2(5)          null        , --����
  description       varchar2(512)        null        , --����
  constraint pk_system_messages primary key (code)
);

comment on table system_messages is '��Ϣ��Դ��Ϣ';
comment on column system_messages.code is '��Ϣ����';
comment on column system_messages.name is '��Ϣ����';
comment on column system_messages.lang is '����';
comment on column system_messages.description is '����';


--���Զ���
create table system_languages (
  code            varchar2(5)          not null, --����
  name            varchar2(32)         null        , --����
  code_page       int                  default 0, --����ҳ
  constraint pk_system_languages primary key (code)
);

comment on table system_languages is '���Զ���';
comment on column system_languages.code is '����';
comment on column system_languages.name is '����';
comment on column system_languages.code_page is '����ҳ';

insert into SYSTEM_LANGUAGES (CODE, NAME, CODE_PAGE) values ('zh_CN', '��������', 0);
insert into SYSTEM_LANGUAGES (CODE, NAME, CODE_PAGE) values ('en', 'ENGLISH', 0);
insert into SYSTEM_LANGUAGES (CODE, NAME, CODE_PAGE) values ('zh_TW', '��������', 0);

/*��Ŷ����*/
create table system_sequences
(
    name  varchar2(30) not null,  /*��������*/
    value int not null,           /*��ǰ����ֵ*/
    constraint pk_system_sequences primary key(name)
);
comment on table system_sequences is '��Ŷ����';
comment on column system_sequences.name is '��������';
comment on column system_sequences.value is '��ǰ����ֵ';