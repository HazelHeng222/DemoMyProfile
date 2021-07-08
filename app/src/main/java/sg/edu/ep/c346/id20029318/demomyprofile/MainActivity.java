package sg.edu.ep.c346.id20029318.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGPA = findViewById(R.id.GPA);
        etName = findViewById(R.id.Name);
    }


    @Override
    protected void onPause() {
        super.onPause();
        String strName = etName.getText().toString();
        float gpa = Float.parseFloat(etGPA.getText().toString());

        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEd = pref.edit();
        prefEd.putString("Name",strName);
        prefEd.putFloat("GPA", gpa);
        prefEd.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        String strName = pref.getString("name", "John");
        float gpa = pref.getFloat("GPA", 3.0f);

        etName.setText(strName);
        etGPA.setText(gpa + "");

    }
}