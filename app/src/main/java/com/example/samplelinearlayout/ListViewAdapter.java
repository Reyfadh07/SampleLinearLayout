package com.example.samplelinearlayout;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    //Deklarasi Variabel dengan jenis data context
    Context mContext;

    //Deklarasi Variabel dengan jenis data layout inflater
    LayoutInflater inflater;

    //Deklarasi variabel dengan jenis data arraylist
    private ArrayList<ClassNama> arrayList;

    //Membuat Kontrukstor listviewadapter
    public ListViewAdapter(Context context) {
        //Memberi nilai mcontext dengan context
        mContext = context;

        //Mengatur Layoutonflater dari context yang diberikan
        inflater = LayoutInflater.from(mContext);

        //Memberikan nilai arraylist dari class ClassNama
        this.arrayList = new ArrayList<ClassNama>();

        //Menambahkan semua elemen ke arraylist
        this.arrayList.addAll(Home_Activity.classNamaArrayList);
    }

    //membuat class untuk mendeklerasikan tempat untuk meletakan isi kedalam listview
    public class ViewHolder {

        //Mendeklarasikan variabel dengan jenis TextView
        TextView name;
    }

    //Fungsi getCount () mengembalikan jumlah item yang akan ditampilkan dalam list siap untuk
    //ditampilkan atau akan ditampilkan
    @Override
    public int getCount() {
        //mengembalikan nilai berupa jumlah data dari array data
        return Home_Activity.classNamaArrayList.size();
    }

    //Fungsi ini digunakan untuk mendapatkan data item yang terkait dengan posisi
    //tertentu dalam kumpulkan data untuk mendapatkan data yang sesuai dari lokasi
    //tertentu dalam pengumpulan  data item
    @Override
    public Object getItem(int i) {
        //mengengembalikan nilai berupa objek dari array data
        return Home_Activity.classNamaArrayList.get(i);
    }

    //Fungsi mengembalikan "nilai" dari posisi item ke adapter
    @Override
    public long getItemId(int i) {

        return i;
    }

    //fungsi ini secara otomatis dipanggil ketika tampilan item list siap untuk
    //ditampilkan atau akan ditampilkan
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //Deklarasi variabel dengan jenis data ViewHolder
        final ViewHolder holder;

        //Membuat kondisi apakah view null atau tidak
        if (view == null) {
            //membuat objek view holder
            holder = new ViewHolder();

            //Mengatur layout untuk menampilkan item
            view = inflater.inflate(R.layout.item_listview,null);

            //set id untuk text view
            holder.name = (TextView) view.findViewById(R.id.tvnama_item);

            //menyimpan data dalam tampilan tanpa menggunakan struktur data lain
            view.setTag(holder);

            }else {
            //Mengatur holder untuk mengembalikan nilai dari view tag
            holder = (ViewHolder) view.getTag();
        }
        //set item ke TextView
        holder.name.setText(Home_Activity.classNamaArrayList.get(i).getName());

        //Mengembalikkan nilai ke variabel view
        return view;
    }
}
