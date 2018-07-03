package pl.pharmaway.prezentacjatrilac;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Page0 extends FooterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final FirstChoice firstChoice = new FirstChoice(getSharedPreferences("appPrefs", Context.MODE_PRIVATE));
        findViewById(R.id.trilac).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstChoice.setFirstChoice("trilac");
                Intent intent = new Intent(Page0.this, Page1.class);
                startActivity(intent);

            }
        });

        findViewById(R.id.ecomer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstChoice.setFirstChoice("ecomer");
                Intent intent = new Intent(Page0.this, Page5.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.antich).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstChoice.setFirstChoice("anti cholesteran");
                ContainerActivity.start(Page0.this, Page11.class, false);
            }
        });


    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page00;
    }

    @Override
    protected Class<?> getNextActivity() {
        return Page1.class;
    }
}
