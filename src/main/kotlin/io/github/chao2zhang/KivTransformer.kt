package io.github.chao2zhang

import org.jetbrains.kotlin.backend.common.IrElementTransformerVoidWithContext
import org.jetbrains.kotlin.backend.common.ScopeWithIr
import org.jetbrains.kotlin.ir.IrElement
import org.jetbrains.kotlin.ir.IrStatement
import org.jetbrains.kotlin.ir.declarations.IrAnonymousInitializer
import org.jetbrains.kotlin.ir.declarations.IrClass
import org.jetbrains.kotlin.ir.declarations.IrConstructor
import org.jetbrains.kotlin.ir.declarations.IrDeclarationBase
import org.jetbrains.kotlin.ir.declarations.IrEnumEntry
import org.jetbrains.kotlin.ir.declarations.IrErrorDeclaration
import org.jetbrains.kotlin.ir.declarations.IrExternalPackageFragment
import org.jetbrains.kotlin.ir.declarations.IrField
import org.jetbrains.kotlin.ir.declarations.IrFile
import org.jetbrains.kotlin.ir.declarations.IrFunction
import org.jetbrains.kotlin.ir.declarations.IrLocalDelegatedProperty
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment
import org.jetbrains.kotlin.ir.declarations.IrPackageFragment
import org.jetbrains.kotlin.ir.declarations.IrProperty
import org.jetbrains.kotlin.ir.declarations.IrScript
import org.jetbrains.kotlin.ir.declarations.IrSimpleFunction
import org.jetbrains.kotlin.ir.declarations.IrSymbolOwner
import org.jetbrains.kotlin.ir.declarations.IrTypeAlias
import org.jetbrains.kotlin.ir.declarations.IrTypeParameter
import org.jetbrains.kotlin.ir.declarations.IrValueParameter
import org.jetbrains.kotlin.ir.declarations.IrVariable
import org.jetbrains.kotlin.ir.expressions.IrBlock
import org.jetbrains.kotlin.ir.expressions.IrBlockBody
import org.jetbrains.kotlin.ir.expressions.IrBody
import org.jetbrains.kotlin.ir.expressions.IrBranch
import org.jetbrains.kotlin.ir.expressions.IrBreak
import org.jetbrains.kotlin.ir.expressions.IrBreakContinue
import org.jetbrains.kotlin.ir.expressions.IrCall
import org.jetbrains.kotlin.ir.expressions.IrCallableReference
import org.jetbrains.kotlin.ir.expressions.IrCatch
import org.jetbrains.kotlin.ir.expressions.IrClassReference
import org.jetbrains.kotlin.ir.expressions.IrComposite
import org.jetbrains.kotlin.ir.expressions.IrConst
import org.jetbrains.kotlin.ir.expressions.IrConstructorCall
import org.jetbrains.kotlin.ir.expressions.IrContainerExpression
import org.jetbrains.kotlin.ir.expressions.IrContinue
import org.jetbrains.kotlin.ir.expressions.IrDeclarationReference
import org.jetbrains.kotlin.ir.expressions.IrDelegatingConstructorCall
import org.jetbrains.kotlin.ir.expressions.IrDoWhileLoop
import org.jetbrains.kotlin.ir.expressions.IrDynamicExpression
import org.jetbrains.kotlin.ir.expressions.IrDynamicMemberExpression
import org.jetbrains.kotlin.ir.expressions.IrDynamicOperatorExpression
import org.jetbrains.kotlin.ir.expressions.IrElseBranch
import org.jetbrains.kotlin.ir.expressions.IrEnumConstructorCall
import org.jetbrains.kotlin.ir.expressions.IrErrorCallExpression
import org.jetbrains.kotlin.ir.expressions.IrErrorExpression
import org.jetbrains.kotlin.ir.expressions.IrExpression
import org.jetbrains.kotlin.ir.expressions.IrExpressionBody
import org.jetbrains.kotlin.ir.expressions.IrFieldAccessExpression
import org.jetbrains.kotlin.ir.expressions.IrFunctionAccessExpression
import org.jetbrains.kotlin.ir.expressions.IrFunctionExpression
import org.jetbrains.kotlin.ir.expressions.IrFunctionReference
import org.jetbrains.kotlin.ir.expressions.IrGetClass
import org.jetbrains.kotlin.ir.expressions.IrGetEnumValue
import org.jetbrains.kotlin.ir.expressions.IrGetField
import org.jetbrains.kotlin.ir.expressions.IrGetObjectValue
import org.jetbrains.kotlin.ir.expressions.IrGetSingletonValue
import org.jetbrains.kotlin.ir.expressions.IrGetValue
import org.jetbrains.kotlin.ir.expressions.IrInstanceInitializerCall
import org.jetbrains.kotlin.ir.expressions.IrLocalDelegatedPropertyReference
import org.jetbrains.kotlin.ir.expressions.IrLoop
import org.jetbrains.kotlin.ir.expressions.IrMemberAccessExpression
import org.jetbrains.kotlin.ir.expressions.IrPropertyReference
import org.jetbrains.kotlin.ir.expressions.IrRawFunctionReference
import org.jetbrains.kotlin.ir.expressions.IrReturn
import org.jetbrains.kotlin.ir.expressions.IrSetField
import org.jetbrains.kotlin.ir.expressions.IrSetValue
import org.jetbrains.kotlin.ir.expressions.IrSpreadElement
import org.jetbrains.kotlin.ir.expressions.IrStringConcatenation
import org.jetbrains.kotlin.ir.expressions.IrSuspendableExpression
import org.jetbrains.kotlin.ir.expressions.IrSuspensionPoint
import org.jetbrains.kotlin.ir.expressions.IrSyntheticBody
import org.jetbrains.kotlin.ir.expressions.IrThrow
import org.jetbrains.kotlin.ir.expressions.IrTry
import org.jetbrains.kotlin.ir.expressions.IrTypeOperatorCall
import org.jetbrains.kotlin.ir.expressions.IrValueAccessExpression
import org.jetbrains.kotlin.ir.expressions.IrVararg
import org.jetbrains.kotlin.ir.expressions.IrWhen
import org.jetbrains.kotlin.ir.expressions.IrWhileLoop

class KivTransformer : IrElementTransformerVoidWithContext() {
    override fun createScope(declaration: IrSymbolOwner): ScopeWithIr {
        return super.createScope(declaration)
    }

    override fun visitAnonymousInitializerNew(declaration: IrAnonymousInitializer): IrStatement {
        return super.visitAnonymousInitializerNew(declaration)
    }

    override fun visitBlock(expression: IrBlock): IrExpression {
        return super.visitBlock(expression)
    }

    override fun visitBlockBody(body: IrBlockBody): IrBody {
        return super.visitBlockBody(body)
    }

    override fun visitBody(body: IrBody): IrBody {
        return super.visitBody(body)
    }

    override fun visitBranch(branch: IrBranch): IrBranch {
        return super.visitBranch(branch)
    }

    override fun visitBreak(jump: IrBreak): IrExpression {
        return super.visitBreak(jump)
    }

    override fun visitBreakContinue(jump: IrBreakContinue): IrExpression {
        return super.visitBreakContinue(jump)
    }

    override fun visitCall(expression: IrCall): IrExpression {
        return super.visitCall(expression)
    }

    override fun visitCallableReference(expression: IrCallableReference<*>): IrExpression {
        return super.visitCallableReference(expression)
    }

    override fun visitCatch(aCatch: IrCatch): IrCatch {
        return super.visitCatch(aCatch)
    }

    override fun visitClassNew(declaration: IrClass): IrStatement {
        return super.visitClassNew(declaration)
    }

    override fun visitClassReference(expression: IrClassReference): IrExpression {
        return super.visitClassReference(expression)
    }

    override fun visitComposite(expression: IrComposite): IrExpression {
        return super.visitComposite(expression)
    }

    override fun <T> visitConst(expression: IrConst<T>): IrExpression {
        return super.visitConst(expression)
    }

    override fun visitConstructor(declaration: IrConstructor): IrStatement {
        return super.visitConstructor(declaration)
    }

    override fun visitConstructorCall(expression: IrConstructorCall): IrExpression {
        return super.visitConstructorCall(expression)
    }

    override fun visitContainerExpression(expression: IrContainerExpression): IrExpression {
        return super.visitContainerExpression(expression)
    }

    override fun visitContinue(jump: IrContinue): IrExpression {
        return super.visitContinue(jump)
    }

    override fun visitDeclaration(declaration: IrDeclarationBase): IrStatement {
        return super.visitDeclaration(declaration)
    }

    override fun visitDeclarationReference(expression: IrDeclarationReference): IrExpression {
        return super.visitDeclarationReference(expression)
    }

    override fun visitDelegatingConstructorCall(expression: IrDelegatingConstructorCall): IrExpression {
        return super.visitDelegatingConstructorCall(expression)
    }

    override fun visitDoWhileLoop(loop: IrDoWhileLoop): IrExpression {
        return super.visitDoWhileLoop(loop)
    }

    override fun visitDynamicExpression(expression: IrDynamicExpression): IrExpression {
        return super.visitDynamicExpression(expression)
    }

    override fun visitDynamicMemberExpression(expression: IrDynamicMemberExpression): IrExpression {
        return super.visitDynamicMemberExpression(expression)
    }

    override fun visitDynamicOperatorExpression(expression: IrDynamicOperatorExpression): IrExpression {
        return super.visitDynamicOperatorExpression(expression)
    }

    override fun visitElement(element: IrElement): IrElement {
        return super.visitElement(element)
    }

    override fun visitElseBranch(branch: IrElseBranch): IrElseBranch {
        return super.visitElseBranch(branch)
    }

    override fun visitEnumConstructorCall(expression: IrEnumConstructorCall): IrExpression {
        return super.visitEnumConstructorCall(expression)
    }

    override fun visitEnumEntry(declaration: IrEnumEntry): IrStatement {
        return super.visitEnumEntry(declaration)
    }

    override fun visitErrorCallExpression(expression: IrErrorCallExpression): IrExpression {
        return super.visitErrorCallExpression(expression)
    }

    override fun visitErrorDeclaration(declaration: IrErrorDeclaration): IrStatement {
        return super.visitErrorDeclaration(declaration)
    }

    override fun visitErrorExpression(expression: IrErrorExpression): IrExpression {
        return super.visitErrorExpression(expression)
    }

    override fun visitExpression(expression: IrExpression): IrExpression {
        return super.visitExpression(expression)
    }

    override fun visitExpressionBody(body: IrExpressionBody): IrBody {
        return super.visitExpressionBody(body)
    }

    override fun visitExternalPackageFragment(declaration: IrExternalPackageFragment): IrExternalPackageFragment {
        return super.visitExternalPackageFragment(declaration)
    }

    override fun visitFieldAccess(expression: IrFieldAccessExpression): IrExpression {
        return super.visitFieldAccess(expression)
    }

    override fun visitFieldNew(declaration: IrField): IrStatement {
        return super.visitFieldNew(declaration)
    }

    override fun visitFileNew(declaration: IrFile): IrFile {
        return super.visitFileNew(declaration)
    }

    override fun visitFunctionAccess(expression: IrFunctionAccessExpression): IrExpression {
        return super.visitFunctionAccess(expression)
    }

    override fun visitFunctionExpression(expression: IrFunctionExpression): IrExpression {
        return super.visitFunctionExpression(expression)
    }

    override fun visitFunctionNew(declaration: IrFunction): IrStatement {
        return super.visitFunctionNew(declaration)
    }

    override fun visitFunctionReference(expression: IrFunctionReference): IrExpression {
        return super.visitFunctionReference(expression)
    }

    override fun visitGetClass(expression: IrGetClass): IrExpression {
        return super.visitGetClass(expression)
    }

    override fun visitGetEnumValue(expression: IrGetEnumValue): IrExpression {
        return super.visitGetEnumValue(expression)
    }

    override fun visitGetField(expression: IrGetField): IrExpression {
        return super.visitGetField(expression)
    }

    override fun visitGetObjectValue(expression: IrGetObjectValue): IrExpression {
        return super.visitGetObjectValue(expression)
    }

    override fun visitGetValue(expression: IrGetValue): IrExpression {
        return super.visitGetValue(expression)
    }

    override fun visitInstanceInitializerCall(expression: IrInstanceInitializerCall): IrExpression {
        return super.visitInstanceInitializerCall(expression)
    }

    override fun visitLocalDelegatedProperty(declaration: IrLocalDelegatedProperty): IrStatement {
        return super.visitLocalDelegatedProperty(declaration)
    }

    override fun visitLocalDelegatedPropertyReference(expression: IrLocalDelegatedPropertyReference): IrExpression {
        return super.visitLocalDelegatedPropertyReference(expression)
    }

    override fun visitLoop(loop: IrLoop): IrExpression {
        return super.visitLoop(loop)
    }

    override fun visitMemberAccess(expression: IrMemberAccessExpression<*>): IrExpression {
        return super.visitMemberAccess(expression)
    }

    override fun visitModuleFragment(declaration: IrModuleFragment): IrModuleFragment {
        return super.visitModuleFragment(declaration)
    }

    override fun visitPackageFragment(declaration: IrPackageFragment): IrPackageFragment {
        return super.visitPackageFragment(declaration)
    }

    override fun visitPropertyNew(declaration: IrProperty): IrStatement {
        return super.visitPropertyNew(declaration)
    }

    override fun visitPropertyReference(expression: IrPropertyReference): IrExpression {
        return super.visitPropertyReference(expression)
    }

    override fun visitRawFunctionReference(expression: IrRawFunctionReference): IrExpression {
        return super.visitRawFunctionReference(expression)
    }

    override fun visitReturn(expression: IrReturn): IrExpression {
        return super.visitReturn(expression)
    }

    override fun visitScriptNew(declaration: IrScript): IrStatement {
        return super.visitScriptNew(declaration)
    }

    override fun visitSetField(expression: IrSetField): IrExpression {
        return super.visitSetField(expression)
    }

    override fun visitSetValue(expression: IrSetValue): IrExpression {
        return super.visitSetValue(expression)
    }

    override fun visitSimpleFunction(declaration: IrSimpleFunction): IrStatement {
        return super.visitSimpleFunction(declaration)
    }

    override fun visitSingletonReference(expression: IrGetSingletonValue): IrExpression {
        return super.visitSingletonReference(expression)
    }

    override fun visitSpreadElement(spread: IrSpreadElement): IrSpreadElement {
        return super.visitSpreadElement(spread)
    }

    override fun visitStringConcatenation(expression: IrStringConcatenation): IrExpression {
        return super.visitStringConcatenation(expression)
    }

    override fun visitSuspendableExpression(expression: IrSuspendableExpression): IrExpression {
        return super.visitSuspendableExpression(expression)
    }

    override fun visitSuspensionPoint(expression: IrSuspensionPoint): IrExpression {
        return super.visitSuspensionPoint(expression)
    }

    override fun visitSyntheticBody(body: IrSyntheticBody): IrBody {
        return super.visitSyntheticBody(body)
    }

    override fun visitThrow(expression: IrThrow): IrExpression {
        return super.visitThrow(expression)
    }

    override fun visitTry(aTry: IrTry): IrExpression {
        return super.visitTry(aTry)
    }

    override fun visitTypeAlias(declaration: IrTypeAlias): IrStatement {
        return super.visitTypeAlias(declaration)
    }

    override fun visitTypeOperator(expression: IrTypeOperatorCall): IrExpression {
        return super.visitTypeOperator(expression)
    }

    override fun visitTypeParameter(declaration: IrTypeParameter): IrStatement {
        return super.visitTypeParameter(declaration)
    }

    override fun visitValueAccess(expression: IrValueAccessExpression): IrExpression {
        return super.visitValueAccess(expression)
    }

    override fun visitValueParameterNew(declaration: IrValueParameter): IrStatement {
        return super.visitValueParameterNew(declaration)
    }

    override fun visitVararg(expression: IrVararg): IrExpression {
        return super.visitVararg(expression)
    }

    override fun visitVariable(declaration: IrVariable): IrStatement {
        return super.visitVariable(declaration)
    }

    override fun visitWhen(expression: IrWhen): IrExpression {
        return super.visitWhen(expression)
    }

    override fun visitWhileLoop(loop: IrWhileLoop): IrExpression {
        return super.visitWhileLoop(loop)
    }
}