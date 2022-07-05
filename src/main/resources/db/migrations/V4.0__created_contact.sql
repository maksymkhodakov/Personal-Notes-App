create table Contact (
                         id integer not null,
                         first TEXT,
                         last TEXT,
                         middle TEXT,
                         notes TEXT,
                         starred boolean not null,
                         website TEXT,
                         primary key (id)
);