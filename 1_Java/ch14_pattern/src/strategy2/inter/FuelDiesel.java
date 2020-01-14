package strategy2.inter;

public class FuelDiesel implements IFuel {

	@Override
	public void fuel() {
		System.out.println("경유를 넣습니다.");
	}

}
