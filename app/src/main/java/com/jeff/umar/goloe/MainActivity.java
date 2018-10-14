package com.jeff.umar.goloe;

        import android.content.Intent;
        import android.net.Uri;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.android.gms.auth.api.signin.GoogleSignIn;
        import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
        import com.google.android.gms.auth.api.signin.GoogleSignInClient;
        import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
        import com.google.android.gms.common.api.ApiException;
        import com.google.android.gms.tasks.Task;

        import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private GoogleSignInClient mGoogleSignInClient;
    private static int RC_SIGN_IN = 100;
    private TextView Name,Email;
    private ImageView ProfilePic;
    private Button btn,btnlogin;
    private String personGivenName;
    private String personFamilyName;
    private String personEmail;
    private Uri personPhoto;











    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestProfile()
                .build();



        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

        updateUI(account);







            mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

            findViewById(R.id.Login).setOnClickListener(this);

            btn= (Button)findViewById(R.id.Login);

        btnlogin= (Button)findViewById(R.id.Login);



    }



    private void openjeff() {
        Intent intent = new Intent(this, jeff.class);
        startActivity(intent);


    }



    public void googleBtnclicked(){
        btnlogin.setVisibility(View.INVISIBLE);
        btn.setVisibility(View.VISIBLE);



    }

    public void nextButtonclikced(){
        btn.setVisibility(View.INVISIBLE);
        btnlogin.setVisibility(View.VISIBLE);
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);


        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> task) {
        GoogleSignInAccount account1 = GoogleSignIn.getLastSignedInAccount(this);
        if (account1 != null) {

            Email.setText(account1.getEmail());
            Name.setText(account1.getDisplayName());



            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);


                updateUI(account);

                // Signed in successfully, show authenticated UI.
                updateUI(account);

            } catch (ApiException e) {
                // The ApiException status code indicates the detailed failure reason.
                // Please refer to the GoogleSignInStatusCodes class reference for more information.
                Toast.makeText(this, "sign in failed" + e.getStatusCode(), Toast.LENGTH_SHORT).show();


                updateUI(null);
            }
        }

    }

    private void updateUI(Object is) {
        {



        }
    }

    @Override
    public void onClick(View v) {
        openjeff();
        switch (v.getId()) {
            case R.id.Login:

                signIn();

                break;

    }
}

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();

        startActivityForResult(signInIntent, RC_SIGN_IN);



    }
    }


