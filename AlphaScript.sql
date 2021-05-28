DROP DATABASE IF EXISTS Alpha;
CREATE DATABASE Alpha;

USE Alpha;

#Projects
DROP TABLE IF EXISTS projects;
CREATE TABLE projects(
project_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
project_name VARCHAR(50) NOT NULL,
project_desc VARCHAR(300)
);

#Tasks
DROP TABLE IF EXISTS tasks;
CREATE TABLE tasks(
task_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
task_name VARCHAR(50) NOT NULL,
task_desc VARCHAR(300),
connected_project INT,
FOREIGN KEY (connected_project) REFERENCES projects(project_id)
);

#Subtasks
DROP TABLE IF EXISTS subtasks;
CREATE TABLE subtasks(
subtask_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
subtask_name VARCHAR(50) NOT NULL,
subtask_desc VARCHAR(300),
estimated_time DOUBLE NOT NULL,
connected_task INT,
FOREIGN KEY (connected_task) REFERENCES tasks(task_id)
);

#sletter denne Contraint i FK
ALTER TABLE subtasks DROP CONSTRAINT subtasks_ibfk_1;

#Add ny ContraintFK
ALTER TABLE subtasks
    ADD CONSTRAINT FK_tasks_subtasks_Cascade_Delete
        foreign key (connected_task) references tasks(task_id) on delete cascade;

#sletter constraint igen. Tror den skal eksikveres først før vi kan ADD constraint:
ALTER TABLE tasks DROP CONSTRAINT tasks_ibfk_1

#Add ny ConstraintFK
ALTER TABLE tasks
ADD CONSTRAINT FK_projects_tasks_Cascade_Delete
foreign key (connected_project) references projects(project_id) on delete cascade;
