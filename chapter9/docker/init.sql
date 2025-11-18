CREATE TABLE IF NOT EXISTS public.customers
(
    customer_id text COLLATE pg_catalog."default" NOT NULL,
    first_name text COLLATE pg_catalog."default",
    last_name text COLLATE pg_catalog."default",
    email text COLLATE pg_catalog."default",
    address text COLLATE pg_catalog."default",
    comment text COLLATE pg_catalog."default",
    CONSTRAINT customers_pkey PRIMARY KEY (customer_id)
)

TABLESPACE pg_default;

ALTER TABLE public.customers
    OWNER to postgres;


CREATE TABLE IF NOT EXISTS public.inventory
(
    inventory_id text COLLATE pg_catalog."default" NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    category text COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default" NOT NULL,
    stock text COLLATE pg_catalog."default" NOT NULL,
    comment text COLLATE pg_catalog."default",
    CONSTRAINT inventory_pkey PRIMARY KEY (inventory_id)
)

TABLESPACE pg_default;

ALTER TABLE public.inventory
    OWNER to postgres;


CREATE TABLE IF NOT EXISTS public.orders
(
    orders_id text COLLATE pg_catalog."default" NOT NULL,
    orders_number text COLLATE pg_catalog."default" NOT NULL,
    orders_status text COLLATE pg_catalog."default",
    customer_name text COLLATE pg_catalog."default" NOT NULL,
    order_date text COLLATE pg_catalog."default" NOT NULL,
    cart_id text COLLATE pg_catalog."default" NOT NULL,
    comment text COLLATE pg_catalog."default",
    CONSTRAINT orders_pkey PRIMARY KEY (orders_id)
)

TABLESPACE pg_default;

ALTER TABLE public.orders
    OWNER to postgres;