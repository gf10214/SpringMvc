package com.wangshuo.springMybatis;

/**
 * Created by Administrator on 2016/4/20 0020.
 */
public class TestException {

        public TestException() {
        }

        boolean testEx() throws Exception {
            boolean ret = true;
            try {
                ret = testEx1();
            } catch (Exception e) {
                System.out.println("testEx, catch exception");
                ret = false;
                throw e;
            } finally {
                System.out.println("testEx, finally; return value=" + ret);
                return ret;
            }
        }

        boolean testEx1() throws Exception {
            boolean ret = true;
            try {
                ret = testEx2();
                if (!ret) {
                    return false;
                }
                System.out.println("testEx1, at the end of try");
                return ret;
            } catch (Exception e) {
                System.out.println("testEx1, catch exception");
                ret = false;
                throw e;
            } finally {
                System.out.println("testEx1, finally; return value=" + ret);
                return ret;
            }
        }

        boolean testEx2() throws Exception {
            boolean ret = true;
            try {
                int b = 12;
                int c;
                for (int i = 2; i >= -2; i--) {
                    c = b / i;
                    System.out.println("i=" + i);
                }
                return true;
            } catch (Exception e) {
                System.out.println("testEx2, catch exception");
                ret = false;
                throw e;
            } finally {
                System.out.println("testEx2, finally; return value=" + ret);
                return ret;
            }
        }
        public static int hhh()throws Exception{
            int a, b;
            a = 6;
            b = 0; // 除数b 的值为0
            System.out.println(a / b);
            return 1;
        }
        public static void main(String[] args) throws Exception {
//            TestException testException1 = new TestException();
//            try {
//                testException1.testEx();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            try{
//                int a, b;
//                a = 6;
//                b = 0; // 除数b 的值为0
//                System.out.println(a / b);
//            }catch (Exception e){
//                System.out.println("catch");
//            }finally {
//                System.out.println("finally");
//            }
            int a=hhh();
        }
}
