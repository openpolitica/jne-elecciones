# JNE - Elecciones

![extract](https://github.com/openpolitica/jne-elecciones/workflows/extract/badge.svg)

## 2021

### Congresales

- [Avro](data/2021-candidatos-congresales.avro)
- [sqlite](data/2021-candidatos-congresales.db)

### Presidenciales 

- [Avro](data/2021-candidatos-presidenciales.avro)
- [sqlite](data/2021-candidatos-presidenciales.db)

## Exportar datos a CSV

Requiere de [sqlite](https://sqlite.org/download.html)

```shell
cat scripts/candidatos-csv.sql | sqlite3 data/2021-candidatos-presidenciales.db 
cat scripts/candidatos-csv.sql | sqlite3 data/2021-candidatos-congresales.db 
```