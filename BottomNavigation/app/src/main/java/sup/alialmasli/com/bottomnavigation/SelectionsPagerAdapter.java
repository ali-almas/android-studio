package sup.alialmasli.com.bottomnavigation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by hp 450 on 4/2/2018.
 */

public class SelectionsPagerAdapter extends FragmentPagerAdapter{

    public SelectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                NotificationFragment notificationFragment = new NotificationFragment();
                return notificationFragment;
            case 2:
                AccountFragment accountFragment = new AccountFragment();
                return accountFragment;

                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
