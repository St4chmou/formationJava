-- Table: appliance

-- DROP TABLE appliance;

CREATE TABLE appliance
(
  id bigint NOT NULL,
  brand character varying(255),
  graduable boolean NOT NULL,
  power integer NOT NULL,
  model character varying(255),
  secured boolean NOT NULL,
  graduations integer NOT NULL,
  CONSTRAINT appliance_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE appliance
  OWNER TO minibase;
