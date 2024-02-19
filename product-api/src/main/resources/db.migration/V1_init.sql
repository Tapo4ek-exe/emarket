CREATE TABLE Category (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    parentCategoryId BIGINT REFERENCES Category(id) ON DELETE SET NULL NULL
);

CREATE TABLE Product (
                          id BIGSERIAL PRIMARY KEY,
                          brand VARCHAR(255) NOT NULL,
                          model VARCHAR(255) NOT NULL,
                          itemNumber VARCHAR(255) NOT NULL UNIQUE,
                          description VARCHAR(255) NOT NULL,
                          categoryId BIGINT REFERENCES Category(id) ON DELETE CASCADE NOT NULL
);

CREATE TABLE Specification (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL UNIQUE,
                          description VARCHAR(255) NOT NULL,
                          unit VARCHAR(255) NOT NULL
);

CREATE TABLE SpecificationValue (
                          id BIGSERIAL PRIMARY KEY,
                          valueInt INT NULL,
                          valueDouble DOUBLE PRECISION NULL,
                          valueString VARCHAR(255) NULL,
                          specificationId BIGINT REFERENCES Specification(id) ON DELETE CASCADE NOT NULL
);

CREATE TABLE SpecificationToProduct (
                          id BIGSERIAL PRIMARY KEY,
                          productId BIGINT REFERENCES Product(id) ON DELETE SET NULL NOT NULL ,
                          specificationValueId BIGINT REFERENCES SpecificationValue(id) ON DELETE CASCADE NOT NULL
);