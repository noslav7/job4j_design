create TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

create TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company(id, name)
values (1, 'Oracle'), (2, 'Microsoft'), (3, 'Google'), (4, 'Meta'), (5, 'Epam'), (6, 'Luxoft');

insert into person(id, name, company_id)
values (1, 'Michael', 1), (2, 'Andrew', 2), (3, 'James', 3), (4, 'Koushik', 2), (5, 'Sergey', 5), (6, 'Alice', 4);

select p.name, c.name
from person p
left join company c
on p.company_id = c.id
where c.id != 5;

select
  count(*),
  c.name
from
  person p
  join
  company c
  on p.company_id = c.id
group by
  c.name
HAVING COUNT(*) = (SELECT
  COUNT(company_id)
  from person p
  group BY company_id
  order by count(company_id) desc
  LIMIT 1);