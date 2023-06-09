package ink.ptms.apigen

import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import java.io.File
import java.io.FileOutputStream
import java.util.jar.JarEntry
import java.util.jar.JarFile
import java.util.jar.JarOutputStream

object Launcher {

    @JvmStatic
    fun main(args: Array<String>) {
        if (args.isEmpty()) {
            error("empty arguments")
        }
        val file = File(args[0])
        if (!file.exists()) {
            error("file not found")
        }
        val fileOutput = File(file.parent, "${file.nameWithoutExtension}.min.jar")
        JarOutputStream(FileOutputStream(fileOutput)).use { out ->
            JarFile(file).use { jarFile ->
                for (jarEntry in jarFile.entries()) {
                    jarFile.getInputStream(jarEntry).use {
                        try {
                            val path = jarEntry.name
                            if (path.endsWith(".class")) {
                                val reader = ClassReader(it)
                                val writer = ClassWriter(0)
                                val visitor = EmptyClassVisitor(writer)
                                reader.accept(visitor, 0)
                                out.putNextEntry(JarEntry(path))
                                out.write(writer.toByteArray())
                            } else {
                                out.putNextEntry(JarEntry(path))
                                out.write(it.readBytes())
                            }
                        } catch (ex: Throwable) {
                            ex.printStackTrace()
                        }
                    }
                }
            }
        }
    }
}