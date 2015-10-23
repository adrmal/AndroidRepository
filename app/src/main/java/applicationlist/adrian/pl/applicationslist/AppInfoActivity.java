package applicationlist.adrian.pl.applicationslist;

import android.content.pm.PackageInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AppInfoActivity extends AppCompatActivity {

    TextView textViewName;
    ImageView imageViewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info);

        Bundle bundle = getIntent().getExtras();
        PackageInfo packageInfo = bundle.getParcelable(MainActivity.appInfoConstant);

        textViewName = (TextView) findViewById(R.id.elementName);
        imageViewName = (ImageView) findViewById(R.id.elementImage);

        textViewName.setText(packageInfo.applicationInfo.loadLabel(getPackageManager()));
    }
}
