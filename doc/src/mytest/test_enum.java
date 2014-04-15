package mytest;

enum week{
	mon,tue,wed,thu
}

enum EnumTest {
    MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6) {
        @Override
        public boolean isRest() {
            return true;
        }
    },
    SUN(0) {
        @Override
        public boolean isRest() {
            return true;
        }
    };
 
    private int value;
 
    private EnumTest(int value) {
        this.value = value;
    }
 
    public int getValue() {
        return value;
    }
 
    public boolean isRest() {
        return false;
    }

}
public class test_enum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		week day=week.mon;
		week mon=week.mon;
		System.out.println(day.name()+" "+day.ordinal()+" "+day.toString());
		switch(day){
		case mon: 		System.out.println("mon"); break;
		case tue:		System.out.println("tue"); break;
		}
		EnumTest d = EnumTest.MON;
		System.out.println(d.name()+" "+d.ordinal()+" "+d.toString());
		StringBuffer sb=new StringBuffer(10);
		sb.append("testtesttesttest");
		System.out.println(sb);
		sb.append(100);
		System.out.println(sb);
		sb.insert(4, 123);
		System.out.println(sb);
		sb.delete(4, 6);
		System.out.println(sb);
		sb.setCharAt(4, '!');
		System.out.println(sb);

	}
}

