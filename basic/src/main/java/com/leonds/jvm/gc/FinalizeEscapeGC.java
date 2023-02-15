package com.leonds.jvm.gc;

/**
 * 对象可以在GC时自我拯救
 * 这种自救的机会只有一次，因为一个对象的finalize方法最多只会被系统自动调用一次
 * 最好是不使用finalize方法，后续jdk版本会作废掉该方法
 *
 * @author Leon
 */
public class FinalizeEscapeGC {
    private static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, i am still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");

        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        // 对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();

        // 因为Finalizer方法优先级较低，暂停一段时间，等待它执行
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no, i am dead");
        }

        // 相同的逻辑，第二次执行就会失败，因为finalize方法只会被系统调用一次
        SAVE_HOOK = null;
        System.gc();

        // 因为Finalizer方法优先级较低，暂停一段时间，等待它执行
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no, i am dead");
        }


    }
}
