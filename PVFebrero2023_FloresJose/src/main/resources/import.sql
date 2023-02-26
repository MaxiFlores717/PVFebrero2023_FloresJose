/* Populate tables */
INSERT INTO Usuario (DNI, nombre, apellido, fecha_nacimiento, password, tipo_usuario) VALUES(1, 'Maxi', 'Flores', '2017-08-28', 'a', 'Docente');
INSERT INTO Usuario (DNI, nombre, apellido, fecha_nacimiento, password, tipo_usuario) VALUES(2, 'Jose', 'Flores', '2011-02-21', 'p', 'Estudiante');
INSERT INTO Pregunta (cod_pregunta, enunciado, nivel, opcion01, opcion02, opcion03, opcion04, opcion, puntaje) VALUES(1, '1+1=?', 1, '1', '2', '3', '4','2', 10);
INSERT INTO Pregunta (cod_pregunta, enunciado, nivel, opcion01, opcion02, opcion03, opcion04, opcion, puntaje) VALUES(2, '1+2=?', 1, '1', '2', '3', '4','3', 10);
INSERT INTO Pregunta (cod_pregunta, enunciado, nivel, opcion01, opcion02, opcion03, opcion04, opcion, puntaje) VALUES(3, 'messi es:', 2, 'Argentino', 'Uruguayo', 'Frances', 'Espanol','Argentino', 10);