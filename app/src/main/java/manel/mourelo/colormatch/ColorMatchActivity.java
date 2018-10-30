package manel.mourelo.colormatch;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ColorMatchActivity extends AppCompatActivity {

    private TextView editableText;
    private ImageView bgColor;
    private EditText editor;
    private CheckBox checkBox;
    private TextView textColorview;
    private TextView bgColorview;

    Style style = new Style(false, 0, 0);

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

        setFromStyle(style);

    }

    public void setFromStyle(Style newStyle){
        checkBox.setChecked(newStyle.isBolt());
        if(newStyle.isBolt() == true){
            editableText.setTypeface(null, Typeface.BOLD);
        }
        else{
            editableText.setTypeface(null, Typeface.NORMAL);
        }
        textColorview.setText(Integer.toString(newStyle.getTextColor()));
        bgColorview.setText(Integer.toString(newStyle.getBgColor()));
    }

    public void setNewText(View view) {
        if(editor.getText().toString().isEmpty() == false){
            editableText.setText(editor.getText());
        }
        else{
            Toast.makeText(this, "ERROR: editor was empty", Toast.LENGTH_SHORT).show();
        }
    }
}
