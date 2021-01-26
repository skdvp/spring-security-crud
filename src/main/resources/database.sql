-- Table: users
CREATE TABLE preDB2421.users
(
    id       INT          NOT NULL AUTO_INCREMENT,

    name     varchar(255),
    surname  varchar(255),
    age      int          NOT NULL,

    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,

    PRIMARY KEY (id)
);

-- Table: roles
CREATE TABLE preDB2421.roles
(
    id   INT          NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,

    PRIMARY KEY (id)
);

-- Table for mapping user and roles: user_roles
CREATE TABLE preDB2421.user_roles
(
    user_id INT NOT NULL,
    role_id INT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id),

    UNIQUE (user_id, role_id)
);

INSERT preDB2421.users
VALUES (null, 'Admin', 'Admins', 35, 'ADMIN', 'ADMIN'),
       (null, 'Test', 'Users', 23, 'test', 'test'),
       (null, 'test2role', 'test2role', 33, 'test2role', 'test2role'),
       (null, 'test-user-del1', 'test-user-del1', 24, 'test-user-del1', 'test-user-del1'),
       (null, 'test-user-del2', 'test-user-del2', 55, 'test-user-del2', 'test-user-del2'),
       (null, 'test-admin-del1', 'test-admin-del1', 88, 'test-admin-del1', 'test-admin-del1'),
       (null, 'test-admin-del2', 'test-admin-del2', 26, 'test-admin-del2', 'test-admin-del2');

INSERT preDB2421.roles
VALUES (1, 'ROLE_USER'),
       (2, 'ROLE_ADMIN');

INSERT preDB2421.user_roles
VALUES (1, 2),
       (2, 1),
       (3, 2),
       (3, 1),
       (4, 1),
       (5, 1),
       (6, 2),
       (7, 2);
