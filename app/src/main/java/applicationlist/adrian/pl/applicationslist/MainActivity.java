package applicationlist.adrian.pl.applicationslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView applicationListView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        applicationListView = (ListView) findViewById(R.id.applcationListView);

        //adapter = new ArrayAdapter<String>(this, R.layout.row, carL);
    }
}
