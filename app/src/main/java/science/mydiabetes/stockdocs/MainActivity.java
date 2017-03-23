package science.mydiabetes.stockdocs;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    FragmentPagerAdapter adapterViewPager;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        vpPager.getCurrentItem(); // --> 2
        vpPager.setCurrentItem(1);

//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        FragmentViewPager fragmentViewPager = FragmentViewPager.newInstance("One", "One");
//        ft.replace(R.id.activity_main, fragmentViewPager);
//        ft.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_favorite:
//                Fragment frag;
//                FragmentManager fm1 = MainActivity.this
//                        .getSupportFragmentManager();
//                FragmentTransaction ft1 = fm1.beginTransaction();
//                frag = new SecondFragment();
//                ft1.replace(R.id.activity_main, frag);
//                ft1.commit();
                return true;
            case R.id.about:
                return true;
            case R.id.sign_out:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}

