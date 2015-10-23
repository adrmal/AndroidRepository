package applicationlist.adrian.pl.applicationslist;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AllAppsActivity extends Activity {

    private PackageManager packageManager;
    private List<PackageInfo> applicationInfosList;
    private ListView listView;
    private List<Element> elementsList;
    private ExtendedArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        packageManager = getPackageManager();
        applicationInfosList = packageManager.getInstalledPackages(0);

        elementsList = new ArrayList<>();
        for(int i=0; i<applicationInfosList.size(); i++) {
            elementsList.add(new Element((String)applicationInfosList.get(i).applicationInfo.loadLabel(packageManager), applicationInfosList.get(i).applicationInfo.loadIcon(packageManager), 3.5));
        }

        listView = (ListView) findViewById(R.id.applicationAll);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AllAppsActivity.this, AppInfoActivity.class);
                intent.putExtra(MainActivity.appInfoConstant, applicationInfosList.get(position));
                startActivity(intent);
            }
        });

        adapter = new ExtendedArrayAdapter(this, R.layout.element, elementsList);

        listView.setAdapter(adapter);
    }

}
