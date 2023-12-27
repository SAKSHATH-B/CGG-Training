create procedure countPhones (in personId int,out phoneCount int) language plpgsql as $$
begin
select count(*) into phoneCount from Phone p where p.person_id = personId;
end; $$