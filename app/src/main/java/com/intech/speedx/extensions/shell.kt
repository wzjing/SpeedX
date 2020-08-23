package com.intech.speedx.extensions

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

private const val TAG = "shell"

public fun String.execute(throwError: Boolean = false): String = this.executeShell(throwError).second

/**
 * @param throwError    if `true`, this method will throw [IllegalStateException] when shell result is not 0
 * @return  the exit code and output of this command
 * @throws  IllegalStateException
 */
public fun String.executeShell(throwError: Boolean = false): Pair<Int, String> = try {
    val process = Runtime.getRuntime().exec(this)
    val reader = BufferedReader(InputStreamReader(process.inputStream))
    process.waitFor()
    process.exitValue()
    process.exitValue() to reader.readText()
} catch (e: IOException) {
    e.printStackTrace()
    -1 to ""
}
