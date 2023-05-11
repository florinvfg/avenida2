
    create table comanda (
       id bigint not null auto_increment,
        date datetime(6),
        hour time,
        importe_comanda double precision,
        num_comensales integer,
        registry_date datetime(6),
        id_camarero BINARY(16),
        id_mesa integer,
        primary key (id)
    ) engine=InnoDB;

    create table linea_comanda (
       id_linea_comanda integer not null auto_increment,
        uds_producto integer,
        id_comanda bigint,
        id_producto bigint,
        primary key (id_linea_comanda)
    ) engine=InnoDB;

    create table mesa (
       id integer not null auto_increment,
        num_comensales integer,
        ubicacion varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table producto (
       id bigint not null auto_increment,
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

    create table comanda (
       id bigint not null auto_increment,
        date datetime(6),
        hour time,
        importe_comanda double precision,
        num_comensales integer,
        registry_date datetime(6),
        id_camarero BINARY(16),
        id_mesa integer,
        primary key (id)
    ) engine=InnoDB;

    create table linea_comanda (
       id_linea_comanda integer not null auto_increment,
        uds_producto integer,
        id_comanda bigint,
        id_producto bigint,
        primary key (id_linea_comanda)
    ) engine=InnoDB;

    create table mesa (
       id integer not null auto_increment,
        num_comensales integer,
        ubicacion varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table producto (
       id bigint not null auto_increment,
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

    create table comanda (
       id bigint not null auto_increment,
        date datetime(6),
        hour time,
        importe_comanda double precision,
        num_comensales integer,
        registry_date datetime(6),
        id_camarero BINARY(16),
        id_mesa integer,
        primary key (id)
    ) engine=InnoDB;

    create table linea_comanda (
       id_linea_comanda integer not null auto_increment,
        uds_producto integer,
        id_comanda bigint,
        id_producto bigint,
        primary key (id_linea_comanda)
    ) engine=InnoDB;

    create table mesa (
       id integer not null auto_increment,
        num_comensales integer,
        ubicacion varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table producto (
       id bigint not null auto_increment,
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

    create table comanda (
       id bigint not null auto_increment,
        date datetime(6),
        hour time,
        importe_comanda double precision,
        num_comensales integer,
        registry_date datetime(6),
        id_camarero BINARY(16),
        id_mesa integer,
        primary key (id)
    ) engine=InnoDB;

    create table linea_comanda (
       id_linea_comanda integer not null auto_increment,
        uds_producto integer,
        id_comanda bigint,
        id_producto bigint,
        primary key (id_linea_comanda)
    ) engine=InnoDB;

    create table mesa (
       id integer not null auto_increment,
        num_comensales integer,
        ubicacion varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table producto (
       id bigint not null auto_increment,
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

    create table comanda (
       id bigint not null auto_increment,
        date datetime(6),
        hour time,
        importe_comanda double precision,
        num_comensales integer,
        registry_date datetime(6),
        id_camarero BINARY(16),
        id_mesa integer,
        primary key (id)
    ) engine=InnoDB;

    create table linea_comanda (
       id_linea_comanda integer not null auto_increment,
        uds_producto integer,
        id_comanda bigint,
        id_producto bigint,
        primary key (id_linea_comanda)
    ) engine=InnoDB;

    create table mesa (
       id integer not null auto_increment,
        num_comensales integer,
        ubicacion varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table producto (
       id bigint not null auto_increment,
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

    create table comanda (
       id bigint not null auto_increment,
        date datetime(6),
        hour time,
        importe_comanda double precision,
        num_comensales integer,
        registry_date datetime(6),
        id_camarero BINARY(16),
        id_mesa integer,
        primary key (id)
    ) engine=InnoDB;

    create table linea_comanda (
       id_linea_comanda integer not null auto_increment,
        uds_producto integer,
        id_comanda bigint,
        id_producto bigint,
        primary key (id_linea_comanda)
    ) engine=InnoDB;

    create table mesa (
       id integer not null auto_increment,
        num_comensales integer,
        ubicacion varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table producto (
       id bigint not null auto_increment,
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

    create table comanda (
       id bigint not null auto_increment,
        date datetime(6),
        hour time,
        importe_comanda double precision,
        num_comensales integer,
        registry_date datetime(6),
        id_camarero BINARY(16),
        id_mesa integer,
        primary key (id)
    ) engine=InnoDB;

    create table linea_comanda (
       id_linea_comanda integer not null auto_increment,
        uds_producto integer,
        id_comanda bigint,
        id_producto bigint,
        primary key (id_linea_comanda)
    ) engine=InnoDB;

    create table mesa (
       id integer not null auto_increment,
        num_comensales integer,
        ubicacion varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table producto (
       id bigint not null auto_increment,
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

    create table comanda (
       id bigint not null auto_increment,
        date datetime(6),
        hour time,
        importe_comanda double precision,
        num_comensales integer,
        registry_date datetime(6),
        id_camarero BINARY(16),
        id_mesa integer,
        primary key (id)
    ) engine=InnoDB;

    create table linea_comanda (
       id_linea_comanda integer not null auto_increment,
        uds_producto integer,
        id_comanda bigint,
        id_producto bigint,
        primary key (id_linea_comanda)
    ) engine=InnoDB;

    create table mesa (
       id integer not null auto_increment,
        num_comensales integer,
        ubicacion varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table producto (
       id bigint not null auto_increment,
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

    create table comanda (
       id bigint not null auto_increment,
        date datetime(6),
        hour time,
        importe_comanda double precision,
        num_comensales integer,
        registry_date datetime(6),
        id_camarero BINARY(16),
        id_mesa integer,
        primary key (id)
    ) engine=InnoDB;

    create table linea_comanda (
       id_linea_comanda integer not null auto_increment,
        uds_producto integer,
        id_comanda bigint,
        id_producto bigint,
        primary key (id_linea_comanda)
    ) engine=InnoDB;

    create table mesa (
       id integer not null auto_increment,
        num_comensales integer,
        ubicacion varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table producto (
       id bigint not null auto_increment,
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

    create table comanda (
       id bigint not null auto_increment,
        date datetime(6),
        hour time,
        importe_comanda double precision,
        num_comensales integer,
        registry_date datetime(6),
        id_camarero BINARY(16),
        id_mesa integer,
        primary key (id)
    ) engine=InnoDB;

    create table linea_comanda (
       id_linea_comanda integer not null auto_increment,
        uds_producto integer,
        id_comanda bigint,
        id_producto bigint,
        primary key (id_linea_comanda)
    ) engine=InnoDB;

    create table mesa (
       id integer not null auto_increment,
        num_comensales integer,
        ubicacion varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table producto (
       id bigint not null auto_increment,
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
