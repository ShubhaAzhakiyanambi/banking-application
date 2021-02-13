CREATE SCHEMA bank_app;

CREATE TABLE bank_app.account (
    id bigint NOT NULL PRIMARY KEY,
    account_number CHAR(8) NOT NULL,
    current_balance NUMERIC(10,3) NOT NULL,
    bank_name VARCHAR(50) NOT NULL,
    owner_name VARCHAR(50) NOT NULL,
    UNIQUE (account_number)
);

CREATE SEQUENCE bank_app.transaction_sequence START WITH 5;
CREATE TABLE bank_app.transaction (
    id bigint NOT NULL PRIMARY KEY,
    source_account_id bigint NOT NULL REFERENCES bank_app.account(id),
    target_account_id bigint NOT NULL REFERENCES bank_app.account(id),
    target_owner_name varchar(50) NOT NULL,
    amount NUMERIC(10,3) NOT NULL,
    initiation_date timestamp NOT NULL,
    completion_date TIMESTAMP,
    reason VARCHAR(255)
);

INSERT INTO bank_app.account (id, account_number, current_balance, bank_name, owner_name)
VALUES (1, '73084635', 1071.78, 'ABC Bank', 'Test User1');
INSERT INTO bank_app.account (id, account_number, current_balance, bank_name, owner_name)
VALUES (2, '21956204', 67051.01, 'XYZ Bank', 'Test User2');

INSERT INTO bank_app.transaction (id, source_account_id, target_account_id, target_owner_name, amount, initiation_date, completion_date, reason)
VALUES (1, 1, 2, 'Test User2', 100.00, '2021-01-10 10:30', '2021-01-10 10:54', 'Protection charge Jan');
INSERT INTO bank_app.transaction (id, source_account_id, target_account_id, target_owner_name, amount, initiation_date, completion_date, reason)
VALUES (2, 1, 2, 'Test User2', 100.00, '2021-02-11 10:30', '2021-02-11 11:21', 'Protection charge Feb');

INSERT INTO bank_app.transaction (id, source_account_id, target_account_id, target_owner_name, amount, initiation_date, completion_date, reason)
VALUES (3, 2, 1, 'Test User1', 10000.00, '2021-01-27 17:21', null, 'Savings');
