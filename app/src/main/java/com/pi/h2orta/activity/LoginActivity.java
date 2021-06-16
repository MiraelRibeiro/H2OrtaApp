package com.pi.h2orta.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.pi.h2orta.MainActivity;
import com.pi.h2orta.R;
import com.pi.h2orta.model.Usuario;

public class LoginActivity extends AppCompatActivity {

    private EditText campoEmail, campoSenha;
    private Switch switchLembrar;
    private TextView textCadastrar, textEsqueciSenha;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        autenticacao = FirebaseAuth.getInstance();

        inicializarComponentes();
    }

    public void fazerLogin(Usuario usuario){
        autenticacao.signInWithEmailAndPassword(
                usuario.getEmail(), usuario.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
                else {
                    String excessao = "";
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthInvalidUserException e){
                        excessao = "Usuário não cadastrado!";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        excessao = "Digite um email válido!";
                    }catch (FirebaseAuthUserCollisionException e){
                        excessao = "Esta conta ja foi cadastrada!";
                    }catch (Exception e){
                        excessao = "Erro ao encontrar usuário: " + e.getMessage();
                        e.printStackTrace();
                    }

                    Toast.makeText(LoginActivity.this, excessao, Toast.LENGTH_LONG).show();
                }
            }
        });

        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    public void fazerCadastro(View view){
        startActivity(new Intent(getApplicationContext(), CadastroActivity.class));
    }

    private void inicializarComponentes(){
        campoEmail = findViewById(R.id.editTextEmailLogin);
        campoSenha = findViewById(R.id.editTextSenhaLogin);
        switchLembrar = findViewById(R.id.switchLembrar);
        textCadastrar = findViewById(R.id.textViewCadastrar);
        textEsqueciSenha = findViewById(R.id.textViewRecuperar);
    }

    public void validarAutenticacaoUsuario(View view){
        String email = campoEmail.getText().toString();
        String senha = campoSenha.getText().toString();

        if (!email.isEmpty()){

            if (!senha.isEmpty()){
                Usuario usuario = new Usuario();
                usuario.setEmail(email);
                usuario.setSenha(senha);

                fazerLogin(usuario);
            }
            else{
                Toast.makeText(LoginActivity.this, "Preencha a senha", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(LoginActivity.this, "Preencha o e-mail", Toast.LENGTH_LONG).show();
        }
    }
}