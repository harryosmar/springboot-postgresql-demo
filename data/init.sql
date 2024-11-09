-- -------------------------------------------------------------
-- TablePlus 5.9.8(548)
--
-- https://tableplus.com/
--
-- Database: demo
-- Generation Time: 2024-11-09 16:17:13.1830
-- -------------------------------------------------------------


DROP TABLE IF EXISTS "public"."users";
-- This script only contains the table creation statements and does not fully represent the table in the database. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."users" (
                                  id SERIAL PRIMARY KEY,
                                  "username" varchar(255) NOT NULL,
                                  "password" varchar(255) NOT NULL,
                                  "role" varchar(255) NOT NULL,
                                  "is_active" bool,
                                  "created_at" timestamp,
                                  "created_by" varchar(255),
                                  "updated_at" timestamp,
                                  "updated_by" varchar(255),
                                  "deleted_at" timestamp,
                                  "deleted_by" varchar(255),
                                  "is_deleted" bool
);

-- Indices
CREATE UNIQUE INDEX users_id_key ON public.users USING btree (id);
CREATE UNIQUE INDEX users_username_key ON public.users USING btree (username);
INSERT INTO "public"."users" ("id", "username", "password", "role", "is_active", "created_at", "created_by", "updated_at", "updated_by", "deleted_at", "deleted_by", "is_deleted") VALUES
    (1, 'username', '$2a$10$ALjqBQekMpCjB/Rg7CAMD.hUVh4XCesYUZvFEnJ9RLYaZD6CQl7Km', 'admin', true, NULL, NULL, NULL, NULL, NULL, NULL, FALSE);



DROP TABLE IF EXISTS "public"."products";
-- This script only contains the table creation statements and does not fully represent the table in the database. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."products" (
                                  id SERIAL PRIMARY KEY,
                                  "name" varchar(255) NOT NULL,
                                  "stock" INT NOT NULL,
                                  "created_at" timestamp,
                                  "created_by" varchar(255),
                                  "updated_at" timestamp,
                                  "updated_by" varchar(255),
                                  "deleted_at" timestamp,
                                  "deleted_by" varchar(255),
                                  "is_deleted" bool
);

-- Indices
CREATE UNIQUE INDEX products_id_key ON public.products USING btree (id);

INSERT INTO "public"."products" ("id", "name", "stock", "created_at", "created_by", "updated_at", "updated_by", "deleted_at", "deleted_by", "is_deleted") VALUES
    (1, 'tupperware', 100, NULL, NULL, NULL, NULL, NULL, NULL, false);


DROP TABLE IF EXISTS "public"."transactions";
-- This script only contains the table creation statements and does not fully represent the table in the database. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."transactions" (
                                     id varchar(255),
                                     "product_id" INT REFERENCES products(id),
                                     "qty" INT NOT NULL,
                                     "is_void" bool,
                                     "created_at" timestamp,
                                     "created_by" varchar(255),
                                     "updated_at" timestamp,
                                     "updated_by" varchar(255),
                                     "deleted_at" timestamp,
                                     "deleted_by" varchar(255),
                                     "is_deleted" bool
);

-- Indices
CREATE UNIQUE INDEX transactions_id_key ON public.transactions USING btree (id);
CREATE INDEX transactions_product_id_key ON public.transactions USING hash (product_id);

INSERT INTO "public"."transactions" ("id", "product_id", "qty", "is_void", "created_at", "created_by", "updated_at", "updated_by", "deleted_at", "deleted_by", "is_deleted") VALUES
    ('2ee6ba31-cbe1-48ac-acbb-0d4db7906913', 1, 1, false, NULL, NULL, NULL, NULL, NULL, NULL, false);