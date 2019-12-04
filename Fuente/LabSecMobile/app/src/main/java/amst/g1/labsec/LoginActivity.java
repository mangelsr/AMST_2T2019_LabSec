package amst.g1.labsec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.util.Objects;

import amst.g1.labsec.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        binding.fabLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser, false);
    }

    private void updateUI(FirebaseUser currentUser, final boolean withRegister) {
        if (currentUser != null) {
            FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w("Instance", "getInstanceId failed",
                                    task.getException());
                            return;
                        }
                        String token = Objects.requireNonNull(task.getResult()).getToken();
                        if (withRegister)
                            sendRegistrationToServer(token);
                        Intent intent = new Intent(getApplicationContext(),
                                LabsListActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
        }
    }

    private void login() {
        String mail = Objects.requireNonNull(binding.etLoginEmail.getText()).toString();
        String password = Objects.requireNonNull(binding.etLoginPassword.getText()).toString();

        if (mail.isEmpty()) {
            binding.etLoginEmail.setError("This field is required");
            return;
        }

        if (password.isEmpty()) {
            binding.etLoginPassword.setError("This field is required");
            return;
        }

        binding.fabLogin.setEnabled(false);
        binding.pbLogin.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(mail, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        FirebaseUser user = mAuth.getCurrentUser();
                        updateUI(user, true);
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(getApplicationContext(), "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                        updateUI(null, false);
                    }
                    binding.fabLogin.setEnabled(true);
                    binding.pbLogin.setVisibility(View.GONE);
                }
            });
    }

    private void sendRegistrationToServer(String token) {
        FirebaseDatabase.getInstance().getReference().child("tokens").child(token).setValue(true);
        Toast.makeText(getApplicationContext(), "token registered",
                Toast.LENGTH_SHORT).show();
    }


}
