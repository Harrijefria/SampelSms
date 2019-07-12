package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import com.example.library.Techniques;
import com.example.library.YoYo;
import com.google.android.material.textfield.TextInputEditText;
import androidx.cardview.widget.CardView;
import android.os.Bundle;
import android.text.TextUtils;
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

        NoKunci = (TextInputEditText) findViewById(R.id.NoKunci);
        NoPesan = (TextInputEditText) findViewById(R.id.NoPesan);
        NoHasil = (TextInputEditText) findViewById(R.id.NoHasil);
        NoPengirim = (TextInputEditText) findViewById(R.id.NoPengirim);
        Dekripsi = (CardView) findViewById(R.id.Dekripsi);

        NoPesan.setFocusable(false);
        NoHasil.setFocusable(false);
        NoPengirim.setText(no);
        NoPesan.setText(isi);

        Dekripsi.setOnClickListener(v -> Dekripsi());
    }
    private void Dekripsi() {
        RC6 rc6 = new RC6();
        Skunci = NoKunci.getText().toString();
        Spesan = NoPesan.getText().toString();

        try {
            if (Skunci.length() > 0) {
                Bpesan = Hex2Byte(Spesan);
                Dekrips = rc6.decrypt(Bpesan, Skunci.getBytes());
                HasilDekrip = new String(Dekrips);
                NoHasil.setText(HasilDekrip);
            } else if (TextUtils.isEmpty(Skunci)){
                YoYo.with(Techniques.Shake).playOn(findViewById(R.id.notice0));
            }
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Bukan SMS Terenkripsi", Toast.LENGTH_LONG).show();
        }
    }


    private byte[] Hex2Byte(String str) {
        byte[] bytes = new byte[str.length() / 2];

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(str.substring(2 * i, 2 * i + 2), 16);
        }

        return bytes;
    }

}
