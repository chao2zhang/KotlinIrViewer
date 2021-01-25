package io.github.chao2zhang

import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment
import org.jetbrains.kotlin.ir.util.DumpIrTreeVisitor

class KivIrGenerationExtension(private val output: Appendable) : IrGenerationExtension {

    override fun generate(moduleFragment: IrModuleFragment, pluginContext: IrPluginContext) {
        moduleFragment.files.forEach {
            it.accept(DumpIrTreeVisitor(output, false), "")
        }
    }
}