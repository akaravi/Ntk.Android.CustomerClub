package ntk.android.customerclub.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import ntk.android.base.activity.BaseActivity;
import ntk.android.base.adapter.BaseRecyclerAdapter;
import ntk.android.base.utill.FontManager;
import ntk.android.base.utill.prefrense.Preferences;
import ntk.android.customerclub.R;

public class Class7 extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class7);
        initSize();
        sefont();
//        ((TextView) findViewById(R.id.txtToolbar)).setText(getString(R.string.mainCard7));
        String qrCode = Preferences.with(this).appVariableInfo().qrCode();
        QRGEncoder qrgEncoder = new QRGEncoder(qrCode, null, QRGContents.Type.TEXT, 300);
        try {
            Bitmap bitmap = qrgEncoder.encodeAsBitmap();
            ImageView img = findViewById(R.id.qrcodeClass7);
            img.setImageBitmap(bitmap);
        } catch (WriterException e) {
            String base64Image = qrCode.split(",")[1];
            byte[] decodedString = Base64.decode(base64Image, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            ImageView img = findViewById(R.id.qrcodeClass7);
            img.setImageBitmap(decodedByte);
        }
    }

    private void initSize() {
        FrameLayout frameBack = findViewById(R.id.frameBack);
        FrameLayout frameFront = findViewById(R.id.frameFront);
        int screenWidth = BaseRecyclerAdapter.getScreenWidth();
        ViewGroup.LayoutParams layoutParams = frameBack.getLayoutParams();
        layoutParams.height = (int) (screenWidth * .65);
        layoutParams.width = (int) (1.6*screenWidth * .65);
        frameBack.setLayoutParams(layoutParams);
        frameFront.setLayoutParams(layoutParams);

    }

    private void sefont() {
        ((TextView) findViewById(R.id.txtStore)).setTypeface(FontManager.T1_BOLD_Typeface(this));
        ((TextView) findViewById(R.id.textCardBack)).setTypeface(FontManager.T1_Typeface(this));
        ((TextView) findViewById(R.id.txt2)).setTypeface(FontManager.T1_Typeface(this));
        ((TextView) findViewById(R.id.textName)).setTypeface(FontManager.T1_Typeface(this));
        ((TextView) findViewById(R.id.txt2)).setTypeface(FontManager.T1_Typeface(this));
        ((TextView) findViewById(R.id.txtTitle)).setTypeface(FontManager.GetTypeface(this, "fonts/number7.otf"));
    }


}
