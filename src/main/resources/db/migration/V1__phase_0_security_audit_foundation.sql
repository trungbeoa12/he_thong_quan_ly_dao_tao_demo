create table users (
    username varchar(50) primary key,
    password varchar(100) not null,
    enabled boolean not null
);

create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key (username) references users(username)
);

create unique index ix_auth_username on authorities (username, authority);

create table audit_log (
    id bigserial primary key,
    username varchar(100) not null,
    action varchar(100) not null,
    module varchar(100) not null,
    object_id varchar(100),
    old_value text,
    new_value text,
    created_at timestamp not null default current_timestamp
);

insert into users (username, password, enabled) values
('admin', '$2y$10$fPA9c7u0MvAXt4T4yBKBueO/WI7M7RYuvLfmgwOfQ3o/cz1Wnr0U.', true),
('trainingadmin', '$2y$10$FC4GKMnmsuo4b69.9ooQkO5LLnJWeFuB8ocoz1dONHQCMVDT6LlYW', true),
('instructor01', '$2y$10$LYcMkVaxWpFUAU3.V.0EOO6yEmJpdbEGSIohdVSeGDZWxwMXc3O5i', true),
('employee01', '$2y$10$/JbTjeoAWoPt3xbdIOGnCuIFXCBR89IJghvDJ86CmZd.eF0WudyAK', true),
('manager01', '$2y$10$.YCA3fqiqXQ9d0LbRsYXv.xhBTE8SrvjejTraWYnJRGM59rcE2HLa', true);

insert into authorities (username, authority) values
('admin', 'ROLE_ADMIN'),
('trainingadmin', 'ROLE_TRAINING_ADMIN'),
('instructor01', 'ROLE_INSTRUCTOR'),
('employee01', 'ROLE_EMPLOYEE'),
('manager01', 'ROLE_MANAGER');
