package com.example.ecngv2.View.User.SettingAccount.Profile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ecngv2.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

public class UserProfileActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_back;
    ShapeableImageView avatar;
    int REQUEST_CODE = 100;
    BottomSheetDialog dialog_sex, dialog_phone, dialog_email, dialog_pwd;
    ConstraintLayout dialog_sex_male, dialog_sex_female, dialog_sex_other, btn_changesex, btn_changebirth, btn_changephone, btn_changeemail, btn_changepwd;
    TextView dialog_txtmale, dialog_txtfemale, dialog_txtother, dialog_txtselected, txt_sex, txt_birth, txt_phone, txt_email;
    ImageView dialog_checkmale, dialog_checkfemale, dialog_checkother, dialog_checked;
    ImageButton dialog_sex_btn_close, dialog_phone_btn_close, dialog_email_btn_close, dialog_pwd_btn_close;
    TextInputEditText dialog_txtphone, dialog_txtemail, dialog_txtpwd;
    AppCompatButton btn_changeimg, dialog_phone_btn_confirm, dialog_email_btn_confirm, dialog_pwd_btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Window window = getWindow();
        @SuppressLint("UseCompatLoadingForDrawables") Drawable background = getDrawable(R.drawable.appbar_background);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(android.R.color.transparent));
//        window.setNavigationBarColor(getColor(android.R.color.transparent));
        window.setBackgroundDrawable(background);

        Locale locale = getResources().getConfiguration().locale;
        Locale.setDefault(locale);

        dialog_sex = new BottomSheetDialog(this);
        dialog_sex.setContentView(R.layout.dialog_choose_sex);

        dialog_phone = new BottomSheetDialog(this);
        dialog_phone.setContentView(R.layout.dialog_change_phone);

        dialog_email = new BottomSheetDialog(this);
        dialog_email.setContentView(R.layout.dialog_change_email);

        dialog_pwd = new BottomSheetDialog(this);
        dialog_pwd.setContentView(R.layout.dialog_change_pwd);

        init();

        btn_back.setOnClickListener(this);
        btn_changeimg.setOnClickListener(this);

        btn_changesex.setOnClickListener(this);
        dialog_sex_male.setOnClickListener(this);
        dialog_sex_female.setOnClickListener(this);
        dialog_sex_other.setOnClickListener(this);

        btn_changebirth.setOnClickListener(this);

        btn_changephone.setOnClickListener(this);
        dialog_phone_btn_close.setOnClickListener(this);
        dialog_phone_btn_confirm.setOnClickListener(this);

        btn_changeemail.setOnClickListener(this);
        dialog_email_btn_close.setOnClickListener(this);
        dialog_email_btn_confirm.setOnClickListener(this);

        btn_changepwd.setOnClickListener(this);
        dialog_pwd_btn_close.setOnClickListener(this);
        dialog_pwd_btn_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_profile_btn_back:
                finish();
                break;
            case R.id.user_profile_btn_changeimg:
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, REQUEST_CODE);
                break;

            case R.id.user_profile_block_sex:
                    dialog_sex.show();
                break;
            case R.id.dialog_sex_btn_close:
                dialog_sex.hide();
                break;
            case R.id.dialog_changesex_block_male:
                sexCheck(dialog_txtmale, dialog_checkmale, dialog_txtselected, dialog_checked);
                dialog_txtselected = dialog_txtmale;
                dialog_checked = dialog_checkmale;
                dialog_sex.hide();
                break;
            case R.id.dialog_changesex_block_female:
                sexCheck(dialog_txtfemale, dialog_checkfemale, dialog_txtselected, dialog_checked);
                dialog_txtselected = dialog_txtfemale;
                dialog_checked = dialog_checkfemale;
                dialog_sex.hide();
                break;
            case R.id.dialog_changesex_block_other:
                sexCheck(dialog_txtother, dialog_checkother, dialog_txtselected, dialog_checked);
                dialog_txtselected = dialog_txtother;
                dialog_checked = dialog_checkother;
                dialog_sex.hide();
                break;

            case R.id.user_profile_block_birth:
                Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        txt_birth.setText(datePicker.getDayOfMonth() + "/" + datePicker.getMonth() + "/" + datePicker.getYear());
                    }
                }, mYear, mMonth,mDay );
                dialog.getDatePicker().setMaxDate(c.getTimeInMillis());
                dialog.setTitle("Ngày sinh");
                dialog.show();
                break;

            case R.id.user_profile_block_phone:
                dialog_phone.show();
                break;
            case R.id.dialog_phone_btn_close:
                dialog_phone.hide();
                break;
            case R.id.dialog_phone_btn_confirm:
                txt_phone.setText(dialog_txtphone.getText().toString());
                dialog_phone.hide();
                break;

            case R.id.user_profile_block_email:
                dialog_email.show();
                break;
            case R.id.dialog_email_btn_close:
                dialog_email.hide();
                break;
            case R.id.dialog_email_btn_confirm:
                txt_email.setText(dialog_txtemail.getText().toString());
                dialog_email.hide();
                break;

            case R.id.user_profile_block_changepwd:
                dialog_pwd.show();
                break;
            case R.id.dialog_pwd_btn_close:
                dialog_pwd.hide();
                break;
            case R.id.dialog_pwd_btn_next:
                startActivity(new Intent(UserProfileActivity.this, ChangePasswordActivity.class));
                dialog_pwd.hide();
                break;
        }
    }

    private void init() {
        btn_back = findViewById(R.id.user_profile_btn_back);
        avatar = findViewById(R.id.user_profile_avatar);
        btn_changeimg = findViewById(R.id.user_profile_btn_changeimg);

        btn_changesex = findViewById(R.id.user_profile_block_sex);
        txt_sex = findViewById(R.id.user_profile_txtsex);
        dialog_sex_btn_close = dialog_sex.findViewById(R.id.dialog_sex_btn_close);
        dialog_sex_male = dialog_sex.findViewById(R.id.dialog_changesex_block_male);
        dialog_sex_female = dialog_sex.findViewById(R.id.dialog_changesex_block_female);
        dialog_sex_other = dialog_sex.findViewById(R.id.dialog_changesex_block_other);
        dialog_txtmale = dialog_sex.findViewById(R.id.dialog_changesex_male);
        dialog_txtfemale = dialog_sex.findViewById(R.id.dialog_changesex_female);
        dialog_txtother = dialog_sex.findViewById(R.id.dialog_changesex_other);
        dialog_txtselected = dialog_txtmale;
        dialog_checkmale = dialog_sex.findViewById(R.id.dialog_changesex_ckeckmale);
        dialog_checkfemale = dialog_sex.findViewById(R.id.dialog_changesex_ckeckfemale);
        dialog_checkother = dialog_sex.findViewById(R.id.dialog_changesex_ckeckother);
        dialog_checked = dialog_checkmale;

        btn_changebirth = findViewById(R.id.user_profile_block_birth);
        txt_birth = findViewById(R.id.user_profile_txtbirth);

        btn_changephone = findViewById(R.id.user_profile_block_phone);
        txt_phone = findViewById(R.id.user_profile_txtphone);
        dialog_txtphone = dialog_phone.findViewById(R.id.dialog_phone_txtphone);
        dialog_phone_btn_close = dialog_phone.findViewById(R.id.dialog_phone_btn_close);
        dialog_phone_btn_confirm = dialog_phone.findViewById(R.id.dialog_phone_btn_confirm);

        btn_changeemail = findViewById(R.id.user_profile_block_email);
        txt_email = findViewById(R.id.user_profile_txtemail);
        dialog_txtemail = dialog_email.findViewById(R.id.dialog_email_txtemail);
        dialog_email_btn_close = dialog_email.findViewById(R.id.dialog_email_btn_close);
        dialog_email_btn_confirm = dialog_email.findViewById(R.id.dialog_email_btn_confirm);

        btn_changepwd = findViewById(R.id.user_profile_block_changepwd);
        dialog_txtpwd = dialog_pwd.findViewById(R.id.dialog_pwd_txtpwd);
        dialog_pwd_btn_close = dialog_pwd.findViewById(R.id.dialog_pwd_btn_close);
        dialog_pwd_btn_next = dialog_pwd.findViewById(R.id.dialog_pwd_btn_next);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CODE) {
                Uri selectedImage = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                    avatar.setImageBitmap(bitmap);
                } catch (IOException e) {
                    Log.i("TAG", "Some exception " + e);
                }
            }
        }
    }

    private void sexCheck(TextView txt, ImageView img, TextView txt1, ImageView img1){
        txt1.setTextColor(getColor(R.color.black));
        img1.setVisibility(View.GONE);
        txt.setTextColor(getColor(R.color.primary_color));
        img.setVisibility(View.VISIBLE);
        txt_sex.setText(txt.getText().toString());
    }
}