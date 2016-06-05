package com.otto.beekeepersystemtest.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.otto.beekeepersystemtest.Domain.Person;
import com.otto.beekeepersystemtest.Factory.PersonFactory;
import com.otto.beekeepersystemtest.MainActivity;
import com.otto.beekeepersystemtest.R;
import com.otto.beekeepersystemtest.Repository.Impl.PersonRepositoryImpl;
import com.otto.beekeepersystemtest.Repository.PersonRepository;

import java.util.ArrayList;


/**
 * Created by 212026992 on 6/3/2016.
 */
public class PersonView extends AppCompatActivity {

    EditText firstName, lastName, email;
    TextView textView;
    TextView firstNameTXT;
    TextView surnameTXT;
    TextView emailTXT;
    TextView arraySize;
    ListView listView;
    PersonRepository repo = new PersonRepositoryImpl(this);
    ArrayList<String> firstNameArray= new ArrayList<>() ;
    ArrayList <String> surnameArray= new ArrayList<>() ;
    ArrayList <String> emailArray= new ArrayList<>() ;
    int count= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        email = (EditText) findViewById(R.id.email);

        firstNameTXT =(TextView)findViewById(R.id.firstNameTXT);
        surnameTXT =(TextView)findViewById(R.id.surnameTXT);
        emailTXT =(TextView)findViewById(R.id.emailTXT);
        arraySize =(TextView)findViewById(R.id.arraySize);


    }
    public void addPersonBTN(View view)
    {
        Person person = PersonFactory.create(firstName.getText().toString(),lastName.getText().toString(),email.getText().toString());
        Person insertedEntity = repo.save(person);
        Toast.makeText(getBaseContext(), "Submitted" , Toast.LENGTH_SHORT ).show();
    }
    public void viewPersonBTN(View view)
    {

        Intent getNameScreenIntent = new Intent(this, PersonActivity.class);

        // We ask for the Activity to start and don't expect a result to be sent back
        // startActivity(getNameScreenIntent);
        // We use startActivityForResult when we expect a result to be sent back

        final int result = 1;

        // To send data use putExtra with a String name followed by its value

        getNameScreenIntent.putExtra("callingActivity", "MainActivity");

        startActivityForResult(getNameScreenIntent, result);

        setContentView(R.layout.view_person) ;
    }

    public void viewHomeBTN(View view)
    {

        Intent getNameScreenIntent = new Intent(this, MainActivity.class);

        // We ask for the Activity to start and don't expect a result to be sent back
        // startActivity(getNameScreenIntent);
        // We use startActivityForResult when we expect a result to be sent back

        final int result = 1;

        // To send data use putExtra with a String name followed by its value

        getNameScreenIntent.putExtra("callingActivity", "MainActivity");

        startActivityForResult(getNameScreenIntent, result);

        setContentView(R.layout.activity_main) ;
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