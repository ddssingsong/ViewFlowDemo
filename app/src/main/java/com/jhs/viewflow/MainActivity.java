package com.jhs.viewflow;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jhs.viewflow.view.CircleFlowIndicator;
import com.jhs.viewflow.view.ViewFlow;

public class MainActivity extends AppCompatActivity {
    private ViewFlow viewFlow;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewFlow = (ViewFlow) findViewById(R.id.viewflow);
        viewFlow.setAdapter(new ImageAdapter(this), 0);

        CircleFlowIndicator indic = (CircleFlowIndicator) findViewById(R.id.viewflowindic);
        viewFlow.setFlowIndicator(indic);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "进入应用", Toast.LENGTH_SHORT).show();

            }
        });


        viewFlow.setOnViewSwitchListener(new ViewFlow.ViewSwitchListener() {
            @Override
            public void onSwitched(View view, int position) {
                if (viewFlow.getSelectedItemPosition() == viewFlow.getAdapter().getCount() - 1) {
                    button.setVisibility(View.VISIBLE);
                } else {
                    button.setVisibility(View.GONE);
                }
            }
        });
    }

    /*
     * If your min SDK version is < 8 you need to trigger the
     * onConfigurationChanged in ViewFlow manually, like this
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        viewFlow.onConfigurationChanged(newConfig);
    }
}
