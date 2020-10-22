--1. Написать запрос получение всех продуктов с типом "СЫР"
SELECT *
FROM product
         join type t on product.type_id = t.id
WHERE t.name = 'сыр';
-- 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
SELECT *
FROM product
WHERE name LIKE '%Мороженое%';
-- 3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
SELECT *
FROM product
WHERE expired_date
          BETWEEN date_trunc('month', now() + interval '1 month')
          AND date_trunc('month', now() + interval '1 month') + interval '1 month';
-- 4. Написать запрос, который выводит самый дорогой продукт.
SELECT name
from product
where price = (SELECT max(price) from product);
-- 5. Написать запрос, который выводит количество всех продуктов определенного типа.
SELECT t.name, count(product.name)
from product
         join type t on product.type_id = t.id
group by t.name;
-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
SELECT product.name
FROM product
         join type t on product.type_id = t.id
WHERE t.name = 'сыр'
   OR t.name = 'молоко';
-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
SELECT t.name
FROM product
         join type t on product.type_id = t.id
group by t.name
having count(t.name) < 10;
-- 8. Вывести все продукты и их тип.
SELECT product.name, t.name
FROM product
         join type t on product.type_id = t.id;