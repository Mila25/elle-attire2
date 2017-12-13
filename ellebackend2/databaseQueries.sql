CREATE TABLE category (

	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY (id)
	
);


INSERT INTO category (name,description,image_url,is_active) VALUES ('Ethnic', 'Ethinc is traditional wear', 'tom1.png', true);
INSERT INTO category (name,description,image_url,is_active) VALUES ('Western', 'It is still Special in Clothing', 'tom2.png', true);
INSERT INTO category (name,description,image_url,is_active) VALUES ('Casual', 'Stay comfort and Casual in your attire', 'tom3.png', true);


CREATE TABLE user_detail (

	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(50),
	email VARCHAR(100),
	contact_number VARCHAR(15),
	CONSTRAINT pk_user_id PRIMARY KEY(id),
	
);

INSERT INTO user_detail
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Sharmila', 'Mani', 'ADMIN', true, 'admin', 'sm@gmail.com', '9999999999' );

INSERT INTO user_detail
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Krishna', 'Tejus', 'SUPPLIER', true, '12345', 'kt@gmail.com', '8888888888' );

INSERT INTO user_detail
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Anushya', 'Selvam', 'SUPPLIER', true, '12345', 'as@gmail.com', '7777777777' );

CREATE TABLE product (
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail (id),
);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('EASALWRX2050Q', 'Salwar', 'Soch', 'This is one of the best outfit available in the market right now!', 12000, 4, true, 1, 1 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('EACHOLIX3070T', 'Choli', 'Kay', 'Special for the queen in you', 32000, 7, true, 1, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('EASKIRTX4050F', 'Skirt', 'DaisyStreet', 'Go on a good collection with Skirts', 15000, 75, true, 2, 3 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('EAKURTIX5090R', ' kurti', 'Max', 'Look good is to feel good', 2000, 150, true, 3, 1 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('EAJEANSX6080Y', 'Tracks', 'Adidas', 'Be comfortable and fit enough!', 4000, 50, true, 3, 2 );




