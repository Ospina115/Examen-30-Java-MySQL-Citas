DROP DATABASE public;
CREATE DATABASE public;
USE public;

//***********************//
//* CREACION DE TABLAS  *//
//***********************//

CREATE TABLE Paciente (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  apellido VARCHAR(50) NOT NULL,
  fecha_nacimiento DATE NOT NULL,
  dirección VARCHAR(100) NOT NULL,
  teléfono VARCHAR(20) NOT NULL,
  email VARCHAR(50) NOT NULL
);

CREATE TABLE Especialidad (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL
);

CREATE TABLE Médico (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  especialidad_id INT NOT NULL,
  horario_inicio TIME NOT NULL,
  horario_fin TIME NOT NULL,
  FOREIGN KEY (especialidad_id) REFERENCES Especialidad(id)
);

CREATE TABLE Cita (
  id INT PRIMARY KEY AUTO_INCREMENT,
  paciente_id INT NOT NULL,
  medico_id INT NOT NULL,
  fecha_hora DATETIME NOT NULL,
  estado VARCHAR(20) NOT NULL,
  FOREIGN KEY (paciente_id) REFERENCES Paciente(id),
  FOREIGN KEY (medico_id) REFERENCES Médico(id)
);

CREATE TABLE users(
   id INT AUTO_INCREMENT PRIMARY KEY,
   enabled BOOLEAN,
   username VARCHAR(12),
   password VARCHAR(255)
);