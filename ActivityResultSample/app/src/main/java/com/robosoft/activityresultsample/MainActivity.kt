package com.robosoft.activityresultsample

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageButton
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private var imagePicker: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imagePicker = findViewById(R.id.image_picker)

        val camera = findViewById<ImageView>(R.id.camera_iv)
        val gallery = findViewById<ImageView>(R.id.gallery_iv)

        camera.setOnClickListener{
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 1)
        }
        gallery.setOnClickListener{
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 2)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK){
            var capture: Bitmap = data?.extras?.get("data") as Bitmap
            imagePicker?.setImageBitmap(capture)
        }
        else if  (requestCode == 2 && resultCode == RESULT_OK){
            imagePicker?.setImageURI(data?.data)
        }
    }

}