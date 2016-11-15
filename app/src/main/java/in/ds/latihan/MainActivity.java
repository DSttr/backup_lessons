package in.ds.latihan;

import android.content.res.*;
import android.os.*;
import android.support.design.widget.*;
import android.support.v4.app.*;
import android.support.v4.view.*;
import android.support.v4.widget.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import in.ds.latihan.fragment.*;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity 
{
	private NavigationView mNavigationView;
    private ActionBarDrawerToggle mDrawerToggle;
	private DrawerLayout mDrawerLayout;
	private Toolbar mToolbar;
	private View headerLayout;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
		
		mNavigationView = (NavigationView)findViewById(R.id.navigation_view);
		mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
		setupDrawerContent(mNavigationView);
		mDrawerToggle = setupDrawerToggle();
		mDrawerLayout.addDrawerListener(mDrawerToggle);
		
		headerLayout = mNavigationView.inflateHeaderView(R.layout.nav_header);
		
		
    }
	
	
	
	private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
			new NavigationView.OnNavigationItemSelectedListener() {
				@Override
				public boolean onNavigationItemSelected(MenuItem menuItem) {
					selectDrawerItem(menuItem);
					return true;
				}
			});
    }
	
	public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = ;
        Class fragmentClass = ;
        switch(menuItem.getItemId()) {
            case R.id.menu_satu:
                fragmentClass = FragmentSatu.class;
				tampilkanSnackbar( "satu");
                break;
            case R.id.menu_dua:
                fragmentClass = FragmentDua.class;
				tampilkanSnackbar( "dua");
                break;
            case R.id.menu_tiga:
                fragmentClass = FragmentTiga.class;
				tampilkanSnackbar( "tiga");
                break;
			case R.id.sub_1:
                fragmentClass = FragmentEmpat.class;
				tampilkanSnackbar( "empat");
                break;
            default:
                fragmentClass = FragmentSatu.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawerLayout.closeDrawers();
		
		Menu menu = mNavigationView.getMenu();
		menuItem = menu.findItem(R.id.nav_switch);
		View actionView = MenuItemCompat.getActionView(menuItem);
		actionView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {

					tampilkanSnackbar( "switched");

				}
			});
    }
	
	private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,  R.string.drawer_close);
	}
	
	@Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
	
	private void tampilkanSnackbar(String message) {
		Snackbar.make(mNavigationView, message, Snackbar.LENGTH_LONG).show();
	}
}
