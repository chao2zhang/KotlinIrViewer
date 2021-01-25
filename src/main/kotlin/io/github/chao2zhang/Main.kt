package io.github.chao2zhang

import com.tschuchort.compiletesting.KotlinCompilation
import com.tschuchort.compiletesting.SourceFile
import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.required
import java.io.File
import java.io.OutputStream
import kotlin.system.exitProcess

fun compile(
    input: String,
    classPaths: List<File>,
    outputStream: OutputStream
): KotlinCompilation.Result {
    return KotlinCompilation().apply {
        sources = listOf(SourceFile.fromPath(File(input)))
        compilerPlugins = listOf(KivComponentRegistrar())
        inheritClassPath = true
        useIR = true
        classpaths = classPaths
        messageOutputStream = outputStream
    }.compile()
}

fun main(args: Array<String>) {

    val parser = ArgParser("example")
    val input by parser.option(ArgType.String,
        fullName = "input",
        shortName ="i",
        description = "Input file"
    ).required()
    val classpath by parser.option(ArgType.String,
        fullName = "classpath",
        shortName ="cp",
        description = "Classpath"
    )
    parser.parse(args)

    val separatedClasspath = classpath
        ?.split(File.pathSeparatorChar)
        ?.map { File(it) }
        ?: emptyList()
    val result = compile(input, separatedClasspath, System.out)
    exitProcess(if (result.exitCode == KotlinCompilation.ExitCode.OK) 0 else 1)
}