package com.example.sharingapp;

import android.content.Intent;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

/**
 * Home Activity of the App
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOffscreenPageLimit(0);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    public void addItemActivity(View view) {
        Intent intent = new Intent(this, AddItemActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Called when MainActivity is started. Links the menu resource file menu_main.xml to MainActivity and
        // "Inflates" the menu
        // Inflate the menu; this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_main, menu); // Menu resource, Menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Called when the user selects an option from the mnu
        // Code handles what happens when the user selects the "Contacts" option from the menu - ContactsActivity is
        // started
        switch (item.getItemId()) {
            case R.id.contacts:
                Intent intent = new Intent(this, ContactActivity.class);
                return true;
            default:
                return super.OnOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
