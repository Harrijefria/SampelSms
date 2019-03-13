package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import androidx.cardview.widget.CardView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class read_message extends AppCompatActivity {
    private TextInputEditText NoKunci, NoPesan, NoHasil, NoPengirim;
    private CardView Dekripsi;
    private byte[] Dekrips, Bpesan;
    private String Skunci, Spesan, HasilDekrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_message);

        Bundle extras = getIntent().getExtras();
        String no = extras.getString(inbox.nosms);
        String isi = extras.getString(inbox.isisms);

        NoPesan = (TextInputEditText) findViewById(R.id.NoPesan);
        NoPesan.setFocusable(false);
        NoPesan.setText(isi);

        NoHasil = (TextInputEditText) findViewById(R.id.NoHasil);
        NoHasil.setFocusable(false);

        NoPengirim = (TextInputEditText) findViewById(R.id.NoPengirim);
        NoPengirim.setText(no);

        NoKunci = (TextInputEditText) findViewById(R.id.NoKunci);
        Dekripsi = (CardView) findViewById(R.id.Dekripsi);

        Dekripsi.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dekripsi();
            }
        });

    }

    private void Dekripsi() {
        try {
            RC6 rc6 = new RC6();
            Skunci = NoKunci.getText().toString();
            Spesan = NoKunci.getText().toString();

            if (Skunci.length() > 0) {
                Bpesan = Hex2Byte(Spesan);
                Dekrips = rc6.decrypt(Bpesan, Skunci.getBytes());
                HasilDekrip = new String(Dekrips);
                NoHasil.setText(HasilDekrip);
            } else {
                Toast.makeText(getBaseContext(), "kunci tidak boleh kosong", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Bukan SMS Terenkripsi", Toast.LENGTH_LONG).show();
        }
    }

    //Konversi Hexa Ke Byte
    private byte[] Hex2Byte(String str) {
        byte[] bytes = new byte[str.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer
                    .parseInt(str.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }

}
