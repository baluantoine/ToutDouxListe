package exercicepje.sm.fr.toutdouxliste;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TaskActivity extends AppCompatActivity {

    /**
     * Lancement de l'activité formulaire au clic sur un bouton
     * @param
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        android.app.ActionBar actionBar = getActionBar();

        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void onValid(View view) {

    }
}
