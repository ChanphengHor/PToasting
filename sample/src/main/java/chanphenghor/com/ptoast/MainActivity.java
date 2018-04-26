package chanphenghor.com.ptoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import chanphenghor.com.library.PToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PToast.edit()
                .setDuration(PToast.LENGTH_SHORT)
                .setGravity(Gravity.CENTER)
                .hasMargin(true)
                .setTransparent(false)
                .done();

        initViews();
    }

    private void initViews() {
        findViewById(R.id.toast_simple).setOnClickListener(this);
        findViewById(R.id.toast_danger).setOnClickListener(this);
        findViewById(R.id.toast_warning).setOnClickListener(this);
        findViewById(R.id.toast_info).setOnClickListener(this);
        findViewById(R.id.toast_success).setOnClickListener(this);
        findViewById(R.id.toast_strong).setOnClickListener(this);
        findViewById(R.id.toast_html).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toast_simple:
                PToast.show(this,"This is simple PToast !!");
                break;
            case R.id.toast_danger:
                PToast.danger(this,"This is Danger PToast !!");
                break;
            case R.id.toast_warning:
                PToast.warning(this,"This is Warning PToast !!");
                break;
            case R.id.toast_info:
                PToast.info(this,"This is Info PToast !!");
                break;
            case R.id.toast_success:
                PToast.success(this,"This is Success PToast !!");
                break;
            case R.id.toast_strong:
                PToast.success(this,"Strong : ","=> this is Strong PToast !!");
                break;
            case R.id.toast_html:
                PToast.successAsHTML(this,"<strong>Strong</strong> <u>Underline</u> => html Tag Toast");
                break;
        }
    }
}
