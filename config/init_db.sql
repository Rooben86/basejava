CREATE TABLE resume
(
    uuid      CHAR(36) PRIMARY KEY NOT NULL,
    full_name text                 NOT NULL
);

create table contact
(
    id          SERIAL PRIMARY KEY,
    resume_uuid CHAR(36) NOT NULL REFERENCES resume (uuid),
    type        TEXT     NOT NULL,
    value       TEXT     NOT NULL
);

create unique index contact_uuid_type_index
    on contact (resume_uuid, type);
