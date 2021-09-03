package com.rtwo.dataentry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2, editText3;
    ListView listview;
    ArrayList<String> list;
    Button button;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListenerButton();
    }

    private void ListenerButton() {
        editText1 = (EditText) findViewById(R.id.textName);
        editText2 = (EditText) findViewById(R.id.textEmail);
        editText3 = (EditText) findViewById(R.id.textPhone);
        listview = (ListView) findViewById(R.id.lstView);
        button = (Button) findViewById(R.id.btnSubmit);
        list = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, email, phone;
                name = editText1.getText().toString();
                email = editText2.getText().toString();
                phone = editText3.getText().toString();
                list.add("Name:" + name);
                list.add("Email:" + email);
                list.add("phone:" + phone);
                listview.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();

                /* Toast.makeText(getApplicationContext(), "Name -  " + name.toString() + " \n" + "Email -  " + email.toString() + " \n" + "Phone -  " + phone.toString(), Toast.LENGTH_SHORT).show();*/
            }

        });
    }

}