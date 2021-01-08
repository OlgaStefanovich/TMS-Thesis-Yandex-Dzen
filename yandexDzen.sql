CREATE TABLE users_test(
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR (50) NOT NULL,
	login VARCHAR (50)  NOT NULL,
	password VARCHAR (50) NOT NULL
);

CREATE TABLE posts(
	id BIGSERIAL PRIMARY KEY,
	title VARCHAR (2500) NOT NULL,
	description VARCHAR (2500) NOT NULL,
	text VARCHAR (25000) NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    views INTEGER NOT NULL,
	users_test_id  BIGSERIAL,
	FOREIGN KEY (users_test_id) REFERENCES users_test (id)
);
CREATE TABLE comments(
	id SERIAL PRIMARY KEY,
	text VARCHAR(250),
	users_test_id  BIGSERIAL,
	FOREIGN KEY (users_test_id) REFERENCES users_test (id),
             posts_id INTEGER,
              FOREIGN KEY(posts_id) REFERENCES posts(id),
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE likes(
    id SERIAL PRIMARY KEY,
   users_test_id BIGSERIAL,
   FOREIGN KEY(users_test_id) REFERENCES users_test (id),
   posts_id INTEGER,
   FOREIGN KEY(posts_id) REFERENCES posts (id)
);

ALTER TABLE POSTS
ALTER COLUMN "views" SET DEFAULT 0;
