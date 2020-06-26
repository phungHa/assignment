DROP TABLE track IF EXISTS;
DROP TABLE way_point IF EXISTS;
DROP TABLE track_point IF EXISTS;


CREATE TABLE track (
  id         INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(1024),
  description  VARCHAR(65535),
  created_date TIMESTAMP
);

CREATE TABLE way_point (
  id   INTEGER IDENTITY PRIMARY KEY,
  track_id INTEGER,
  latitude DECIMAL,
  longitude DECIMAL,
  name VARCHAR(1024),
  sym VARCHAR(1024)
);

ALTER TABLE way_point ADD CONSTRAINT fk_way_point_track FOREIGN KEY (track_id) REFERENCES track (id);

CREATE TABLE track_point (
  id   INTEGER IDENTITY PRIMARY KEY,
  track_id INTEGER,
  latitude DECIMAL,
  longitude DECIMAL,
  elevation DECIMAL,
  add_time TIMESTAMP
);
CREATE INDEX track_point_time ON track_point (add_time);
ALTER TABLE track_point ADD CONSTRAINT fk_track_point_track FOREIGN KEY (track_id) REFERENCES track (id);
