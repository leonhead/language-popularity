USE program_languages;

INSERT INTO popularity (date_year, currency)
VALUES (2020, 5.0);

INSERT INTO popularity (date_year, currency)
VALUES (2020, 2.0);

INSERT INTO popularity (date_year, currency)
VALUES (2020, 0.0);

INSERT INTO popularity (date_year, currency)
VALUES (2020, 2.7);

INSERT INTO program_language (program_language_name)
VALUES ('Java');

INSERT INTO program_language (program_language_name)
VALUES ('C');

INSERT INTO program_language (program_language_name)
VALUES ('C++');

INSERT INTO program_language (program_language_name)
VALUES ('Python');

INSERT INTO github_repository (github_id, full_name, html_url, stargazers_count, program_language_id)
VALUES (1, 'vault/tresos', 'http://github.com/vault/tresos', 200, 1);

INSERT INTO github_repository (github_id, full_name, html_url, stargazers_count, program_language_id)
VALUES (2, 'unicorn/sun', 'http://github.com/unicorn/sun', 169, 3);

INSERT INTO github_repository (github_id, full_name, html_url, stargazers_count, program_language_id)
VALUES (3, 'prometheus/angle', 'http://github.com/prometheus/angle', 279, 3);

