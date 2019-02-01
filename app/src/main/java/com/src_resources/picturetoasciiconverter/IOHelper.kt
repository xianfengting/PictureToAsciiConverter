package com.src_resources.picturetoasciiconverter

import java.io.InputStream
import java.nio.charset.Charset

fun readWholeStringFromInputStream(inputStream: InputStream,
                                   encoding: Charset = Charset.forName("utf-8")): String {
    // 获取到 InputStream 可以读取的字节数。
    val size = inputStream.available()
    // 创建一个字节数组用于保存读到的字节。
    val buffer = ByteArray(size)
    // 从 InputStream 读字节。
    inputStream.read(buffer)
    // 关闭 InputStream 。
    inputStream.close()
    // 将读到的字节转换为字符串。
    val str = String(buffer, encoding)
    // 返回该字符串。
    return str
}
