package applicationlist.adrian.pl.applicationslist;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AllAppsActivity extends Activity {

    private PackageManager packageManager;
    private List<ApplicationInfo> applicationInfosList;
    private ListView listView;
    private List<Element> elementsList;
    private ExtendedArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        packageManager = getPackageManager();
        applicationInfosList = packageManager.getInstalledApplications(0);

        elementsList = new ArrayList<>();
        for(ApplicationInfo application : applicationInfosList) {
            elementsList.add(new Element((String)packageManager.getApplicationLabel(application), packageManager.getApplicationIcon(application), 3.5));
        }

        listView = (ListView) findViewById(R.id.applicationAll);

        adapter = new ExtendedArrayAdapter(this, R.layout.element, elementsList);

        listView.setAdapter(adapter);
    }
    // TODO
    public void showAppInfo(View view) {
        Intent intent = new Intent(this, AppInfoActivity.class);
        for(ApplicationInfo application : applicationInfosList) {
            if(packageManager.getApplicationLabel(application)=="") {

            }
        }
        //intent.putExtra(MainActivity.appInfoConstant, packageManager.getApplicationLabel(applicationInfosList.get(R.id.elementName)));
        intent.putExtra(MainActivity.appInfoConstant, "blabla1");
        startActivity(intent);
    }

}
