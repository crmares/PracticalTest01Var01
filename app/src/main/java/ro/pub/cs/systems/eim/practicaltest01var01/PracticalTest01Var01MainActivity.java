package ro.pub.cs.systems.eim.practicaltest01var01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class PracticalTest01Var01MainActivity extends AppCompatActivity {

    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    private int pressed = 0;

    private TextView textView_out = null;
    private Button button_north = null;
    private Button button_south = null;
    private Button button_east = null;
    private Button button_west = null;
    private Button button_nav = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_main);

        textView_out = (TextView)findViewById(R.id.textView_out);

        //textView_out.setText(String.valueOf(0));

        button_east = (Button)findViewById(R.id.button_east);
        button_north = (Button)findViewById(R.id.button_north);
        button_west = (Button)findViewById(R.id.button_west);
        button_south = (Button)findViewById(R.id.button_south);
       // button_nav = (Button)findViewById(R.id.button_nav);


        button_east.setOnClickListener(buttonClickListener);
        button_north.setOnClickListener(buttonClickListener);
        button_west.setOnClickListener(buttonClickListener);
        button_south.setOnClickListener(buttonClickListener);
       // button_nav.setOnClickListener(buttonClickListener);

        button_nav = (Button)findViewById(R.id.button_nav);
        button_nav.setOnClickListener(buttonClickListener);

    }

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.button_north:
                    textView_out.setText(textView_out.getText().toString() + "North, " );
                    pressed++;
                    break;
                case R.id.button_south:
                    textView_out.setText(textView_out.getText().toString() + "South, " );
                    pressed++;
                    break;
                case R.id.button_west:
                    textView_out.setText(textView_out.getText().toString() + "West, " );
                    pressed++;
                    break;
                case R.id.button_east:
                    textView_out.setText(textView_out.getText().toString() + "East, " );
                    pressed++;
                    break;
                case R.id.button_nav:
//                    Toast.makeText(getApplicationContext(), String.valueOf(pressed), 5000).show();
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var01SecondaryActivity.class);
                    intent.putExtra("coordinates", textView_out.getText().toString());
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("pressed", pressed);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("pressed")) {
            pressed = savedInstanceState.getInt("pressed");
        } else {
            pressed = 0;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
            textView_out.setText("");

        }
    }

}
