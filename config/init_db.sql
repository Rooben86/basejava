CREATE TABLE resume
(
    uuid      CHAR(36) PRIMARY KEY NOT NULL,
    full_name text                 NOT NULL
);

create table contact
(
    id          SERIAL PRIMARY KEY,
    resume_uuid CHAR(36) NOT NULL REFERENCES resume (uuid) on delete cascade,
    type        TEXT     NOT NULL,
    value       TEXT     NOT NULL
);

create unique index contact_uuid_type_index
    on contact (resume_uuid, type);

create table section
(
    id          SERIAL PRIMARY KEY,
    resume_uuid CHAR(36) not null references resume (uuid) on delete cascade,
    type        TEXT     not null,
    content     TEXT     not null
);
create unique index section_idx ON section (resume_uuid, type);
