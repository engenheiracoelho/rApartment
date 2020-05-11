# rApartment

---

A simple applications to control common area booking on condominium .

### Configuration

#### Create a new MySql schema on localhost database. 

#### Configure access

```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:4720/DATABASE_SCHEMA
spring.datasource.username=root
spring.datasource.password=pass
```

### Install

#### Using npm

```bash
npm install
```

#### Start project

```bash
mvn spring-boot:run
```
