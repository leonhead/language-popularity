USE program_languages;

INSERT INTO program_language (program_language_name)
VALUES ('Java');

INSERT INTO program_language (program_language_name)
VALUES ('C');

INSERT INTO program_language (program_language_name)
VALUES ('C++');

INSERT INTO program_language (program_language_name)
VALUES ('Python');

INSERT INTO github_repository (full_name, html_url, stargazers_count, program_language_id)
VALUES ('vault/tresos', 'http://github.com/vault/tresos', 200, 1);

INSERT INTO github_repository (full_name, html_url, stargazers_count, program_language_id)
VALUES ('unicorn/sun', 'http://github.com/unicorn/sun', 169, 3);

INSERT INTO github_repository (full_name, html_url, stargazers_count, program_language_id)
VALUES ('prometheus/angle', 'http://github.com/prometheus/angle', 279, 3);

