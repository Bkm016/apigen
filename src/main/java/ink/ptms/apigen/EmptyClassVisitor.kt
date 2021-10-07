package ink.ptms.apigen

import org.objectweb.asm.*

/**
 * jar-minimize
 * ink.ptms.jar_minimize.EmptyClassVisitor
 *
 * @author sky
 * @since 2021/10/7 3:17 下午
 */
class EmptyClassVisitor(visitor: ClassVisitor) : ClassVisitor(Opcodes.ASM7, visitor) {

    override fun visitMethod(access: Int, name: String?, descriptor: String?, signature: String?, exceptions: Array<out String>?): MethodVisitor {
        return EmptyMethodVisitor(super.visitMethod(access, name, descriptor, signature, exceptions))
    }

    class EmptyMethodVisitor(visitor: MethodVisitor): MethodVisitor(Opcodes.ASM7, visitor) {

        override fun visitIincInsn(`var`: Int, increment: Int) {
        }

        override fun visitInsn(opcode: Int) {
        }

        override fun visitIntInsn(opcode: Int, operand: Int) {
        }

        override fun visitVarInsn(opcode: Int, `var`: Int) {
        }

        override fun visitTypeInsn(opcode: Int, type: String?) {
        }

        override fun visitJumpInsn(opcode: Int, label: Label?) {
        }

        override fun visitLabel(label: Label?) {
        }

        override fun visitLdcInsn(value: Any?) {
        }

        override fun visitTableSwitchInsn(min: Int, max: Int, dflt: Label?, vararg labels: Label?) {
        }

        override fun visitLookupSwitchInsn(dflt: Label?, keys: IntArray?, labels: Array<out Label>?) {
        }

        override fun visitMultiANewArrayInsn(descriptor: String?, numDimensions: Int) {
        }

        override fun visitTryCatchBlock(start: Label?, end: Label?, handler: Label?, type: String?) {
        }

        override fun visitLocalVariable(name: String?, descriptor: String?, signature: String?, start: Label?, end: Label?, index: Int) {
        }

        override fun visitLineNumber(line: Int, start: Label?) {
        }

        override fun visitFrame(type: Int, numLocal: Int, local: Array<out Any>?, numStack: Int, stack: Array<out Any>?) {
        }

        override fun visitFieldInsn(opcode: Int, owner: String?, name: String?, descriptor: String?) {
        }

        override fun visitMethodInsn(opcode: Int, owner: String?, name: String?, descriptor: String?) {
        }

        override fun visitMethodInsn(opcode: Int, owner: String?, name: String?, descriptor: String?, isInterface: Boolean) {
        }

        override fun visitInvokeDynamicInsn(name: String?, descriptor: String?, bootstrapMethodHandle: Handle?, vararg bootstrapMethodArguments: Any?) {
        }
    }
}