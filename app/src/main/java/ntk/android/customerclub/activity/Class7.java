package ntk.android.customerclub.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;
import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import es.dmoral.toasty.Toasty;
import io.reactivex.annotations.NonNull;
import ntk.android.base.activity.BaseActivity;
import ntk.android.base.config.NtkObserver;
import ntk.android.base.config.ServiceExecute;
import ntk.android.base.entitymodel.base.ErrorException;
import ntk.android.base.entitymodel.base.FilterDataModel;
import ntk.android.base.utill.prefrense.Preferences;
import ntk.android.customerclub.R;
import ntk.android.customerclub.adapter.AccountSelectAdapter;
import ntk.android.customerclub.server.model.AccountModel;
import ntk.android.customerclub.server.service.AccountService;

public class Class7 extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class7);
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


}
