BEGIN;

--Division table
CREATE TABLE IF NOT EXISTS public."Divisions"
(
    "division_id" integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    "division_name" character varying(100) NOT NULL,
    PRIMARY KEY ("division_id")
);

--Team table
CREATE TABLE IF NOT EXISTS public."Teams"
(
    "team_id" integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    "name" character varying NOT NULL,
    "division_id" integer NOT NULL,
    "logo_url" character varying DEFAULT 'https://cdn.pixabay.com/photo/2017/03/16/21/18/logo-2150297_1280.png',
    "wins" integer DEFAULT 0,
    "losses" integer DEFAULT 0,
    "ties" integer DEFAULT 0,
    "games_played" integer DEFAULT 0,
    "points" integer DEFAULT 0,
    "goals_for" integer DEFAULT 0,
    "goals_against" integer DEFAULT 0,
    "goal_difference" integer DEFAULT 0,
    "win_percentage" numeric(5, 2) GENERATED ALWAYS AS (CASE WHEN "games_played" = 0 THEN 0 ELSE ("wins" / "games_played") * 100 END) STORED,
    PRIMARY KEY ("team_id"),
    UNIQUE ("name"),
	FOREIGN KEY ("division_id") REFERENCES "Divisions"("division_id")
);

--Player table
CREATE TABLE IF NOT EXISTS public."Players"
(
    "player_id" integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    "first_name" character varying(50) NOT NULL,
    "last_name" character varying(50) NOT NULL,
    "photo_url" character varying DEFAULT 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png',
    "games_played" integer DEFAULT 0,
    "goals_scored" integer DEFAULT 0,
    "yellow_cards" integer DEFAULT 0,
    "red_cards" integer DEFAULT 0,
    "team_id" integer,
    PRIMARY KEY ("player_id"),
	FOREIGN KEY ("team_id") REFERENCES "Teams"("team_id")
);

--Match table
CREATE TABLE IF NOT EXISTS public."Matches"
(
    "match_id" integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    "home_team_id" integer NOT NULL,
    "away_team_id" integer NOT NULL,
    "location" character varying(100) NOT NULL,
    "date" timestamp without time zone[] NOT NULL,
	"is_played" boolean DEFAULT false,
    PRIMARY KEY ("match_id"),
	FOREIGN KEY ("home_team_id") REFERENCES "Teams"("team_id"),
	FOREIGN KEY ("away_team_id") REFERENCES "Teams"("team_id")
);

--Match_Result table
CREATE TABLE IF NOT EXISTS public."Match_Results"
(
	"result_id" integer NOT NULL GENERATED ALWAYS AS IDENTITY,
	"match_id" integer NOT NULL,
	"home_team_goal" integer NOT NULL,
	"away_team_goal" integer NOT NULL,
	PRIMARY KEY ("result_id"),
	FOREIGN KEY ("match_id") REFERENCES "Matches"("match_id")
);

--ENUM for result type
CREATE TYPE result AS ENUM ('win', 'lose', 'tie');

--Team_Match_Stat table
CREATE TABLE IF NOT EXISTS public."Team_Match_Stats"
(
	"team_id" integer NOT NULL,
	"match_id" integer NOT NULL,
	"goals_scored" integer NOT NULL,
	"goals_conceded" integer NOT NULL,
	"result" result NOT NULL,
	PRIMARY KEY ("team_id", "match_id"),
	FOREIGN KEY ("team_id") REFERENCES "Teams"("team_id"),
	FOREIGN KEY ("match_id") REFERENCES "Matches"("match_id")
);

--Player_Match_Stat table
CREATE TABLE IF NOT EXISTS public."Player_Match_Stats"
(
    "player_match_stat_id" integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    "match_id" integer NOT NULL,
    "player_id" integer NOT NULL,
    "red_cards" integer DEFAULT 0,
    "yellow_cards" integer DEFAULT 0,
    "goal_scored" integer DEFAULT 0,
    PRIMARY KEY ("player_match_stat_id"),
	FOREIGN KEY ("match_id") REFERENCES "Matches"("match_id"),
	FOREIGN KEY ("player_id") REFERENCES "Players"("player_id")
);

END;