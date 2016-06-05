package com.otto.beekeepersystemtest.Views;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import com.otto.beekeepersystemtest.Domain.Person;
import com.otto.beekeepersystemtest.MainActivity;
import com.otto.beekeepersystemtest.R;
import com.otto.beekeepersystemtest.Repository.Impl.PersonRepositoryImpl;
import com.otto.beekeepersystemtest.Repository.PersonRepository;
/**
 * Created by 212026992 on 6/4/2016.
 */
public class PersonActivity extends AppCompatActivity {

    Button NxtBTN;
    Button PrevBTN;
    TextView firstNameTXT;
    TextView surnameTXT;
    TextView emailTXT;
    TextView arraySize;
    ListView listView;
    PersonRepository repo = new PersonRepositoryImpl(this);
    ArrayList <String> firstNameArray= new ArrayList<>() ;
    ArrayList <String> surnameArray= new ArrayList<>() ;
    ArrayList <String> emailArray= new ArrayList<>() ;
    int count= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_person_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        firstNameTXT =(TextView)findViewById(R.id.firstNameTXT);
        surnameTXT =(TextView)findViewById(R.id.surnameTXT);
        emailTXT =(TextView)findViewById(R.id.emailTXT);
        arraySize =(TextView)findViewById(R.id.arraySize);
        NxtBTN =(Button)findViewById(R.id.NxtBTN);
        PrevBTN =(Button)findViewById(R.id.PrevBTN);
        String tests = "";
        Set<Person> persons = repo.findAll();



        Iterator iterator = persons.iterator();
        while(iterator.hasNext())
        {
            Person element =  (Person)iterator.next();

            firstNameArray.add( element.getFirstName());
            surnameArray.add(element.getLastName());
            emailArray.add(element.getEmail());
            element.getFirstName();
            tests = tests +element.getFirstName()+"\n ";


        }


    }



public void populatePerBTN(View view)
{
    if(count==0)
    {
        firstNameTXT.setText(firstNameArray.get(0));
        surnameTXT.setText(surnameArray.get(0));
        emailTXT.setText(emailArray.get(0));
        arraySize.setText(0 + " of " + (firstNameArray.size()-1));
        NxtBTN.setVisibility(View.VISIBLE);
        PrevBTN.setVisibility(View.VISIBLE);
    }
}
    public void viewNextPersonBTN (View view)
    {
        if(count>firstNameArray.size())
        {
            count=firstNameArray.size()-1;
        }

arraySize.setText((count) + " of " + (firstNameArray.size()-1));

        if(count<firstNameArray.size()-1)
        {
            count++;
            firstNameTXT.setText(firstNameArray.get(count));
            surnameTXT.setText(surnameArray.get(count));
            emailTXT.setText(emailArray.get(count));
            arraySize.setText((count) + " of " + (firstNameArray.size()-1));
        }

    }

    public void viewPreviousPersonBTN (View kak)
    {

        if(count==0)
        {
            firstNameTXT.setText(firstNameArray.get(0));
            surnameTXT.setText(surnameArray.get(0));
            emailTXT.setText(emailArray.get(0));
        }

        if(count==-1)
        {
            count=(-1);

        }

        arraySize.setText((count) + " of " + (firstNameArray.size()-1));

        if(count>0)
        {
            count--;
            firstNameTXT.setText(firstNameArray.get(count));
            surnameTXT.setText(surnameArray.get(count));
            emailTXT.setText(emailArray.get(count));
            arraySize.setText((count) + " of " + (firstNameArray.size()-1));
        }


    }

    public void backBTN(View view)
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
        firstNameArray.clear();
        surnameArray.clear();
        emailArray.clear();
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
