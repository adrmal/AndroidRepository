package applicationlist.adrian.pl.applicationslist;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PackageManager packageManager;
    private List<ApplicationInfo> applicationList;
    private ListView applicationListView;
    private List<String> applicationsNamesList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        packageManager = getPackageManager();
        applicationList = packageManager.getInstalledApplications(0);

        applicationsNamesList = new ArrayList<>();
        for(ApplicationInfo application : applicationList) {
            applicationsNamesList.add((String)application.loadLabel(packageManager));
            //applicationsNamesList.add((String)packageManager.getApplicationLabel(application));
        }

        applicationListView = (ListView) findViewById(R.id.applicationListView);

        adapter = new ArrayAdapter<>(this, R.layout.application_list_element, applicationsNamesList);
        applicationListView.setAdapter(adapter);
    }
}
