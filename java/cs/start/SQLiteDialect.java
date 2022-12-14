package cs.start;

import org.hibernate.cfg.Environment;
import org.hibernate.dialect.Dialect;
//import org.hibernate.dialect.identity.IdentityColumnSupport;

import javax.sql.DataSource;



public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
//        registerColumnType(Types.BIT, "integer");
//        registerColumnType(Types.TINYINT, "tinyint");
//        registerColumnType(Types.SMALLINT, "smallint");
//        registerColumnType(Types.INTEGER, "integer");
        // other data types
    }

//    @Override
//    public IdentityColumnSupport getIdentityColumnSupport() {
//        return new SQLiteIdentityColumnSupport();
//    }

    @Override
    public boolean hasAlterTable() {
        return false;
    }

    @Override
    public boolean dropConstraints() {
        return false;
    }

    @Override
    public String getDropForeignKeyString() {
        return "";
    }

    @Override
    public String getAddForeignKeyConstraintString(String cn,
                                                   String[] fk, String t, String[] pk, boolean rpk) {
        return "";
    }

}