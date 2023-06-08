
    create table comanda (
       id integer not null auto_increment,
        date date,
        hour time,
        importe_comanda double precision,
        num_comensales integer,
        registry_date datetime(6),
        id_camarero BINARY(16),
        id_mesa integer,
        primary key (id)
    ) engine=InnoDB;

    create table contacto (
       id bigint not null auto_increment,
        email varchar(255),
        nombre varchar(255),
        telefono varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table linea_comanda (
       id integer not null auto_increment,
        concepto varchar(255),
        estado varchar(255),
        importe double precision,
        iva integer,
        total double precision,
        unidades integer,
        id_comanda integer not null,
        id_producto integer not null,
        primary key (id)
    ) engine=InnoDB;

    create table mesa (
       id integer not null auto_increment,
        location_url varchar(255),
        num_comensales integer,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
       id integer not null auto_increment,
        iva integer,
        nombre varchar(255),
        precio double precision,
        primary key (id)
    ) engine=InnoDB;

    create table users (
       id BINARY(16) not null,
        email varchar(255),
        active bit,
        address varchar(255),
        birth_date date,
        city varchar(255),
        consent bit,
        country varchar(255),
        created_at datetime(6),
        date_consent datetime(6),
        dni varchar(255),
        height double precision,
        name varchar(255),
        password varchar(255),
        phone integer,
        postal_code integer,
        role varchar(255),
        surname varchar(255),
        weigth double precision,
        primary key (id)
    ) engine=InnoDB;

    alter table comanda 
       add constraint FK7ukcqvfds0lwiqpsslsbqciec 
       foreign key (id_camarero) 
       references users (id);

    alter table comanda 
       add constraint FKdysjuh9mxdsspefp3dqh9csra 
       foreign key (id_mesa) 
       references mesa (id);

    alter table linea_comanda 
       add constraint FKc13m8vdkrrf5drwglyn6xj9ce 
       foreign key (id_comanda) 
       references comanda (id);

    alter table linea_comanda 
       add constraint FK8ixmc5f7slue8ydkw8nmga3hd 
       foreign key (id_producto) 
       references producto (id);
