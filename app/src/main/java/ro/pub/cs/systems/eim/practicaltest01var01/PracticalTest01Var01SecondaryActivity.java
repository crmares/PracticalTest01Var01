package ro.pub.cs.systems.eim.practicaltest01var01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var01SecondaryActivity extends AppCompatActivity {



    private Button button_ok = null;
    private Button button_cancel = null;
    private TextView textView_out2 = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.button_ok:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.button_cancel:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_secondary);

        textView_out2 = (TextView)findViewById(R.id.textView_out2);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("coordinates")) {
            String coordinates = intent.getStringExtra("coordinates");
            textView_out2.setText(coordinates);
        }

        button_ok= (Button)findViewById(R.id.button_ok);
        button_ok.setOnClickListener(buttonClickListener);
        button_cancel = (Button)findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(buttonClickListener);
    }

}
