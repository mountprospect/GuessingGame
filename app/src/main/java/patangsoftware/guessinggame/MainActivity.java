package patangsoftware.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int maxNum = 100;
    int minNum = 0;
    Random rand = new Random();
    TextView textViewMessage;
    EditText inputNum;
    Button submit;
    int targetNum, numberTries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewMessage = (TextView) findViewById(R.id.textViewMessage);
        inputNum = (EditText) findViewById(R.id.NumberEntered);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(this);

        newGame();

    }

    @Override
    public void onClick(View view) {
        if (view == submit) {
            submit();
        }

    }

    private void submit() {
        int n = Integer.parseInt(inputNum.getText().toString());
        numberTries++;

        if (n == targetNum) {
            Toast.makeText(this, "Correct! You guessed " + targetNum + " after " + numberTries + " tries "
                    , Toast.LENGTH_LONG).show();
            newGame();
        } else if (n > targetNum) {
            textViewMessage.setText(R.string.too_high);
        } else if (n < targetNum) {
            textViewMessage.setText(R.string.too_low);
        } else if (n > maxNum) {
            textViewMessage.setText(R.string.out_of_range);

        } else {
            textViewMessage.setText(R.string.invalid_input);
        }
    }

    private void newGame() {
        targetNum = rand.nextInt(maxNum) + 1;
        textViewMessage.setText(R.string.start_message);
        inputNum.setText("");
        numberTries = 0;
    }
}

