drop table system_sequences;
drop table system_messages;
drop table system_languages;
--消息资源信息
create table system_messages (
  code              char(8)              not null, --消息编码
  name              varchar2(30)         null        , --消息名称
  lang              varchar2(5)          null        , --语言
  description       varchar2(512)        null        , --描述
  constraint pk_system_messages primary key (code)
);

comment on table system_messages is '消息资源信息';
comment on column system_messages.code is '消息编码';
comment on column system_messages.name is '消息名称';
comment on column system_messages.lang is '语言';
comment on column system_messages.description is '描述';


--语言定义
create table system_languages (
  code            varchar2(5)          not null, --编码
  name            varchar2(32)         null        , --名称
  code_page       int                  default 0, --代码页
  constraint pk_system_languages primary key (code)
);

comment on table system_languages is '语言定义';
comment on column system_languages.code is '编码';
comment on column system_languages.name is '名称';
comment on column system_languages.code_page is '代码页';

insert into SYSTEM_LANGUAGES (CODE, NAME, CODE_PAGE) values ('zh_CN', '简体中文', 0);
insert into SYSTEM_LANGUAGES (CODE, NAME, CODE_PAGE) values ('en', 'ENGLISH', 0);
insert into SYSTEM_LANGUAGES (CODE, NAME, CODE_PAGE) values ('zh_TW', '繁体中文', 0);

/*序号定义表*/
create table system_sequences
(
    name  varchar2(30) not null,  /*序列名称*/
    value int not null,           /*当前序列值*/
    constraint pk_system_sequences primary key(name)
);
comment on table system_sequences is '序号定义表';
comment on column system_sequences.name is '序列名称';
comment on column system_sequences.value is '当前序列值';