SELECT DECODE(T.CON_ID, 1, 'CDB$ROOT', P.NAME) CONTAINER_NAME,
T.OWNER,
T.TABLE_NAME
FROM CDB_TABLES T
LEFT OUTER JOIN V$PDBS P ON T.CON_ID = P.CON_ID