package mytest;

import java.lang.reflect.*;

interface doit {
	int cando();
}

class testbase implements doit{
	public final int cando(){ return 1;}
}
class testder extends testbase{
	public static void main(String[] args){
		doit ne = new testder();
		System.out.println(ne.cando());
	}
}

class base {
	protected int i = 10;
}

class myRef extends base implements doit {
	private long test;
	public int[] num;
	public final String str;

	public myRef() {
		test = 0L;
		num = null;
		str = null;
	}

	public myRef(int[] a, String b, long t) {
		test = t;
		num = a;
		str = b;
	}

	public int[] getNum() {
		return num;
	}

	public long getTest() {
		return test;
	}

	public int cando() {
		return 1;
	}

	public class test {// 0

	}

	public abstract class testb {// 2

	}

	public interface testa {// 1

	}
}

public class test_Reflect {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static void main(String[] args) throws ClassNotFoundException,
			NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException {
		// TODO Auto-generated method stub
		Class myRefc = Class.forName("mytest.myRef");
		int[] a = new int[] { 1, 2, 3, 4 };
		Field num = myRefc.getField("num");
		Class arr = num.getType();
		System.out.println(arr.getComponentType().getSimpleName());
		System.out.println(arr.isArray());
		myRef test = new myRef(a, "test", 1923L);
		System.out.println(myRefc.getName() + " " + myRefc.getSimpleName()
				+ " " + myRefc.getCanonicalName());
		if (num.getType().isArray()) {
			Object n = num.get(test);
			int length = Array.getLength(n);
			for (int i = 0; i < length; i++) {
				System.out.println(Array.getInt(n, i));
				Array.setInt(n, i, i + 2);

			}
		}
		System.out.println(java.util.Arrays.toString(test.getNum()));
		Field str = myRefc.getField("str");
		System.out.println(Modifier.toString(str.getModifiers()));
		Class[] all = myRefc.getClasses();
		System.out.println(all[0].getName() + " " + all[1].getName() + " "
				+ all[2].getName());
		Field ltest = myRefc.getDeclaredField("test");
		ltest.setAccessible(true);
		ltest.setLong(test, 6666L);
		System.out.println(test.getTest());
	}

}

class BridgeMethodOne {  
    public static class BMOne<T> {  
        public T getT() {  
            return null;  
        }  
    }  
  
    public static class BMTwo extends BMOne<String> {  
        public String getT() {  
            return null;  
        }  
    }  
    static void checkSynthetic(String name) {
    	try {
    		Class<?> c = Class.forName(name);
    		Method[] get=c.getMethods();
    		System.out.println(name + " " + c.isSynthetic() + " ");
    		for(int i=0;i<get.length;i++){
    		System.out.println(name + " " + get[i].isSynthetic() + " " + get[i].getReturnType().getName()+" "+get[i].getName());
    		}
    	} catch (Exception exc) {
    		exc.printStackTrace(System.out);
    	}
    }
    public static void main(String[] args) throws Exception{
    	checkSynthetic("mytest.BridgeMethodOne$BMOne");
    	checkSynthetic("mytest.BridgeMethodOne$BMTwo");
    }
}  


