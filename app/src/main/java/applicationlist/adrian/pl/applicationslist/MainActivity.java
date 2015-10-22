package applicationlist.adrian.pl.applicationslist;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends FragmentActivity {

    private TabHost tabHost;
    final static String appInfoConstant = "pl.adrian.applicationslist.APPINFO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = (TabHost)findViewById(R.id.tabHost);
        LocalActivityManager lam = new LocalActivityManager(this, false);
        lam.dispatchCreate(savedInstanceState);
        tabHost.setup(lam);

        TabHost.TabSpec t1 = tabHost.newTabSpec("all").setIndicator("Wszystkie aplikacje").setContent(new Intent(this, AllAppsActivity.class));
        TabHost.TabSpec t2 = tabHost.newTabSpec("downloaded").setIndicator("Zainstalowane aplikacje").setContent(new Intent(this, DownloadedAppsActivity.class));
        TabHost.TabSpec t3 = tabHost.newTabSpec("running").setIndicator("Uruchomione procesy").setContent(new Intent(this, RunningAppsActivity.class));

        tabHost.addTab(t1);
        tabHost.addTab(t2);
        tabHost.addTab(t3);
        tabHost.setCurrentTab(0);
    }
}
