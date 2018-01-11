package sm.fr.database;

import android.database.sqlite.SQLiteException;

import java.util.List;

import exercicepje.sm.fr.toutdouxliste.Task;

/**
 * Created by Formation on 11/01/2018.
 */

interface TaskDAOInterface <DTO> {
    /**
     * Created by Formation on 11/01/2018.
     */

//Générique ou marqeur DTO, possibilité d'insérer plusieurs génériques
    interface DAOInterface <DTO> {
        Task findOneById(int idTask) throws SQLiteException;

        List<DTO> findAll() throws SQLiteException;

        //Suppression d'une tache en fonction de sa clé primaire
        void deleteOneById(Long idTask) throws SQLiteException;

        void persist(DTO entity);
    }

}
