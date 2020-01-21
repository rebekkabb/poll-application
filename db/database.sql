CREATE TABLE "users" (
  "id" BIGSERIAL PRIMARY KEY,
  "name" varchar,
  "password" varchar
);

CREATE TABLE "polls" (
  "id" BIGSERIAL PRIMARY KEY,
  "user_id" int UNIQUE NOT NULL,
  "title" varchar,
  "time_created" timestamp,
  "duplication_check" varchar DEFAULT 'browser cookies',
  "multiple_answers" boolean DEFAULT false,
  "url" varchar
);

CREATE TABLE "poll_options" (
  "id" BIGSERIAL PRIMARY KEY,
  "poll_id" int NOT NULL,
  "option" varchar,
  "votes" int
);

ALTER TABLE "polls" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "poll_options" ADD FOREIGN KEY ("poll_id") REFERENCES "polls" ("id");
