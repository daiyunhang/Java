package dd_08_04_���ν��;

public class Transformer {
	/**
	 * ���ν��ʹ�������ӿ�
	 * �����ӿڶ���ɱ��ν�յĳ�Ա����
	 * */
	private Weapon w;
	
	public void setWeapon(Weapon w) {
		this.w = w;
	}
	
	public void attack() {
		if(w == null) {
			System.out.println("����ҧ");
			return;
		}
		
		String s = null;
		switch(w.getType()) {
		case Weapon.TYPE_COLD:s = "�����";break;
		case Weapon.TYPE_HOT:s = "�ȱ���";break;
		case Weapon.TYPE_MUCLEAR:s = "������";break;
		}
		System.out.println(w.getType());
		//ʹ�ú���������������
		System.out.println("ʹ��"+s+w.genName()+"����");
		
		w.kill();
	}
}
