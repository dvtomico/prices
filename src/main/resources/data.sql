CREATE TABLE prices (
	id integer,
	start_date timestamp,
	end_date timestamp,
    brand_id integer,
    price_list integer,
    product_id integer,
    priority integer,
    price decimal(10,2),
    currency varchar(3),
    last_update timestamp,
    last_update_by varchar(100)
);

INSERT INTO prices
(id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency, last_update, last_update_by)
VALUES (1, 1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR', '2020-03-26 14:49:07', 'user1');
INSERT INTO prices
(id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency, last_update, last_update_by)
VALUES (2, 1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR', '2020-05-26 15:38:22', 'user1');
INSERT INTO prices
(id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency, last_update, last_update_by)
VALUES (3, 1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR', '2020-05-26 15:39:22', 'user2');
INSERT INTO prices
(id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency, last_update, last_update_by)
VALUES (4, 1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR', '2020-06-02 10:14:00', 'user1');

