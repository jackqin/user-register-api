-- Table: "user"

DROP TABLE IF EXISTS "user";
--DROP TYPE IF EXISTS user_status;
DROP SEQUENCE IF EXISTS user_seq;

-- CREATE TYPE user_status AS ENUM ('status1', 'status2', 'status3');
CREATE TABLE "user"
(
  id bigint NOT NULL,
  email character varying(40) NOT NULL,
  passwd character varying(41) NOT NULL,
  salt character varying(8) NOT NULL,
  create_time timestamp without time zone NOT NULL,
  status character varying(12) NOT NULL,
  --status user_status DEFAULT 'status2'::user_status,
  CONSTRAINT pk_id PRIMARY KEY (id),
  CONSTRAINT unique_email UNIQUE (email)
)
WITH ( OIDS=FALSE );
ALTER TABLE "user" OWNER TO postgres;

-- Index: index_email

-- DROP INDEX index_email;

CREATE INDEX index_email ON "user" USING btree (email);

-- Sequence: seq_user

-- DROP SEQUENCE seq_user;

CREATE SEQUENCE user_seq
  INCREMENT 1
  MINVALUE 11000
  MAXVALUE 9223372036854775807
  START 11000
  CACHE 1;
ALTER TABLE user_seq OWNER TO postgres;