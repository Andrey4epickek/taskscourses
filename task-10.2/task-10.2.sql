USE task10;

/*1*/
SELECT model,speed,hd FROM pc WHERE price<500;
/*2*/
SELECT maker FROM product WHERE type='printer';
/*3*/
SELECT model,ram,screen FROM laptop WHERE price>1000;
/*4*/
SELECT * FROM printer WHERE color='y';
/*5*/
SELECT model,speed,hd FROM pc WHERE (cd='12X' OR cd='24x') AND price<600;
/*6*/
SELECT maker,speed From product INNER JOIN laptop ON product.model=laptop.model WHERE hd>=100;
/*7*/
SELECT laptop.model,laptop.price FROM laptop 
INNER JOIN product ON laptop.model=product.model 
WHERE product.maker='B'
UNION
SELECT pc.model,pc.price FROM pc 
INNER JOIN product ON pc.model=product.model 
WHERE product.maker='B'
UNION 
SELECT printer.model,printer.price FROM printer 
INNER JOIN product ON printer.model=product.model 
WHERE product.maker='B';
/*8*/
SELECT maker FROM product WHERE type='pc' AND maker NOT IN (SELECT maker FROM product WHERE type='laptop');
/*9*/
SELECT maker FROM pc INNER JOIN product ON pc.model=product.model WHERE speed>=450;
/*10*/
SELECT model,price FROM printer WHERE price=(SELECT MAX(price) FROM printer);
/*11*/
SELECT AVG(speed) FROM pc;
/*12*/
SELECT AVG(speed) FROM laptop WHERE price>1000;
/*13*/
SELECT AVG(speed) FROM pc INNER JOIN product ON pc.model=product.model WHERE maker='A';
/*14*/
SELECT speed,AVG(price) FROM pc GROUP BY speed;
/*15*/
SELECT hd FROM pc GROUP BY hd HAVING COUNT(model)>1;
/*16*/
SELECT DISTINCT A.model AS model,B.model AS model,A.speed,A.ram FROM pc AS A,pc B WHERE A.speed=B.speed AND A.ram=B.ram AND B.model<A.model;
/*17*/
SELECT DISTINCT type,laptop.model,speed FROM laptop INNER JOIN product ON laptop.model=product.model WHERE speed<(SELECT MIN(speed) FROM pc);
/*18*/
SELECT DISTINCT maker,price FROM printer INNER JOIN product ON printer.model=product.model WHERE price=(SELECT MIN(price) FROM printer WHERE color='y')AND color='y';
/*19*/
SELECT maker,AVG(screen) FROM laptop INNER JOIN product ON laptop.model=product.model GROUP BY maker;
/*20*/
SELECT maker,COUNT(model) FROM product WHERE type='pc' GROUP BY maker HAVING COUNT(model)>=3;
/*21*/
SELECT maker,MAX(price) FROM pc INNER JOIN product ON pc.model=product.model GROUP BY maker;
/*22*/
SELECT speed,AVG(price) FROM pc WHERE speed>600 GROUP BY speed;
/*23*/
SELECT DISTINCT maker FROM pc INNER JOIN product ON pc.model=product.model WHERE pc.speed>=750 AND maker IN(SELECT maker FROM laptop INNER JOIN product ON laptop.model=product.model WHERE laptop.speed>=750);
/*24*/
SELECT model FROM(
SELECT DISTINCT model,price FROM laptop WHERE laptop.price=(SELECT MAX(price) FROM laptop)
UNION 
SELECT DISTINCT model,price FROM pc WHERE pc.price=(SELECT MAX(price) FROM pc)
UNION
SELECT DISTINCT model,price FROM printer WHERE printer.price=(SELECT MAX(price) FROM printer))
AS a
WHERE a.price=(SELECT MAX(price) FROM(
SELECT DISTINCT price FROM laptop WHERE laptop.price=(SELECT MAX(price) FROM laptop)
UNION
SELECT DISTINCT price FROM pc WHERE pc.price=(SELECT MAX(price) FROM pc)
UNION
SELECT DISTINCT price FROM printer WHERE printer.price=(SELECT MAX(price) FROM printer))
AS a1);
/*25*/
SELECT DISTINCT maker FROM product WHERE model IN (SELECT model FROM pc WHERE ram = (SELECT MIN(ram) FROM pc)
AND speed = (SELECT MAX(speed) FROM pc WHERE ram = (SELECT MIN(ram)FROM pc)))
AND maker IN (SELECT maker FROM product WHERE type='printer');


