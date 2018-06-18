package sup.alialmasli.com.sup;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {




    private FirebaseAuth mAuth;
    private Toolbar mToolBar;

    private ViewPager mViewPager;

    private SectionsPagerAdapter mSectionPagerAdapter;

    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        mToolBar = findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle("Sup");

        mViewPager = findViewById(R.id.main_tab_pager);
        mSectionPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mSectionPagerAdapter);

        mTabLayout = findViewById(R.id.main_tabs);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null)
        {
            sendToStart();
        }
    }

    private void sendToStart()
    {
        Intent startIntent = new Intent(MainActivity.this,StartActivity.class);
        startActivity(startIntent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.main_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       super.onOptionsItemSelected(item);

       if(item.getItemId() == R.id.main_logout_button)
       {
           FirebaseAuth.getInstance().signOut();
           sendToStart();
       }
       if(item.getItemId() == R.id.main_settings_button)
       {
           Intent settingsIntent = new Intent(MainActivity.this,SettingsActivity.class);
           startActivity(settingsIntent);
       }
        if(item.getItemId() == R.id.main_all_button)
        {
            Intent settingsIntent = new Intent(MainActivity.this,UsersActivity.class);
            startActivity(settingsIntent);
        }
       return true;
    }
}
