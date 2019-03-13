package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.library.Techniques;
import com.example.library.YoYo;
import com.google.android.material.textfield.TextInputEditText;
import java.util.ArrayList;

public class write_message extends AppCompatActivity {
    private byte[] nEnkripsi;
    final static int RQS_PICK_CONTACT = 1;
    private Button mContact;
    private CardView mEnkripsi, mKirimPesan;
    private String mPassword, mKunci, mPesan, mHexaEnkrip, mNo, mPesanEnrip,  nNoTujuan;
    private TextInputEditText mNoTujuan, mNoKunci, mTulisPesan, mHasilEnkripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_message);

        mNoKunci = (TextInputEditText) findViewById(R.id.NoKunci);
        mNoTujuan = (TextInputEditText) findViewById(R.id.NoTujuan);
        mTulisPesan = (TextInputEditText) findViewById(R.id.TulisPesan);
        mHasilEnkripsi = (TextInputEditText) findViewById(R.id.HasilEnkripsi);

        mEnkripsi = (CardView) findViewById(R.id.Enkripsi);
        mKirimPesan = (CardView) findViewById(R.id.KirimPesan);
        mContact = (Button) findViewById(R.id.Contact);
        mHasilEnkripsi.setFocusable(false);

        mContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Uri uriContact = ContactsContract.Contacts.CONTENT_URI;
                Intent intentPickContact = new Intent(Intent.ACTION_PICK, uriContact);
                startActivityForResult(intentPickContact, RQS_PICK_CONTACT);
            }
        });

        findViewById(R.id.Enkripsi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Enkripsi();
            }
        });

        mKirimPesan.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View v) {
                KirimPesan();
            }
        });

    }



    private void Enkripsi() {
        RC6 rc6 = new RC6();

        //Mengambil Nilai Input
        nNoTujuan = mNoTujuan.getText().toString();
        mPassword = mNoKunci.getText().toString();
        mPesan = mTulisPesan.getText().toString();
        mKunci = mNoKunci.getText().toString();

        //Prosses Melakukan Cek Kondisi
        if (TextUtils.isEmpty(nNoTujuan)) {
            YoYo.with(Techniques.Shake).playOn(findViewById(R.id.notice1));

        } else if (TextUtils.isEmpty(mPassword)) {
            YoYo.with(Techniques.Shake).playOn(findViewById(R.id.notice2));

        } else if (TextUtils.isEmpty(mPesan)) {
            YoYo.with(Techniques.Shake).playOn(findViewById(R.id.notice3));

        } else if (mKunci.length() > 0 && mPesan.length() > 0) {
            nEnkripsi = rc6.encrypt(mPesan.getBytes(), mKunci.getBytes());
            mHexaEnkrip = byteArrayToHexString(nEnkripsi);
            mHasilEnkripsi.setText(mHexaEnkrip);
        }

    }
    private String byteArrayToHexString(byte[] b) {
        StringBuffer sb = new StringBuffer(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            int v = b[i] & 0xff;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString().toUpperCase();
    }

    private void KirimPesan() {
        mNo = mNoTujuan.getText().toString();
        mPesanEnrip = mHasilEnkripsi.getText().toString();

        if (mNo.length() > 0 && mPesanEnrip.length() > 0) {
            sendSMS(mNo, mPesanEnrip);

        } else if (mNo.length() > 0 && mHasilEnkripsi.length() == 0) {
            YoYo.with(Techniques.Shake).playOn(findViewById(R.id.notice4));

        } else {
            YoYo.with(Techniques.Shake).playOn(findViewById(R.id.notice1));
        }

    }

    private void sendSMS(String phoneNumber, String message) {
        String SENT = "SMS_SENT";
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        Toast.makeText(getBaseContext(), "SMS Sent", Toast.LENGTH_SHORT).show();
                        break;
                    case Activity.RESULT_CANCELED:
                        Toast.makeText(getBaseContext(), "SMS not delivered", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText(getBaseContext(), "Generic failure", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(getBaseContext(), "No Service", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        Toast.makeText(getBaseContext(), "Null PDU", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        Toast.makeText(getBaseContext(), "Radio Off", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        },new IntentFilter(SENT));

        SmsManager sms = SmsManager.getDefault();
        ArrayList<String> parts = sms.divideMessage(message);
        sms.sendMultipartTextMessage(phoneNumber, null, parts, null, null);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RQS_PICK_CONTACT && resultCode == Activity.RESULT_OK) {
            Uri contactData = data.getData();
            ContentResolver cr = getContentResolver();
            Cursor cur = managedQuery(contactData, null, null, null, null);

            if (cur.getCount() > 0) {
                while (cur.moveToNext()) {
                    String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));

                    if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {

                        Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                                new String[]{id},null);

                        while (pCur.moveToNext()) {
                            String nomorHp = pCur.getString(pCur.getColumnIndex
                                    (ContactsContract.CommonDataKinds.Phone.DATA));
                            mNoTujuan.setText(nomorHp);
                        }
                        pCur.close();
                    }
                }
            }
        }
    }

}
