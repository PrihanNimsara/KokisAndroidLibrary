package prihanofficial.com.kokisandroidlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import prihanofficial.com.kokis.helpers.Mode;
import prihanofficial.com.kokis.helpers.UserDefault;
import prihanofficial.com.kokis.logics.Kokis;

public class MainActivity extends AppCompatActivity {

    //region Decalre a variables
    private byte[] examplebytes;
    private Short exampleShort;
    private int exampleInt;
    private long exampleLong;
    private float exampleFloat;
    private double exampleDouble;
    private boolean exampleBoolean;
    private String exampleString;

    private byte[] examplebytes1;
    private Short exampleShort1;
    private int exampleInt1;
    private long exampleLong1;
    private float exampleFloat1;
    private double exampleDouble1;
    private boolean exampleBoolean1;
    private String exampleString1;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region Assigning values to variables
        examplebytes = new byte[100];
        exampleShort = 105;
        exampleInt = 100;
        exampleLong = 34l;
        exampleFloat = 23.4f;
        exampleDouble = 28.21;
        exampleBoolean = true;
        exampleString = "Hello Kokis";
        //endregion

        //region Initializing Kokis Class
        Kokis.setContext(this)
                .setSharedPreferencesName(getPackageName())
                .setMode(Mode.PRIVATE)
                .setUseDefaultSharedPreference(UserDefault.NO)
                .build();
        //endregion

        //region Set values to Kokis Libraray
        Kokis.setKokisByteArray("MyFirstByteArray", examplebytes);
        Kokis.setKokisShort("MyFirstShort", exampleShort);
        Kokis.setKokisInt("MyFirstInt", 100);
        Kokis.setKokisLong("MyFirstLong", 3l);
        Kokis.setKokisFloat("MyFirstFloat", 2.3f);
        Kokis.setKokisDouble("MyFirstDouble", 98.32);
        Kokis.setKokisBoolean("MyFirstBoolean", true);
        Kokis.setKokisString("MyFirstString", "Prihan Nimsara");
        //endregion

        //region Get value from Kokis Library
        examplebytes1 = Kokis.getKokisByteArray("MyFirstByteArray", "");
        exampleShort1 = Kokis.getKokisShort("MyFirstShort", "");
        exampleInt1 = Kokis.getKokisInt("MyFirstInt", 0);
        exampleLong1 = Kokis.getKokisLong("MyFirstLong", 0);
        exampleFloat1 = Kokis.getKokisFloat("MyFirstFloat", 0);
        exampleDouble1 = Kokis.getKokisDouble("MyFirstDouble", "");
        exampleBoolean1 = Kokis.getKokisBoolean("MyFirstBoolean", false);
        exampleString1 = Kokis.getKokisString("MyFirstString", "");

        System.out.println("**************************");
        System.out.println(exampleString1.toString());
        System.out.println(Double.toString(exampleDouble1));
        System.out.println("**************************");
        //endregion

        //region Clear data from sharedpreferences
        Kokis.deleteKokisKey("MyFirstString");
        Kokis.clearAllKokisData();
        //endregion

    }
}
