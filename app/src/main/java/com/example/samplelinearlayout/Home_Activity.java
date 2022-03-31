package com.example.samplelinearlayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;


public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    //Deklarasi Variasi dengan data listview
    private ListView list;

    //memanggil class listviewAdapter dan diinisiasi menjadi variabeladapter
    private ListViewAdapter adapter;

    //Deklarasi array untuk menyimpan nama
    String[] listNama;

    //memanggil class cmassNama
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    //Membuat objek Bundle
    Bundle bundle = new Bundle();

    //Membuat objek intent
    Intent intent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Menyimpan nama didalam array Listnama
        listNama = new String[]{"Inayah", "Ilham", "Eris",
                "Fikri", "Maul", "Intan", "Vina", "Gita", "Vian", "Lutfi"};

        list = findViewById(R.id.listkontak);

        //Membuat objek dari class classNama menjadi arraylist
        classNamaArrayList = new ArrayList<>();

        //Membaca seluruh data pada array ListNama
        for (int i = 0; i < listNama.length; i++) {
            //Membuat objek dari  class nama da
            ClassNama classNama = new ClassNama(listNama[i]);
            //Binds strings ke array
            classNamaArrayList.add(classNama);

        }

        //Membuat objek dari listviewAdapter
        adapter = new ListViewAdapter(this);
        //binds adapter ke listview
        list.setAdapter(adapter);

            //membuat event dari list onclick
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    //Deklarasi variabel nama yang berisi item yang diklik
                    String nama = classNamaArrayList.get(position).getName();

                    //memasukan value dari variabel nama dengan kunci "a"
                    // dari dimasukan kedalam bundle
                    bundle.putString("a", nama.trim());

                    //Membuat objek popup menu
                    PopupMenu pm = new PopupMenu(getApplicationContext(), view);

                    //membuat event untuk popup menu ketika dipilih
                    pm.setOnMenuItemClickListener(Home_Activity.this);

                    //Menampilkan popup menu dari layout menu
                    pm.inflate(R.menu.popup_menu);

                    //Menampilkan popup menu
                    pm.show();

                }
            });


    }

    //event yang terjadi ketika menu dipilih

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(),ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(),"Ini untuk edit Kontak",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}

