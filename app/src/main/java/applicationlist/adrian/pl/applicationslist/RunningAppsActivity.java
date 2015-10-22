package applicationlist.adrian.pl.applicationslist;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class RunningAppsActivity extends Activity {

    private PackageManager packageManager;
    private List<ActivityManager.RunningAppProcessInfo> applicationInfosList;
    private ListView listView;
    private List<Element> elementsList;
    private ExtendedArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running);

        packageManager = getPackageManager();

        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        applicationInfosList = activityManager.getRunningAppProcesses();

        elementsList = new ArrayList<>();
        for(int i=0; i<applicationInfosList.size(); i++) {
            elementsList.add(new Element(applicationInfosList.get(i).processName, packageManager.getApplicationIcon(new ApplicationInfo())));
        }

        listView = (ListView) findViewById(R.id.applicationRunning);

        adapter = new ExtendedArrayAdapter(this, R.layout.running_element, elementsList);

        listView.setAdapter(adapter);
    }
    // TODO
    public void showAppInfo(View view) {
        Intent intent = new Intent(this, AppInfoActivity.class);
        //for(ApplicationInfo application : applicationInfosList) {
            //if(packageManager.getApplicationLabel(application)=="") {
                //
            //}
        //}
        //intent.putExtra(MainActivity.appInfoConstant, packageManager.getApplicationLabel(applicationInfosList.get(R.id.elementName)));
        intent.putExtra(MainActivity.appInfoConstant, "blabla3");
        startActivity(intent);
    }

}
