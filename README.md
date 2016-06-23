# MDW

### Database settings

Edit file _template_persistance.xml:
* Rename it to persistance.xml
* Insert correct values for
** $_DATABASE_HOST_OR_IP_$ - Database host name or ip addres; if the database is on the same machine as web server use localhost
** $_DATABASE_NAME_$ - database name in MySQL database
** $_USER_NAME_$ - MySQL user name
** $_PASSWORD_$ - MySQL user password

## Aditional

### Rename packages
* Rename packages
* Rename in filter

Database dump is in file jees.sql

To create database execute in MySQl
```sql
CREATE DATABASE $_DATABASE_NAME_$;
```
Where is $_DATABASE_NAME_$ the same as in persistence.xml file 

To insert data in database execute
```bash
mysql -u [username] -p $_DATABASE_NAME_$ < jees.sql
```

After insert database into MySQL server there is account admin/admin

## Run on Openshift 

1. Login in OpenShift
2. Add Application...
3. Choose Tomcat
4. Set up name
5. 
