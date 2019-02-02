package com.src_resources.picturetoasciiconverter

import java.io.File
import java.io.InputStream
import java.io.OutputStream
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

fun copyFile(targetFile: File, targetDir: File) {
    if (!targetFile.exists())
        throw IllegalArgumentException("The argument targetFile does not exist.")
    if (!targetDir.exists())
        throw IllegalArgumentException("The argument targetDir does not exist.")
    if (!targetFile.isFile)
        throw IllegalArgumentException("The argument targetFile does not mean a file.")
    if (!targetDir.isDirectory)
        throw IllegalArgumentException("The argument targetDir does not mean a directory.")
}

fun copyFile(targetFile: File, targetDir: String) {
    copyFile(targetFile, File(targetDir))
}

fun copyFromInputStreamToOutputStream(targetInputStream: InputStream, targetOutputStream: OutputStream) {
    // 获取到 InputStream 可以读取的字节数。
    val size = targetInputStream.available()
    // 创建一个字节数组用于保存读到的字节。
    val buffer = ByteArray(size)
    // 从 InputStream 读字节。
    targetInputStream.read(buffer)
    // 关闭 InputStream 。
    targetInputStream.close()
    // 将读到的字节写入 OutputStream 。
    targetOutputStream.write(buffer)
    // 关闭 OutputStream 。
    targetOutputStream.close()
}

fun copyFromInputStreamToFile(targetInputStream: InputStream, targetFile: File) {
    if (!targetFile.exists())
        throw IllegalArgumentException("The argument targetFile does not exist.")
    if (!targetFile.isFile)
        throw IllegalArgumentException("The argument targetFile does not mean a file.")

    copyFromInputStreamToOutputStream(targetInputStream, targetFile.outputStream())
}

fun copyFromInputStreamToFile(targetInputStream: InputStream, targetFile: String) {
    copyFromInputStreamToFile(targetInputStream, File(targetFile))
}
