drop table system_parameters;
drop table system_parameter_descriptions;
--系统参数
create table system_parameters (
  code        char(8)              not null, --参数编码
  name        varchar2(32)         null        , --参数名称
  value       varchar2(512)        null        , --参数值
  category    int                  default 2   , --参数类型，缺省为业务参数
  constraint pk_system_parameters primary key (code)
);

comment on table system_parameters is '系统参数';
comment on column system_parameters.code is '参数编码';
comment on column system_parameters.name is '参数名称';
comment on column system_parameters.value is '参数值';
--系统参数语言描述
create table system_parameter_descriptions (
  code              char(8)              not null, --编码
  ucode             varchar2(8)         null        , --关联信息
  lang              varchar2(5)          null        , --语言
  description       varchar2(256)        null        , --描述
  constraint pk_parameter_descriptions primary key (code)
);

comment on table system_parameter_descriptions is '系统参数语言描述';
comment on column system_parameter_descriptions.code is '编码';
comment on column system_parameter_descriptions.ucode is '关联信息';
comment on column system_parameter_descriptions.lang is '语言';
comment on column system_parameter_descriptions.description is '描述';

  
