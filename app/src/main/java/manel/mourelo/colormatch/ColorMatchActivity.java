package manel.mourelo.colormatch;

import android.content.Intent;
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

    Style style = new Style(false, 0xffffffff, 0xff000000);

    public static final int EDITTEXTCOLOR = 0;
    public static final int EDITBGCOLOR = 1;

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
        editableText.setTextColor(newStyle.getTextColor());
        bgColorview.setText(Integer.toString(newStyle.getBgColor()));
        bgColor.setBackgroundColor(newStyle.getBgColor());
    }

    public void setNewText(View view) {
        if(editor.getText().toString().isEmpty() == false){
            editableText.setText(editor.getText());
        }
        else{
            Toast.makeText(this, "ERROR: editor was empty", Toast.LENGTH_SHORT).show();
        }
    }

    public void setBold(View view) {
        style.setBolt(checkBox.isChecked());
        if(checkBox.isChecked() == true){
            editableText.setTypeface(null, Typeface.BOLD);
        }
        else{
            editableText.setTypeface(null, Typeface.NORMAL);
        }
    }

    public void setTextColor(View view) {
        Intent intent = new Intent(this, ChooseColorActivity.class);
        startActivityForResult(intent, EDITTEXTCOLOR);
    }

    public void setBGColor(View view) {
        Intent intent = new Intent(this, ChooseColorActivity.class);
        startActivityForResult(intent, EDITBGCOLOR);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case EDITTEXTCOLOR:
                    if(resultCode == RESULT_OK){
                        style.setTextColor(data.getIntExtra("color", style.getTextColor()));
                        setFromStyle(style);
                    }
                break;
            case EDITBGCOLOR:
                if(resultCode == RESULT_OK){
                    style.setBgColor(data.getIntExtra("color", style.getBgColor()));
                    setFromStyle(style);
                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }
}
