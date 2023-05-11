-- Creación de la tabla Comanda
CREATE TABLE Comanda (
  Id INT PRIMARY KEY AUTO_INCREMENT,
  IdMesa INT NOT NULL,
  IdCamarero INT NOT NULL,
  UUID VARCHAR(255) NOT NULL,
  Date DATE NOT NULL,
  Hour TIME NOT NULL,
  RegistryDate DATETIME NOT NULL,
  ImporteComanda DOUBLE NOT NULL,
  NumComensales INT NOT NULL,
  FOREIGN KEY (IdMesa) REFERENCES Mesa(Id),
  FOREIGN KEY (IdCamarero) REFERENCES Camarero(Id)
);

-- Creación de la tabla LineaComanda
CREATE TABLE LineaComanda (
  IdLineaComanda INT PRIMARY KEY AUTO_INCREMENT,
  IdComanda INT NOT NULL,
  IdProducto INT NOT NULL,
  UdsProducto INT NOT NULL,
  FOREIGN KEY (IdComanda) REFERENCES Comanda(Id),
  FOREIGN KEY (IdProducto) REFERENCES Producto(Id)
);

-- Creación de la tabla Mesa
CREATE TABLE Mesa (
  Id INT PRIMARY KEY AUTO_INCREMENT,
  Ubicacion VARCHAR(255) NOT NULL,
  NumComensales INT NOT NULL
);

-- Creación de la tabla Producto
CREATE TABLE Producto (
  Id INT PRIMARY KEY AUTO_INCREMENT,
  Nombre VARCHAR(255) NOT NULL,
  Precio DECIMAL(10, 2) NOT NULL
);

-- Creación de la tabla Camarero
CREATE TABLE Camarero (
  Id INT PRIMARY KEY AUTO_INCREMENT,
  Nombre VARCHAR(255) NOT NULL,
  Apellido VARCHAR(255) NOT NULL
);
