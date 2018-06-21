package pl.pharmaway.prezentacjatrilac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Page0 extends FooterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViewById(R.id.trilac).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page0.this, Page1.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.ecomer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page0.this, Page5.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.antich).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
