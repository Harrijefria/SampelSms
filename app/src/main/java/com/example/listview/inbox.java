package com.example.listview;

import android.Manifest;
import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

public class inbox extends ListActivity {

    public static final String nosms = "no";
    public static final String isisms = "isi";
    String[] sms2no;
    String[] sms2isi;

    private static final int PERMISSION_CALLBACK_CONSTANT = 100;
    private static final int REQUEST_PERMISSION_SETTING = 101;
    String[] permissionsRequired = new String[] { Manifest.permission.READ_SMS, Manifest.permission.SEND_SMS, Manifest.permission.READ_CONTACTS };

    @Override
    public void onCreate(Bundle Harri) {
        super.onCreate(Harri);

        Uri cek = Uri.parse("content://sms/inbox");
        Cursor database = getContentResolver().query (cek, new String[] {"_id", "thread_id", "address", "person", "date", "body" },
                null, null, null, null);

        String smsno = " ";
        String smsisi = " ";

        while (database.moveToNext()) {
            smsno += database.getString(2) + "@";
            smsisi += database.getString(5) + "@";
        }

        sms2no = smsno.split("\\@");
        sms2isi = smsisi.split("\\@");
        String[] listsms = new String[sms2no.length];

        for (int i = 0; i < sms2no.length; i++) {
            if (sms2isi[i].length() >= 20) {
                listsms[i] = sms2no[i] + "\n" + sms2isi[i].substring(0, 20) + " ...";
            } else if (sms2isi[i].length() < 20 && sms2isi.length >= 0) {
                listsms[i] = sms2no[i] + "\n" + sms2isi[i];
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listsms);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = new Intent(this, read_message.class);
        //oper nomor pengirim sms ke form baca_sms
        i.putExtra(nosms, sms2no[position]);
        //oper isi pengirim sms ke form baca_sms
        i.putExtra(isisms, sms2isi[position]);
        startActivity(i);
    }
}
