package dd_03_02_���Ӻͼ���ϰ��;

public class Test1 {

	public static void main(String[] args) {
		System.out.println("���Ӻͼ�һ����48ֻ");
		System.out.println("��108ֻ��");
		System.out.println("���Ӻͼ����ж���ֻ");

		/**
		 *  i  j
		 *  0  48   xxx
		 *  1  47   xxx
		 *  ...
		 *  48 0    xxx  
		 * */
		for(int i=0,j=48; i<=48; i++,j--){
			int n = i*4 + j*2;
			if(n == 108){
				System.out.println("����:"+i+   "��:"+ j);
			}
		}
	}
}
