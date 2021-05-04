package pt.mmobile.navigationdrawer;

import android.drm.DrmStore;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ///criando uma vaiavel para referenciar a toolbar
    private Toolbar toolbar;
    ///criando uma vaiavel para referenciar a drawer layout
    private DrawerLayout drawerLayout;
    ///criando uma vaiavel para referenciar a navigationView
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ligação entre a variavel e o arquivo de layout
        toolbar = findViewById(R.id.toolBar);

        setSupportActionBar(toolbar);

        //configuração do botão de menu presente na tool bar
        //cria uma instancia para este obj
        final ActionBar actionBar = getSupportActionBar();
        //configuração para aparecer nosso menu na toolbar(define que vai usar o botao)
        actionBar.setDisplayHomeAsUpEnabled(true);
        //define o icone que vamos usar
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        //ligação entre a variavel e o arquivo de layout
        drawerLayout = findViewById(R.id.drawer);

        //ligação entre a variavel e o arquivo de layout
        navigationView = findViewById(R.id.navigationView);
        //configurção de um evento
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_opc1:
                        menuItem.setChecked(true);
                        mostrarMensagem("Opção 1");
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_opc2:
                        menuItem.setChecked(true);
                        mostrarMensagem("Opção 2");
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_opc3:
                        menuItem.setChecked(true);
                        mostrarMensagem("Opção 3");
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_opc4:
                        menuItem.setChecked(true);
                        mostrarMensagem("Opção 4");
                        drawerLayout.closeDrawers();
                        return true;
                }

                return false;
            }
        });
    }
    //passar a  mensagem sem ter que configurar manualmnte todas as ezes
    private void mostrarMensagem(String mensagem){
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
    // ao clicar no item na tool bar o navigation abre(abrir o menu instantaneamete)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            //verifica se o botao foi selecionado
            case android.R.id.home:
                //se foi selecionado abrir o drawer
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        // se nada for selecionado n fazemos nada
        return super.onOptionsItemSelected(item);
    }
}