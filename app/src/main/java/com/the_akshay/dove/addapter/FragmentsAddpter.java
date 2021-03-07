package com.the_akshay.dove.addapter;

import com.the_akshay.dove.frag.CallsFragment;
import com.the_akshay.dove.frag.ChatsFragment;
import com.the_akshay.dove.frag.StatusFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentsAddpter extends FragmentPagerAdapter {
    /**
     * Constructor for {@link FragmentPagerAdapter} that sets the fragment manager for the adapter.
     * This is the equivalent of calling {@link #FragmentPagerAdapter(FragmentManager, int)} and
     * passing in {@link #BEHAVIOR_SET_USER_VISIBLE_HINT}.
     *
     * <p>Fragments will have {@link Fragment#setUserVisibleHint(boolean)} called whenever the
     * current Fragment changes.</p>
     *
     * @param fm fragment manager that will interact with this adapter
     * @deprecated use {@link #FragmentPagerAdapter(FragmentManager, int)} with
     * {@link #BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT}
     */
    public FragmentsAddpter(@NonNull FragmentManager fm) {
        super(fm);
    }

    /**
     * Constructor for {@link FragmentPagerAdapter}.
     * <p>
     * If {@link #BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT} is passed in, then only the current
     * Fragment is in the {@link Lifecycle.State#RESUMED} state. All other fragments are capped at
     * {@link Lifecycle.State#STARTED}. If {@link #BEHAVIOR_SET_USER_VISIBLE_HINT} is passed, all
     * fragments are in the {@link Lifecycle.State#RESUMED} state and there will be callbacks to
     * {@link Fragment#setUserVisibleHint(boolean)}.
     *
     * @param fm       fragment manager that will interact with this adapter
     * @param behavior determines if only current fragments are in a resumed state
     */
    public FragmentsAddpter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ChatsFragment();
            case 1:
                return new StatusFragment();
            case 2:
                return new CallsFragment();
            default:
                return null;
        }
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        switch (position) {
            case 0:
                title = "CHATS";
                break;
            case 1:
                title = "STATUS";
                break;
            case 2:
                title = "CALLS";
                break;
            default:
                break;
        }
        return title;
    }
}
