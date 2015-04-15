package com.insta.instaannuaire;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.insta.instaannuaire.resources.Authentification;
import com.insta.instaannuaire.resources.User;

import java.net.Authenticator;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.button_connexion1);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final TextView error = (TextView) findViewById(R.id.error_connexion);
                error.clearComposingText();
                //error.append("Erreur de connexion");
                final EditText login = (EditText) findViewById(R.id.mail);
                final EditText password = (EditText) findViewById(R.id.password);

                if (login.getText().toString() == null || login.getText().toString().equals("")) {
                    error.clearComposingText();

                    error.setText("Email vide !");
                } else if (password.getText().toString() == null || password.getText().toString().equals("")) {
                    error.clearComposingText();

                    error.setText("Mot de passe vide !");
                } else {
try {
    String authentification = Authentification.authentificate(login.getText().toString(), password.getText().toString());

                    if(authentification!=null){
                        Intent activityChangeIntent = new Intent(MainActivity.this, IndexActivity.class);
                        activityChangeIntent.putExtra("user",authentification);
                        MainActivity.this.startActivity(activityChangeIntent);
                    }



                    else {
                        error.clearComposingText();
                        error.setText("Email/Mot de passe invalide");
                    }
}
catch (Exception e){
    e.printStackTrace();
}

                }
                  //  Intent activityChangeIntent = new Intent(MainActivity.this, IndexActivity.class);

                //currentContext.startActivity(activityChangeIntent);

            }
        });


    }


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
