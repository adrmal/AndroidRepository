package applicationlist.adrian.pl.applicationslist;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class RunningAppsActivity extends Activity {

    private PackageManager packageManager;
    private List<ApplicationInfo> applicationInfosList;
    private ListView listView;
    private List<Element> elementsList;
    private ExtendedArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running);

        packageManager = getPackageManager();
        applicationInfosList = packageManager.getInstalledApplications(0);

        elementsList = new ArrayList<>();
        for(ApplicationInfo application : applicationInfosList) {
            elementsList.add(new Element((String)packageManager.getApplicationLabel(application), 3.5, packageManager.getApplicationIcon(application)));
        }

        listView = (ListView) findViewById(R.id.applicationRunning);

        adapter = new ExtendedArrayAdapter(this, R.layout.application_list_element, elementsList);

        listView.setAdapter(adapter);
    }

}
