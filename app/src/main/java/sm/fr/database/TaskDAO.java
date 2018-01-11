package sm.fr.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import java.util.ArrayList;
import java.util.List;
import exercicepje.sm.fr.toutdouxliste.Task;

/**
 * Created by Formation on 11/01/2018.
 */

public class TaskDAO implements TaskDAOInterface {
    private DatabaseHandler db;

    public TaskDAO(DatabaseHandler db) {
        this.db = db;
    }

    /**
     * Récupération de la tâche en fonction de sa clé primaire (id)
     * @param idTask
     * @return
     */
    @Override
    public Task findOneById(int idTask) throws SQLiteException {

        //Exécution de la requête
        String[] params = {String.valueOf(idTask)};
        String sql = "SELECT * FROM taches WHERE idTask=?";
        Cursor cursor = this.db.getReadableDatabase().rawQuery(sql, params);

        //Instanciation de la tache
        Task task = new Task();

        //Hydratation de la tache
        if (cursor.moveToNext()) {
            task = hydrateContact(cursor);
        }
        //Fermeture du curseur
        cursor.close();
        return task;
    }

    private Task hydrateTask(Cursor cursor) {
        Task task = new Task();

        task.setIdTask(cursor.getLong(0));
        task.setNom(cursor.getString(1));

        return task;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Task> findAll() throws SQLiteException{
        //Instanciation de la liste des taches
        List<Task> taskList = new ArrayList<>();

        //Exécution de la requête sql qui permet de récupérer tous les contacts
        String sql = "SELECT id, name, first_name,email FROM taches";
        Cursor cursor = this.db.getReadableDatabase().rawQuery(sql, null);

        //Boucle sur le curseur pour parcourir l'ensemble des résultats de ma requête
        while(cursor.moveToNext()){
            taskList.add(this.hydrateTask(cursor));
        }

        //Fermeture du curseur
        cursor.close();

        return taskList;
    }

    //Suppression d'un contact en fonction de sa clé primaire
    @Override
    public void deleteOneById(Long id) throws SQLiteException {
        String[] params = {id.toString()};
        String sql = "DELETE FROM taches WHERE idTask=?";
        this.db.getWritableDatabase().execSQL(sql, params);
    }

    @Override
    public void persist(Task entity){
        if(entity.getIdTask() == null){
            this.insert(entity);
        }
        else{
            this.update(entity);
        }
    }

    private ContentValues getContentValuesFromEntity(Task entity){
        ContentValues values = new ContentValues();
        values.put("nom", entity.getNom());

        return values;
    }

    private void insert(Task entity){
        //Insérer l'objet entity
        Long idTask = this.db.getWritableDatabase().insert("taches", null, this.getContentValuesFromEntity(entity));

        //Hydrater l'objet entity
        entity.setIdTask(idTask);
    }

    private void update(Task entity){
        String[] params = {entity.getIdTask().toString()};
        this.db.getWritableDatabase().update("taches", this.getContentValuesFromEntity(entity),"idTask=?", params);
    }

}
