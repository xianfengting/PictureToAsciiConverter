package com.src_resources.picturetoasciiconverter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AppMainActivity : AppCompatActivity() {

    private lateinit var convertButton: Button
    private lateinit var convertingPictureEditText: EditText
    private lateinit var savingPictureEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_main)

        convertButton = findViewById(R.id.convertButton)
        convertButton.setOnClickListener {
            executePythonForConvertingPicture(convertingPictureEditText.text.toString(),
                    savingPictureEditText.text.toString())
        }

        convertingPictureEditText = findViewById(R.id.convertingPictureEditText)
        savingPictureEditText = findViewById(R.id.savingPictureEditText)
    }

    private fun executePythonForConvertingPicture(convertingPicturePath: String, savingPictureEditText: String) {
        // 获取到 picture-to-ascii.py 文件的 InputStream 。
        val pythonFileInputStream = assets.open("picture-to-ascii.py")
        // 读取 picture-to-ascii.py 中的内容。
        val pythonFileText = readWholeStringFromInputStream(pythonFileInputStream)
        // TODO ：执行该 python 代码。
    }
}
