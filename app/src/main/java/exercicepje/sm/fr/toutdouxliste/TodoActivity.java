package exercicepje.sm.fr.toutdouxliste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class TodoActivity extends AppCompatActivity {

    ListView malisteview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        malisteview = (ListView) findViewById(R.id.contactListView);
    }

    public void onAddTask(View view){
        if (view == findViewById(R.id.buttonAddTask)) { // facultaif car onAddContact est utilisé pour un seul bouton
            Intent FormIntent = new Intent(this, TaskActivity.class);
            startActivity(FormIntent);
        }
    }
}
