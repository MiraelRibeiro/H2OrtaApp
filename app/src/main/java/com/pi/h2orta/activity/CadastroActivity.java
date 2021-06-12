package com.pi.h2orta.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pi.h2orta.MainActivity;
import com.pi.h2orta.R;
import com.pi.h2orta.model.Usuario;

public class CadastroActivity extends AppCompatActivity {

    private EditText campoNome, campoSobrenome, campoUser, campoCpf, campoSenha, campoConfSenha;
    private EditText campoEmail, campoEndereco, campoCidade, campoCep;
    private Spinner spinnerEstado, spinnerPais;
    private Button btnCadastrar;

    private FirebaseAuth autenticacao = FirebaseAuth.getInstance();
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        usuario = new Usuario();
        inicializarComponentes();
    }

    public void validarCadastro(View view){
        String textoNome = campoNome.getText().toString();
        String textoSobrenome = campoSobrenome.getText().toString();
        String textoUser = campoUser.getText().toString();
        String textoCpf = campoCpf.getText().toString();
        String textoSenha = campoSenha.getText().toString();
        String textoConfSenha = campoConfSenha.getText().toString();
        String textoEmail = campoEmail.getText().toString();
        String textoEndereco = campoEndereco.getText().toString();
        String textoCidade = campoCidade.getText().toString();
        String textoCep = campoCep.getText().toString();
        String textoEstado = spinnerEstado.getTransitionName().toString();
        String textoPais = spinnerPais.getTransitionName().toString();

        if (!textoNome.isEmpty() || textoNome.length() >=3){

            if (!textoSobrenome.isEmpty() || textoSobrenome.length() >=3){

                if (!textoUser.isEmpty() || textoUser.length() >=3){

                    if (!textoCpf.isEmpty() || textoCpf.length() == 11){

                        if (!textoSenha.isEmpty() || textoSenha.length() >=6){

                            if (!textoConfSenha.isEmpty() && textoConfSenha == textoSenha){

                                if (!textoEmail.isEmpty() || textoEmail.length() >=3){

                                    if (!textoEndereco.isEmpty()){

                                        if (!textoCidade.isEmpty()){

                                            if (!textoCep.isEmpty() || textoCep.length() >=6){

                                                if (!textoEstado.isEmpty()){

                                                    if (!textoPais.isEmpty()){

                                                        usuario.setNome(textoNome);
                                                        usuario.setSobrenome(textoSobrenome);
                                                        usuario.setUser(textoUser);
                                                        usuario.setCpf(textoCpf);
                                                        usuario.setSenha(textoSenha);
                                                        usuario.setConfSenha(textoConfSenha);
                                                        usuario.setEmail(textoEmail);
                                                        usuario.setEndereco(textoEndereco);
                                                        usuario.setCidade(textoCidade);
                                                        usuario.setCep(textoCep);
                                                        usuario.setEstado(textoEstado);
                                                        usuario.setPais(textoPais);

                                                        cadastrar();
                                                    }
                                                    else{
                                                        Toast.makeText(this, "país", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                                else{
                                                    Toast.makeText(this, "estado", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                            else{
                                                Toast.makeText(this, "cep", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                        else{
                                            Toast.makeText(this, "cidade", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    else{
                                        Toast.makeText(this, "endereço", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else{
                                    Toast.makeText(this, "email", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(this, "confirmar senha", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(this, "senha", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(this, "Cpf", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(this, "User", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(this, "Sobrenome", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Nome", Toast.LENGTH_SHORT).show();
        }
    }

    private void cadastrar(){
        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(), usuario.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    try {
                        FirebaseUser user =autenticacao.getCurrentUser();
                        usuario.setId(user.getUid());
                        usuario.salvarDados();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    Toast.makeText(CadastroActivity.this, "Sucesso ao cadastrar usuário!", Toast.LENGTH_LONG).show();
                    finish();
                }
                else {
                    String excessao = "";
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){
                        excessao = "Digite uma senha mais forte!";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        excessao = "Digite um email válido!";
                    }catch (FirebaseAuthUserCollisionException e){
                        excessao = "Esta conta ja foi cadastrada!";
                    }catch (Exception e){
                        excessao = "Erro ao encontrar usuário: " + e.getMessage();
                        e.printStackTrace();
                    }

                    Toast.makeText(CadastroActivity.this, excessao, Toast.LENGTH_LONG).show();
                }
            }
        });
        Toast.makeText(this, "Cadastro criado com sucesso!", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void inicializarComponentes(){
        campoNome = findViewById(R.id.editTextNome);
        campoSobrenome = findViewById(R.id.editTextSobrenome);
        campoUser = findViewById(R.id.editTextUser);
        campoCpf = findViewById(R.id.editTextCPF);
        campoSenha = findViewById(R.id.editTextSenha);
        campoConfSenha = findViewById(R.id.editTextConfSenha);
        campoEmail = findViewById(R.id.editTextEmail);
        campoEndereco = findViewById(R.id.editTextEndereco);
        campoCidade = findViewById(R.id.editTextCidade);
        campoCep = findViewById(R.id.editTextCEP);
        spinnerEstado = findViewById(R.id.spinnerEstado);
        spinnerPais = findViewById(R.id.spinnerPais);
        btnCadastrar = findViewById(R.id.btnCadastrar);

    }
}