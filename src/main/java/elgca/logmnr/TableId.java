package elgca.logmnr;

import java.util.Objects;

public class TableId {
    private final String schemaName;
    private final String tableName;
    private final String id;

    public static TableId parse(String tableId) {
        String[] list = tableId.trim().split("[.]");
        if (list.length != 2) {
            throw new IllegalArgumentException("Illegal table name:" + tableId);
        }
        return new TableId(list[0], list[1]);
    }

    public TableId(String schemaName, String tableName) {
        this.schemaName = cleanString(schemaName);
        this.tableName = cleanString(tableName);
        id = this.schemaName + "." + this.tableName;
        assert this.tableName != null;
    }

    public String table() {
        return tableName;
    }


    public String schema() {
        return schemaName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableId tableId = (TableId) o;
        return Objects.equals(id, tableId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schemaName, tableName);
    }

    @Override
    public String toString() {
        return id;
    }

    private static String cleanString(String str) {
        if (str.startsWith("'") && str.endsWith("'")) str = str.substring(1, str.length() - 1);
        else if (str.startsWith("\"") && str.endsWith("\"")) str = str.substring(1, str.length() - 1);
        else if (str.startsWith("`") && str.endsWith("`")) str = str.substring(1, str.length() - 1);
        return str;
    }
}
