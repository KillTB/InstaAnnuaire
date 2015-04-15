package com.insta.instaannuaire;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class IndexActivity extends Activity {

   // private TestListView testListView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
/*
        TabHost tabHost = (TabHost) this.findViewById(R.id.tabhost);
        tabHost.setup();
        TabHost.TabSpec tspec1 = tabHost.newTabSpec("Profil_tab");
        tspec1.setIndicator("Profil");
        tspec1.setContent(R.id.Profil_tab);
        tabHost.addTab(tspec1);

        TabHost.TabSpec tspec2 = tabHost.newTabSpec("Recherche_tab");
        tspec2.setIndicator("Recherche");
        tspec2.setContent(R.id.Recherche_tab);
        tabHost.addTab(tspec2);
*/
      //  tabHost.setOnTabChangedListener(new TabChangeListener());
       // tabHost.setCurrentTab(1);

//test
     /*  final Button button = (Button) findViewById(R.id.button_connexion1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView error = (TextView) findViewById(R.id.error_connexion);
                error.clearComposingText();
                error.append("Erreur de connexion");

               // Intent activityChangeIntent = new Intent(MainActivity.this, MainActivity.class);

                // currentContext.startActivity(activityChangeIntent);

               // MainActivity.this.startActivity(activityChangeIntent);
            }
        });

*/

    }
/*
    public void switchTabs(boolean direction)
    {
        if (direction) // true = move left
        {
            if (tabHost.getCurrentTab() == 0)
                tabHost.setCurrentTab(tabHost.getTabWidget().getTabCount() - 1);
            else
                tabHost.setCurrentTab(tabHost.getCurrentTab() - 1);
        }
        else
        // move right
        {
            if (tabHost.getCurrentTab() != (tabHost.getTabWidget().getTabCount() - 1))
                tabHost.setCurrentTab(tabHost.getCurrentTab() + 1);
            else
                tabHost.setCurrentTab(0);
        }
    }


    private class TabChangeListener implements TabHost.OnTabChangeListener
    {

        @Override
        public void onTabChanged(String tabId)
        {
            testListView.init(tabHost.getCurrentTab());
        }

    }


*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
