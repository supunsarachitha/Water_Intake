package lk.stechbuzz.waterintake;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Schedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        WebView view = (WebView) findViewById(R.id.textContent);
        String text;
        text = "<html><body><p align=\"justify\">";
        text+= getString(R.string.drinking_notice);
        text+= "</p></body></html>";
        view.loadData(text, "text/html", "utf-8");

    }


    @Override
    public void onBackPressed() {



        TextView txtTarget = (TextView) findViewById(R.id.txtTarget);
        int lit =Integer.parseInt(txtTarget.getText().toString())*1000;
        MainActivity.target =lit/250;

        super.onBackPressed();
    }
}
