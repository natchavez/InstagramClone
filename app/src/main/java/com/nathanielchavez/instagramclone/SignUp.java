package com.nathanielchavez.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity {

    private EditText mtxtName, mtxtPunchSpeed, mtxtPunchPower, mtxtKickSpeed, mtxtKickPower;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendInfo(View view) {
        mtxtName = findViewById(R.id.txtName);
        mtxtPunchSpeed = findViewById(R.id.txtPunchSpeed);
        mtxtPunchPower = findViewById(R.id.txtPunchPower);
        mtxtKickSpeed = findViewById(R.id.txtKickSpeed);
        mtxtKickPower = findViewById(R.id.txtKickPower);

        try {
            final ParseObject kickBoxer = new ParseObject("KickBoxer");
            kickBoxer.put("name", mtxtName.getText().toString());
            kickBoxer.put("punch_speed", Integer.parseInt(mtxtPunchSpeed.getText().toString()));
            kickBoxer.put("punch_power", Integer.parseInt(mtxtPunchPower.getText().toString()));
            kickBoxer.put("kick_speed", Integer.parseInt(mtxtKickSpeed.getText().toString()));
            kickBoxer.put("kick_power", Integer.parseInt(mtxtKickPower.getText().toString()));
            kickBoxer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        FancyToast.makeText(SignUp.this, kickBoxer.get("name") + " is added",
                                FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                    } else {
                        FancyToast.makeText(SignUp.this, e.getMessage(),
                                FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                    }
                }
            });
        }catch (Exception e) {
            FancyToast.makeText(SignUp.this, e.getMessage(),
                    FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
        }
    }
}
