package exercicepje.sm.fr.toutdouxliste;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import java.util.Map;

/**
 * Created by Formation on 11/01/2018.
 */

public class TaskArrayAdapter {
    //Déclaration des variables
    private Activity context;
    private List<Task> data;
    private LayoutInflater inflater;

    public TaskArrayAdapter(@NonNull Context context,
                               @NonNull List<Task> data) {
        super();
        //Instanciation des variables
        this.data= data;
        this.context = (Activity) context;
        this.inflater =this.context.getLayoutInflater();
    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        //Instanciation de la vue
        View view = this.inflater.inflate(R.layout.list_view_task, parent, false);

        //Récupération des données d'une ligne
        Task taskD = this.data.get(position);

        //Liaison entre les données et la vue
        TextView nomTextView = view.findViewById(R.id.listTextViewNom);
        nomTextView.setText(taskD.getNom());

        TextView idTaskTextView = view.findViewById(R.id.listTextViewLib);
        idTaskTextView.setText(taskD.getIdTask());

        return view;
    }
}
