package com.example.faturahesap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText AktifTuketim;
    EditText DagıtımBirimFiyat;
    TextView DagıtımBedeli;
    EditText gunduz;
    EditText puant;
    EditText gece;
    Button buton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gunduz = (EditText) findViewById(R.id.editText);
        puant = (EditText) findViewById(R.id.editText4);
        gece = (EditText) findViewById(R.id.editText5);

        AktifTuketim = (EditText) findViewById(R.id.editText3);
        DagıtımBirimFiyat = (EditText) findViewById(R.id.editText2);

        DagıtımBedeli = (TextView) findViewById(R.id.textView5);
        buton = (Button)findViewById(R.id.button);



        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a1 = Integer.parseInt(gunduz.getText().toString());
                int a2 = Integer.parseInt(puant.getText().toString());
                int a3 = Integer.parseInt(gece.getText().toString());

                int ToplamTuketimTutarı = a1 + a2 + a3;        //Aktif teketim

                int s1 = Integer.parseInt(AktifTuketim.getText().toString());
                int s2 = Integer.parseInt(DagıtımBirimFiyat.getText().toString());
                int toplam0 =  s1 * s2 ;                  //Dağılım bedeli
                //DagıtımBedeli.setText(String.valueOf(sonuc));

                int EnerjiFonu = (int) (ToplamTuketimTutarı * 0.01);
                int TrTPayı = (int) (ToplamTuketimTutarı * 0.02);
                int ETV = (int) (ToplamTuketimTutarı * 0.05);

                int Toplam = ToplamTuketimTutarı + toplam0 + EnerjiFonu + TrTPayı + ETV ;

                int KDV = (int) (Toplam * 0.18);

                int Fatura = Toplam + KDV ;

                DagıtımBedeli.setText(String.valueOf(Fatura));



            }

        });
    }
}
