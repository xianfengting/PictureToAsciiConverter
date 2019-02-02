package com.src_resources.picturetoasciiconverter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListAdapter
import android.widget.ListView
import java.io.File

class AppMainActivity : AppCompatActivity() {

    private lateinit var convertButton: Button
    private lateinit var convertingPictureEditText: EditText
    private lateinit var savingPictureEditText: EditText
    private lateinit var logListView: ListView

    private lateinit var mLogMutableStringListAdapter: ListAdapter
    private val mLogStringList = ArrayList<String>()

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

        logListView = findViewById(R.id.logListView)
        // Only for debugging
        if (BuildConfig.DEBUG) mLogStringList.add("Test Log 1")
        mLogMutableStringListAdapter = MutableStringListAdapter(this, mLogStringList)
        logListView.adapter = mLogMutableStringListAdapter
        // Only for debugging
        if (BuildConfig.DEBUG) mLogStringList.add("Test Log 2")
    }

    private fun executePythonForConvertingPicture(convertingPicturePath: String, savingPictureEditText: String) {
        // 获取到 picture-to-ascii.py 文件的 InputStream 。
        mLogStringList.add("正在准备从应用程序中加载 Python 脚本到缓存目录...")
        val pythonFileInputStream = assets.open("picture-to-ascii.py")
        // 读取 picture-to-ascii.py 中的内容。
//        val pythonFileText = readWholeStringFromInputStream(pythonFileInputStream)
        // 创建一个 File 对象，表示要复制到的 picture-to-ascii.py 的路径。
        val pythonFileCacheFileObj = File(cacheDir, "picture-to-ascii.py")
        // 如果文件不存在，创建文件。
        if (!pythonFileCacheFileObj.exists()) pythonFileCacheFileObj.createNewFile()
        // 复制文件。
        mLogStringList.add("正在从应用程序中加载 Python 脚本到缓存目录...")
        copyFromInputStreamToFile(pythonFileInputStream, pythonFileCacheFileObj)
        // TODO ：执行该 python 代码。
    }
}
