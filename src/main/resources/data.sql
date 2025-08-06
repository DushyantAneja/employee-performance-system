-- Insert Departments
INSERT INTO department (name, budget) VALUES ('HR', 100000.00);
INSERT INTO department (name, budget) VALUES ('Sales', 200000.00);

-- Insert Projects
INSERT INTO projects (id, name, start_date, department_id) VALUES (1, 'ERP', '2023-01-01', 1);
INSERT INTO projects (id, name, start_date, department_id) VALUES (2, 'CRM', '2023-02-01', 2);

-- Insert Employees
INSERT INTO employees (id, name, email, department_id, date_of_joining, salary, manager_id)
VALUES (1, 'John Doe', 'john@example.com', 1, '2022-01-01', 50000.00, NULL);
INSERT INTO employees (id, name, email, department_id, date_of_joining, salary, manager_id)
VALUES (2, 'Jane Smith', 'jane@example.com', 2, '2022-02-01', 60000.00, 1);
INSERT INTO employees (id, name, email, department_id, date_of_joining, salary, manager_id)
VALUES (3, 'Bob Johnson', 'bob@example.com', 1, '2022-03-01', 55000.00, 1);

-- Insert Performance Reviews
INSERT INTO performance_reviews (id, employee_id, review_date, score, review_comments)
VALUES (1, 1, '2024-01-01', 80, 'Good performance');
INSERT INTO performance_reviews (id, employee_id, review_date, score, review_comments)
VALUES (2, 1, '2023-07-01', 85, 'Excellent teamwork');
INSERT INTO performance_reviews (id, employee_id, review_date, score, review_comments)
VALUES (3, 1, '2023-01-01', 75, 'Needs improvement in time management');
INSERT INTO performance_reviews (id, employee_id, review_date, score, review_comments)
VALUES (4, 2, '2024-01-01', 90, 'Outstanding leadership');

-- Insert Employee-Project Associations
INSERT INTO employee_project (id, employee_id, project_id, assigned_date, role)
VALUES (1, 1, 1, '2023-01-01', 'Developer');
INSERT INTO employee_project (id, employee_id, project_id, assigned_date, role)
VALUES (2, 1, 2, '2023-02-01', 'Lead');
INSERT INTO employee_project (id, employee_id, project_id, assigned_date, role)
VALUES (3, 2, 1, '2023-01-01', 'Manager');
INSERT INTO employee_project (id, employee_id, project_id, assigned_date, role)
VALUES (4, 3, 2, '2023-02-01', 'Analyst');