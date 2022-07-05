CREATE TABLE IF NOT EXISTS users(
                                    id BIGSERIAL CONSTRAINT users_pk PRIMARY KEY,
                                    first_name TEXT NOT NULL,
                                    last_name TEXT NOT NULL,
                                    email TEXT NOT NULL CONSTRAINT users_email_pk UNIQUE
);


CREATE TABLE IF NOT EXISTS videos(
                                     id BIGSERIAL CONSTRAINT videos_pk PRIMARY KEY,
                                     name TEXT NOT NULL,
                                     location TEXT NOT NULL,
                                     uploaded_at TIMESTAMP DEFAULT now()
);

CREATE TABLE IF NOT EXISTS comments(
                                       id BIGSERIAL CONSTRAINT comments_pk PRIMARY KEY,
                                       body TEXT NOT NULL,
                                       user_id BIGINT CONSTRAINT comments_users_fk REFERENCES users(id),
                                       video_id BIGINT CONSTRAINT comments_videos_fk REFERENCES videos(id),
                                       created_at TIMESTAMP DEFAULT now()
);

