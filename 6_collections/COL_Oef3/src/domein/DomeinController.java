package domein;

public class DomeinController {
	private String gecodeerdBericht;
	private final CryptoGraphie crypto;


	public DomeinController() {
		crypto = new CryptoGraphie();
	}

	public void codeerBericht(String origineel){
		this.gecodeerdBericht = this.crypto.codeerBericht(origineel);

	}

	public String getGecodeerdBericht() {
		return gecodeerdBericht;
	}
}
