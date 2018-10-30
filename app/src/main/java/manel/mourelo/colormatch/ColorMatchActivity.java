package manel.mourelo.colormatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ColorMatchActivity extends AppCompatActivity {

    private TextView editableText;
    private ImageView bgColor;
    private EditText editor;
    private CheckBox checkBox;
    private TextView textColorview;
    private TextView bgColorview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_match);

        editableText = findViewById(R.id.editableTextView);
        bgColor = findViewById(R.id.backgroundView);
        editor = findViewById(R.id.editText);
        checkBox = findViewById(R.id.checkBoxBold);
        textColorview = findViewById(R.id.textColorView);
        bgColorview = findViewById(R.id.BGColorView);

    }
}
