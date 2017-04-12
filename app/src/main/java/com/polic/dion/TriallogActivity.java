package com.polic.dion;

/**
 * Created by moose on 4/12/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class TriallogActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;

    private TextView tvEmail;
    private Button bLogout, bUserArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triallog);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvEmail.setText(TriallogActivity.this.getString(R.string.Welcome)+ user.getEmail());

        tvEmail = (TextView) findViewById(R.id.tvEmail);
        bLogout = (Button) findViewById(R.id.bLogout);
        bUserArea = (Button) findViewById(R.id.bUserArea);


        bLogout.setOnClickListener(this);
        bUserArea.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view == bLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

        if(view == bUserArea) {
            finish();
            startActivity(new Intent(this,UserAreaActivity.class));
        }

    }
}
