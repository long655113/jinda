drop view v_system_menus;
create view v_system_menus as 
  select a.code,
         a.ucode,
         a.seq,
         a.status,
         a.url,
         a.css,
         b.lang,
         b.title,
         b.description
    from system_menus a,
         system_menu_descriptions b
   where b.ucode = a.code;

create view v_system_parameters
  as select * from system_parameters;


create view v_system_regions as
  select a.id,a.parentid,a.rank,a.postcode,a.seq,a.rank1,a.rank2,a.rank3,a.rank4,
         a.rank5,a.rank6,a.rank7,a.rank8,a.rank9,b.name title,b.lang,b.description 
    from system_regions a,system_region_descriptions b
   where a.id = b.ucode;

create view v_system_roles
  as 
  select a.code,
         a.rank,
         a.rank1,
         a.rank2,
         a.rank3,
         a.rank4,
         a.rank5,
         a.rank6,
         a.rank7,
         a.rank8,
         a.rank9,
         a.ucode,
         b.lang,
         b.name,
         b.description
    from system_roles a,
         system_role_descriptions b
   where b.parent_id = a.code;     