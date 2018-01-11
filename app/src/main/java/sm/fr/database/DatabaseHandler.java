package sm.fr.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Formation on 11/01/2018.
 */

public class DatabaseHandler {
    private static final String NOM_BASE = "taches";
    private static final int VERSION_BASE = 1;

    private static final String TASK_TABLE_SQL = "CREATE TABLE taches(" + "idTask INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nom TEXT NOT NULL" + ")";

    public DatabaseHandler(Context context) {
        super(context, NOM_BASE, null, VERSION_BASE);
    }

    //Création de la table taches
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TASK_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){

        //suppression de la table si elle existe
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS taches");

        //on recrée la table
        this.onCreate(sqLiteDatabase);
    }
}
