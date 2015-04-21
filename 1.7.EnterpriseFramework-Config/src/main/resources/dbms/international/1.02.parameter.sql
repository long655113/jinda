drop table system_parameters;
drop table system_parameter_descriptions;
--ϵͳ����
create table system_parameters (
  code        char(8)              not null, --��������
  name        varchar2(32)         null        , --��������
  value       varchar2(512)        null        , --����ֵ
  category    int                  default 2   , --�������ͣ�ȱʡΪҵ�����
  constraint pk_system_parameters primary key (code)
);

comment on table system_parameters is 'ϵͳ����';
comment on column system_parameters.code is '��������';
comment on column system_parameters.name is '��������';
comment on column system_parameters.value is '����ֵ';
--ϵͳ������������
create table system_parameter_descriptions (
  code              char(8)              not null, --����
  ucode             varchar2(8)         null        , --������Ϣ
  lang              varchar2(5)          null        , --����
  description       varchar2(256)        null        , --����
  constraint pk_parameter_descriptions primary key (code)
);

comment on table system_parameter_descriptions is 'ϵͳ������������';
comment on column system_parameter_descriptions.code is '����';
comment on column system_parameter_descriptions.ucode is '������Ϣ';
comment on column system_parameter_descriptions.lang is '����';
comment on column system_parameter_descriptions.description is '����';

  
