
DROP DATABASE IF EXISTS hr_dev_db;

CREATE DATABASE hr_dev_db;
USE hr_dev_db;

CREATE TABLE `departments` (
  `deptno` int(11) NOT NULL,
  `dname` varchar(100) DEFAULT NULL,
  `loc` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE `employees` (
  `empno` int(11) NOT NULL,
  `ename` varchar(100) DEFAULT NULL,
  `job` varchar(100) DEFAULT NULL,
  `mgr` int(11) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` decimal(7,2) DEFAULT NULL,
  `comm` decimal(7,2) DEFAULT NULL,
  `deptno` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE `users_credentials` (
  `user_id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` BOOLEAN DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `employee_empno` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



INSERT INTO `employees` (`empno`, `ename`, `job`, `mgr`, `hiredate`, `sal`, `comm`, `deptno`) VALUES
(120, 'Selim', 'Horri', 7782, '2019-04-15', '900.00', NULL, 10),
(121, 'Amine', 'Ladjimi', 7782, '2020-01-01', '800.00', NULL, 10),
(7369, 'SMITH', 'CLERK', 7902, '1980-12-17', '800.00', NULL, 20),
(7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', '1600.00', '300.00', 30),
(7521, 'WARD', 'SALESMAN', 7698, '1981-02-22', '1250.00', '500.00', 30),
(7566, 'JONES', 'MANAGER', 7839, '1981-04-02', '2975.00', NULL, 20),
(7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', '1250.00', '1400.00', 30),
(7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01', '2850.00', NULL, 30),
(7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', '2450.00', NULL, 10),
(7788, 'SCOTT', 'ANALYST', 7566, '1982-12-09', '3000.00', NULL, 20),
(7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', '5000.00', NULL, 10),
(7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', '1500.00', '0.00', 30),
(7876, 'ADAMS', 'CLERK', 7788, '1983-01-12', '1100.00', NULL, 20),
(7900, 'JAMES', 'CLERK', 7698, '1981-12-03', '950.00', NULL, 30),
(7902, 'FORD', 'ANALYST', 7566, '1981-12-03', '3000.00', NULL, 20),
(7934, 'MILLER', 'CLERK', 7782, '1982-01-23', '1300.00', NULL, 10);

INSERT INTO `departments` (`deptno`, `dname`, `loc`) VALUES
(10, 'ACCOUNTING', 'NEW YORK'),
(20, 'RESEARCH', 'DALLAS'),
(30, 'SALES', 'CHICAGO'),
(40, 'OPERATIONS', 'BOSTON');

INSERT INTO `users_credentials` (`user_id`, `username`, `password`, `enabled`, `role`) VALUES
(1, 'selimhorri', '$2y$12$g1zWC1G1Ywl7pQzfsuj86uMI2XsK8QQuhpYL7LR7C1JIkwdYzTskG', true, 'ROLE_ADMIN'), -- 0000
(2, 'amineladjimi', '$2y$12$UVxchYn/NzwNIOX4cAJix.B8Hst444hutFwBDHLPXIEmvjhicZx.S', true, 'ROLE_EMP'); -- 0000



ALTER TABLE `departments`
  ADD PRIMARY KEY (`deptno`);


ALTER TABLE `employees`
  ADD PRIMARY KEY (`empno`),
  ADD KEY `fk_deptno` (`deptno`);



ALTER TABLE `users_credentials`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `UK_jnxb7p6y6vcj83xvsg0j9u8nn` (`username`),
  ADD KEY `FKbvft0s8o9iub8k7c55ewvhnmm` (`employee_empno`);



ALTER TABLE `users_credentials`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;



ALTER TABLE `employees`
  ADD CONSTRAINT `fk_deptno` FOREIGN KEY (`deptno`) REFERENCES `departments` (`deptno`);



ALTER TABLE `users_credentials`
  ADD CONSTRAINT `FKbvft0s8o9iub8k7c55ewvhnmm` FOREIGN KEY (`employee_empno`) REFERENCES `employees` (`empno`);

-- *********************** 

DROP DATABASE IF EXISTS hr_test_db;

CREATE DATABASE hr_test_db;
USE hr_test_db;

CREATE TABLE `departments` (
  `deptno` int(11) NOT NULL,
  `dname` varchar(100) DEFAULT NULL,
  `loc` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE `employees` (
  `empno` int(11) NOT NULL,
  `ename` varchar(100) DEFAULT NULL,
  `job` varchar(100) DEFAULT NULL,
  `mgr` int(11) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` decimal(7,2) DEFAULT NULL,
  `comm` decimal(7,2) DEFAULT NULL,
  `deptno` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE `users_credentials` (
  `user_id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` BOOLEAN DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `employee_empno` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



INSERT INTO `employees` (`empno`, `ename`, `job`, `mgr`, `hiredate`, `sal`, `comm`, `deptno`) VALUES
(120, 'Selim', 'Horri', 7782, '2019-04-15', '900.00', NULL, 10),
(121, 'Amine', 'Ladjimi', 7782, '2020-01-01', '800.00', NULL, 10),
(7369, 'SMITH', 'CLERK', 7902, '1980-12-17', '800.00', NULL, 20),
(7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', '1600.00', '300.00', 30),
(7521, 'WARD', 'SALESMAN', 7698, '1981-02-22', '1250.00', '500.00', 30),
(7566, 'JONES', 'MANAGER', 7839, '1981-04-02', '2975.00', NULL, 20),
(7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', '1250.00', '1400.00', 30),
(7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01', '2850.00', NULL, 30),
(7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', '2450.00', NULL, 10),
(7788, 'SCOTT', 'ANALYST', 7566, '1982-12-09', '3000.00', NULL, 20),
(7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', '5000.00', NULL, 10),
(7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', '1500.00', '0.00', 30),
(7876, 'ADAMS', 'CLERK', 7788, '1983-01-12', '1100.00', NULL, 20),
(7900, 'JAMES', 'CLERK', 7698, '1981-12-03', '950.00', NULL, 30),
(7902, 'FORD', 'ANALYST', 7566, '1981-12-03', '3000.00', NULL, 20),
(7934, 'MILLER', 'CLERK', 7782, '1982-01-23', '1300.00', NULL, 10);

INSERT INTO `departments` (`deptno`, `dname`, `loc`) VALUES
(10, 'ACCOUNTING', 'NEW YORK'),
(20, 'RESEARCH', 'DALLAS'),
(30, 'SALES', 'CHICAGO'),
(40, 'OPERATIONS', 'BOSTON');

INSERT INTO `users_credentials` (`user_id`, `username`, `password`, `enabled`, `role`) VALUES
(1, 'selimhorri', '$2y$12$g1zWC1G1Ywl7pQzfsuj86uMI2XsK8QQuhpYL7LR7C1JIkwdYzTskG', true, 'ROLE_ADMIN'), -- 0000
(2, 'amineladjimi', '$2y$12$UVxchYn/NzwNIOX4cAJix.B8Hst444hutFwBDHLPXIEmvjhicZx.S', true, 'ROLE_EMP'); -- 0000



ALTER TABLE `departments`
  ADD PRIMARY KEY (`deptno`);


ALTER TABLE `employees`
  ADD PRIMARY KEY (`empno`),
  ADD KEY `fk_deptno` (`deptno`);



ALTER TABLE `users_credentials`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `UK_jnxb7p6y6vcj83xvsg0j9u8nn` (`username`),
  ADD KEY `FKbvft0s8o9iub8k7c55ewvhnmm` (`employee_empno`);



ALTER TABLE `users_credentials`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;



ALTER TABLE `employees`
  ADD CONSTRAINT `fk_deptno` FOREIGN KEY (`deptno`) REFERENCES `departments` (`deptno`);



ALTER TABLE `users_credentials`
  ADD CONSTRAINT `FKbvft0s8o9iub8k7c55ewvhnmm` FOREIGN KEY (`employee_empno`) REFERENCES `employees` (`empno`);

-- *********************** 

DROP DATABASE IF EXISTS hr_prod_db;

CREATE DATABASE hr_prod_db;
USE hr_prod_db;

CREATE TABLE `departments` (
  `deptno` int(11) NOT NULL,
  `dname` varchar(100) DEFAULT NULL,
  `loc` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE `employees` (
  `empno` int(11) NOT NULL,
  `ename` varchar(100) DEFAULT NULL,
  `job` varchar(100) DEFAULT NULL,
  `mgr` int(11) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` decimal(7,2) DEFAULT NULL,
  `comm` decimal(7,2) DEFAULT NULL,
  `deptno` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE `users_credentials` (
  `user_id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` BOOLEAN DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `employee_empno` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



INSERT INTO `employees` (`empno`, `ename`, `job`, `mgr`, `hiredate`, `sal`, `comm`, `deptno`) VALUES
(120, 'Selim', 'Horri', 7782, '2019-04-15', '900.00', NULL, 10),
(121, 'Amine', 'Ladjimi', 7782, '2020-01-01', '800.00', NULL, 10),
(7369, 'SMITH', 'CLERK', 7902, '1980-12-17', '800.00', NULL, 20),
(7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', '1600.00', '300.00', 30),
(7521, 'WARD', 'SALESMAN', 7698, '1981-02-22', '1250.00', '500.00', 30),
(7566, 'JONES', 'MANAGER', 7839, '1981-04-02', '2975.00', NULL, 20),
(7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', '1250.00', '1400.00', 30),
(7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01', '2850.00', NULL, 30),
(7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', '2450.00', NULL, 10),
(7788, 'SCOTT', 'ANALYST', 7566, '1982-12-09', '3000.00', NULL, 20),
(7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', '5000.00', NULL, 10),
(7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', '1500.00', '0.00', 30),
(7876, 'ADAMS', 'CLERK', 7788, '1983-01-12', '1100.00', NULL, 20),
(7900, 'JAMES', 'CLERK', 7698, '1981-12-03', '950.00', NULL, 30),
(7902, 'FORD', 'ANALYST', 7566, '1981-12-03', '3000.00', NULL, 20),
(7934, 'MILLER', 'CLERK', 7782, '1982-01-23', '1300.00', NULL, 10);

INSERT INTO `departments` (`deptno`, `dname`, `loc`) VALUES
(10, 'ACCOUNTING', 'NEW YORK'),
(20, 'RESEARCH', 'DALLAS'),
(30, 'SALES', 'CHICAGO'),
(40, 'OPERATIONS', 'BOSTON');

INSERT INTO `users_credentials` (`user_id`, `username`, `password`, `enabled`, `role`) VALUES
(1, 'selimhorri', '$2y$12$g1zWC1G1Ywl7pQzfsuj86uMI2XsK8QQuhpYL7LR7C1JIkwdYzTskG', true, 'ROLE_ADMIN'), -- 0000
(2, 'amineladjimi', '$2y$12$UVxchYn/NzwNIOX4cAJix.B8Hst444hutFwBDHLPXIEmvjhicZx.S', true, 'ROLE_EMP'); -- 0000



ALTER TABLE `departments`
  ADD PRIMARY KEY (`deptno`);


ALTER TABLE `employees`
  ADD PRIMARY KEY (`empno`),
  ADD KEY `fk_deptno` (`deptno`);



ALTER TABLE `users_credentials`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `UK_jnxb7p6y6vcj83xvsg0j9u8nn` (`username`),
  ADD KEY `FKbvft0s8o9iub8k7c55ewvhnmm` (`employee_empno`);



ALTER TABLE `users_credentials`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;



ALTER TABLE `employees`
  ADD CONSTRAINT `fk_deptno` FOREIGN KEY (`deptno`) REFERENCES `departments` (`deptno`);



ALTER TABLE `users_credentials`
  ADD CONSTRAINT `FKbvft0s8o9iub8k7c55ewvhnmm` FOREIGN KEY (`employee_empno`) REFERENCES `employees` (`empno`);






COMMIT;








