package chanphenghor.com.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.text.Html;
import android.text.Spanned;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by HOR CHANPHENG on 4/24/2018.
 */

public class PToast {
    private static int PToast_Gravity = Gravity.BOTTOM;
    private static int PToast_Duration = PToast.LENGTH_SHORT;
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;
    private static int simpleColor = Color.parseColor("#86d82727");
    private static int dangerColor = Color.parseColor("#86d82727");
    private static int warningColor = Color.parseColor("#FDAF17");
    private static int infoColor = Color.parseColor("#D9EDF7");
    private static int successColor = Color.parseColor("#61A364");
    private static boolean hasMargin = true;
    public PToast() {

    }
    //================= simple text
    public static void show(Context context,String message){
        inflate(context,message,simpleColor);
    }
    public static void danger(Context context,String message){
        inflate(context,message,dangerColor);
    }
    public static void warning(Context context,String message){
        inflate(context,message,warningColor);
    }
    public static void info(Context context,String message){
        inflate(context,message,infoColor);
    }
    public static void success(Context context,String message){
        inflate(context,message,successColor);
    }
    //================= html Message
    public static void showAsHTML(Context context,String html){
        inflateHTML(context,html,simpleColor);
    }
    public static void dangerAsHTML(Context context,String html){
        inflateHTML(context,html,dangerColor);
    }
    public static void warningAsHTML(Context context,String html){
        inflateHTML(context,html,warningColor);
    }
    public static void infoAsHTML(Context context,String html){
        inflateHTML(context,html,infoColor);
    }
    public static void successAsHTML(Context context,String html){
        inflateHTML(context,html,successColor);
    }
    //================== Strong Text
    public static void warning(Context context,String strongText,String message){
        inflateStrong(context,strongText,message,warningColor);
    }
    public static void info(Context context,String strongText,String message){
        inflateStrong(context,strongText,message,infoColor);
    }
    public static void success(Context context,String strongText,String message){
        inflateStrong(context,strongText,message,successColor);
    }
    public static void danger(Context context,String strongText,String message){
        inflateStrong(context,strongText,message,dangerColor);
    }

    public static void show(Context context,String strongText,String message){
        inflateStrong(context,strongText,message,simpleColor);
    }

    private static void inflate(Context context,String message,int bgColor){
        LayoutInflater inflater;
        View v;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.danger_toast, null);
        v.findViewById(R.id.ll_root).setBackgroundColor(bgColor);
        if(hasMargin){
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            p.setMargins(8,8,8,8);
            v.findViewById(R.id.ll_root).setLayoutParams(p);
        }else {
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            p.setMargins(0,0,0,0);
            v.findViewById(R.id.ll_root).setLayoutParams(p);
        }
        TextView tv_message = v.findViewById(R.id.tv_message);
        tv_message.setText(message);
        show(context,v);
    }
    private static void inflateHTML(Context context,String html,int bgColor){
        LayoutInflater inflater;
        View v;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.danger_toast, null);
        v.findViewById(R.id.ll_root).setBackgroundColor(bgColor);
        if(hasMargin){
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            p.setMargins(8,8,8,8);
            v.findViewById(R.id.ll_root).setLayoutParams(p);
        }else {
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            p.setMargins(0,0,0,0);
            v.findViewById(R.id.ll_root).setLayoutParams(p);
        }
        TextView tv_message = v.findViewById(R.id.tv_message);
        tv_message.setText(fromHtml(html));
        show(context,v);
    }

    public static void inflateStrong(Context context,String strongText,String message,int color){
        LayoutInflater inflater;
        View v;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.simple_toast, null);
        v.findViewById(R.id.ll_root).setBackgroundColor(color);
        if(hasMargin){
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            p.setMargins(8,8,8,8);
            v.findViewById(R.id.ll_root).setLayoutParams(p);
        }else {
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            p.setMargins(0,0,0,0);
            v.findViewById(R.id.ll_root).setLayoutParams(p);
        }
        TextView tv_message = v.findViewById(R.id.tv_message);

        tv_message.setText(Html.fromHtml("<strong>"+strongText+"</strong>"+" "+message));
        show(context,v);
    }
    @SuppressWarnings("deprecation")
    public static Spanned fromHtml(String html){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(html);
        }
    }
    @SuppressLint("WrongConstant")
    private static void show(Context context, View v){
        Toast toast = new Toast(context);
        toast.setGravity(PToast.PToast_Gravity, 0, 0);
        toast.setDuration(PToast.PToast_Duration);
        toast.setView(v);
        toast.show();
    }

    //=======================================================
        public static PToast edit(){
            return new PToast();
        }
        private int _PToast_Gravity = PToast.PToast_Gravity;
        private int _PToast_Duration = PToast.PToast_Duration;
        public PToast setGravity(int Gravity){
            _PToast_Gravity = Gravity;
            return this;
        }
        public PToast setDuration(int LENGTH){
            _PToast_Duration = LENGTH;
            return this;
        }
        public PToast setTransparent(boolean transparent){
            getTransparent(transparent);
            return this;
        }
        public PToast hasMargin(boolean transparent){
            if(transparent){
                hasMargin = true;
            }else {
                hasMargin = false;
            }
            return this;
        }
        private void getTransparent(boolean transparent){
            if(transparent){
                PToast.dangerColor = Color.parseColor("#86d82727");
                PToast.simpleColor = Color.parseColor("#8b464343");
                PToast.warningColor = Color.parseColor("#a4fdaf17");
                PToast.infoColor = Color.parseColor("#b156bbd9");
                PToast.successColor = Color.parseColor("#bd61a364");
            }else {
                PToast.dangerColor = Color.parseColor("#D82727");
                PToast.simpleColor = Color.parseColor("#464343");
                PToast.warningColor = Color.parseColor("#FDAF17");
                PToast.infoColor = Color.parseColor("#56BBD9");
                PToast.successColor = Color.parseColor("#61A364");
            }
        }
        public void done(){
            PToast.PToast_Gravity = _PToast_Gravity;
            PToast.PToast_Duration = _PToast_Duration;
        }

}
