package com.example.retrofituploadfiles;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ImageView mIvGallery;
    private Button mBtnOpenGallery;
    private Button mBtnUploadImage;
    private String imagePath;

    private ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getData() != null) {
                        Uri uri = result.getData().getData();
                        try {
                            InputStream inputStream = getContentResolver().openInputStream(uri);
                            mIvGallery.setImageBitmap(BitmapFactory.decodeStream(inputStream));
                            getImagePathFromUri(uri);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
    );

    @NotNull
    private Cursor getImagePathFromUri(Uri selectedImage) {
        String[] filePath = {MediaStore.Images.Media.DATA};
        Cursor c = getContentResolver().query(selectedImage, filePath,
                null, null, null);
        c.moveToFirst();
        int columnIndex = c.getColumnIndex(filePath[0]);
        imagePath = c.getString(columnIndex);
        return c;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mIvGallery = findViewById(R.id.imageView);
        mBtnOpenGallery = findViewById(R.id.btnSave);
        mBtnUploadImage = findViewById(R.id.btnUpload);
        mBtnOpenGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPermissionGranted()) {
                    openGallery();
                } else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                }
            }
        });
        mBtnUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImageToApi();
            }
        });
    }

    private void uploadImageToApi() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        File file = new File(imagePath);
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part multiBody = MultipartBody.Part.createFormData("image", file.getName(), requestBody);
        apiService.uploadImage(multiBody, "Image").enqueue(new Callback<ResponseDTO>() {
            @Override
            public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
                Toast.makeText(MainActivity.this, "upload Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseDTO> call, Throwable t) {
                Toast.makeText(MainActivity.this, "upload Failure", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        resultLauncher.launch(intent);

    }

    private boolean isPermissionGranted() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGallery();
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}